package fs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import fs.exceptions.file.CanNotCloseFileException;
import fs.exceptions.file.CanNotOpenFileException;
import fs.exceptions.file.CanNotReadFileException;
import fs.model.file.Buffer;
import fs.model.file.File;
import fs.model.filesystem.HighLevelFileSystem;
import fs.model.filesystem.LowLevelFileSystem;
import java.util.Arrays;
import java.util.function.Consumer;
import static org.mockito.Mockito.*;

class HighLevelFileSystemTest {

  private LowLevelFileSystem lowLevelFileSystem;
  private HighLevelFileSystem fileSystem;

  @BeforeEach
  void initFileSystem() {
    lowLevelFileSystem = mock(LowLevelFileSystem.class);
    fileSystem = new HighLevelFileSystem(lowLevelFileSystem);
  }

  @Test
  void sePuedeAbrirUnArchivo() {
    when(lowLevelFileSystem.openFile("unArchivo.txt")).thenReturn(42);
    // Agrego condicion de que existe el archivo
    when(lowLevelFileSystem.exists("unArchivo.txt")).thenReturn(true);
    File file = fileSystem.open("unArchivo.txt");
    Assertions.assertEquals(file.getDescriptor(), 42);
  }

  @Test
  void siLaAperturaFallaUnaExcepcionEsLanzada() {
    when(lowLevelFileSystem.openFile("otroArchivo.txt")).thenReturn(-1);
    Assertions.assertThrows(CanNotOpenFileException.class,
        () -> fileSystem.open("otroArchivo.txt"));
  }

  @Test
  void sePuedeLeerSincronicamenteUnArchivoCuandoNoHayNadaParaLeer() {
    Buffer buffer = new Buffer(100);

    when(lowLevelFileSystem.openFile("ejemplo.txt")).thenReturn(42);
    // Agrego condicion de que existe el archivo
    when(lowLevelFileSystem.exists("ejemplo.txt")).thenReturn(true);
    when(lowLevelFileSystem.syncReadFile(42, buffer.getBytes(), 0, 100)).thenReturn(0);

    File file = fileSystem.open("ejemplo.txt");
    file.read(buffer);

    Assertions.assertEquals(0, buffer.getStart());
    Assertions.assertEquals(-1, buffer.getEnd());
    Assertions.assertEquals(0, buffer.getCurrentSize());
  }

  @Test
  void sePuedeLeerSincronicamenteUnArchivoCuandoHayAlgoParaLeer() {
    Buffer buffer = new Buffer(10);

    when(lowLevelFileSystem.openFile("ejemplo.txt")).thenReturn(42);
    // Agrego condicion de que existe el archivo
    when(lowLevelFileSystem.exists("ejemplo.txt")).thenReturn(true);
    when(lowLevelFileSystem.syncReadFile(42, buffer.getBytes(), 0, 10)).thenAnswer(invocation -> {
      byte[] bytes = buffer.getBytes();
      Arrays.fill(bytes, 0, 4, (byte) 3);
      buffer.setBytes(bytes);
      return 4;
    });

    File file = fileSystem.open("ejemplo.txt");
    file.read(buffer);

    Assertions.assertEquals(0, buffer.getStart());
    Assertions.assertEquals(3, buffer.getEnd());
    Assertions.assertEquals(4, buffer.getCurrentSize());
    Assertions.assertArrayEquals(buffer.getBytes(), new byte[] {3, 3, 3, 3, 0, 0, 0, 0, 0, 0});
  }

  @Test
  void siLaLecturaSincronicaFallaUnaExcepciónEsLanzada() {
    Buffer buffer = new Buffer(10);

    when(lowLevelFileSystem.openFile("archivoMalito.txt")).thenReturn(13);
    // Agrego condicion de que existe el archivo
    when(lowLevelFileSystem.exists("archivoMalito.txt")).thenReturn(true);
    when(lowLevelFileSystem.syncReadFile(anyInt(), any(), anyInt(), anyInt())).thenReturn(-1);

    File file = fileSystem.open("archivoMalito.txt");

    Assertions.assertThrows(CanNotReadFileException.class, () -> file.read(buffer));
  }

  @Test
  void sePuedeEscribirSincronicamenteUnArchivoCuandoHayNoHayNadaParaEscribir() {

    when(lowLevelFileSystem.openFile("test.txt")).thenReturn(67);
    // Agrego condicion de que existe el archivo
    when(lowLevelFileSystem.exists("test.txt")).thenReturn(true);

    File file = fileSystem.open("test.txt");

    Assertions.assertDoesNotThrow(() -> file.write(null));
  }

  @Test
  void sePuedeEscribirSincronicamenteUnArchivoCuandoHayAlgoParaEscribir() {

    when(lowLevelFileSystem.openFile("test.txt")).thenReturn(67);
    // Agrego condicion de que existe el archivo
    when(lowLevelFileSystem.exists("test.txt")).thenReturn(true);

    File file = fileSystem.open("test.txt");

    Assertions.assertDoesNotThrow(() -> file.write(new Buffer(200)));
  }

  @Test
  void sePuedeLeerAsincronicamenteUnArchivo() {

    Buffer buffer = new Buffer(10);

    when(lowLevelFileSystem.openFile("test.txt")).thenReturn(67);
    // Agrego condicion de que existe el archivo
    when(lowLevelFileSystem.exists("test.txt")).thenReturn(true);

    File file = fileSystem.open("test.txt");

    file.read(buffer, () -> {

    });

    verify(lowLevelFileSystem).asyncReadFile(anyInt(), any(byte[].class), anyInt(), anyInt(),
        any(Consumer.class));

  }

  @Test
  void sePuedeEscribirAsincronicamenteUnArchivo() {
    Buffer buffer = new Buffer(10);

    when(lowLevelFileSystem.openFile("test.txt")).thenReturn(67);
    // Agrego condicion de que existe el archivo
    when(lowLevelFileSystem.exists("test.txt")).thenReturn(true);

    File file = fileSystem.open("test.txt");

    file.write(buffer);
  }

  @Test
  void sePuedeCerrarUnArchivo() {

    when(lowLevelFileSystem.openFile("test.txt")).thenReturn(67);
    // Agrego condicion de que existe el archivo
    when(lowLevelFileSystem.exists("test.txt")).thenReturn(true);

    File file = fileSystem.open("test.txt");

    file.close();

    verify(lowLevelFileSystem).closeFile(67);
  }

  @Test
  void sePuedeSaberSiUnPathEsUnArchivoRegular() {
    when(lowLevelFileSystem.isRegularFile("test.txt")).thenReturn(true);
    Assertions.assertTrue(fileSystem.isFile("test.txt"));
  }

  @Test
  void sePuedeSaberSiUnPathEsUnDirectorio() {
    when(lowLevelFileSystem.isDirectory("test.txt")).thenReturn(false);
    Assertions.assertFalse(fileSystem.isFile("test.txt"));
  }

  @Test
  void sePuedeSaberSiUnPathExiste() {
    when(lowLevelFileSystem.exists("test.txt")).thenReturn(true);
    Assertions.assertTrue(fileSystem.exists("test.txt"));
  }

  @Test
  void noSePuedeCerrarArchivoYaCerrado() {
    when(lowLevelFileSystem.exists("test.txt")).thenReturn(true);
    File file = fileSystem.open("test.txt");
    file.close();
    Assertions.assertThrows(CanNotCloseFileException.class, () -> {
      file.close();
    });
  }
}
