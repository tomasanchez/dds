package fs.model.file;

import fs.exceptions.file.CanNotCloseFileException;
import fs.exceptions.file.CanNotOpenFileException;
import fs.exceptions.file.CanNotReadFileException;
import fs.exceptions.file.CanNotWriteFileException;
import fs.model.filesystem.LowLevelFileSystem;
import java.util.Objects;

/**
 * Open file.
 */
public class File {

  /**
   * Invalid file descriptor.
   */
  private static final Integer ERROR = -1;

  /**
   * The file descriptor.
   */
  private Integer fd = ERROR;

  /**
   * The file system.
   */
  LowLevelFileSystem fs;

  public File(LowLevelFileSystem fs, String path) {

    validatePath(fs, path);

    this.setFs(fs);
  }

  public void setFd(Integer fd) {
    this.fd = fd;
  }

  public LowLevelFileSystem getFs() {
    return fs;
  }

  public void setFs(LowLevelFileSystem fs) {
    this.fs = fs;
  }


  /**
   * Verifies if path is valid.
   * 
   * @param fs the filesystem interface
   * @param path the path to verify
   * @throws CanNotOpenFileException if file cannot be opened
   */
  private void validatePath(LowLevelFileSystem fs, String path) {

    if (!fs.exists(path)) {
      throw new CanNotOpenFileException("File " + path + " does not exist!");
    }

    if (fs.isDirectory(path)) {
      throw new CanNotOpenFileException(path + " is a driectory not a file");
    }

    this.setFd(fs.openFile(path));
    if (this.fd.equals(ERROR)) {
      throw new CanNotOpenFileException("Faield to open file: " + path);
    }

  }

  /**
   * Closes the file.
   * 
   * @throws CanNotOpenFileException when file was never opened.
   */
  public void close() {

    if (fd.equals(ERROR)) {
      throw new CanNotCloseFileException("File was never opened");
    }

    this.fs.closeFile(this.getDescriptor());

    this.fd = ERROR;

  }

  /**
   * Gets the file descriptor.
   * 
   * @return the file descriptor
   */
  public Integer getDescriptor() {
    return fd;
  }

  /**
   * Syncronic Reads the open file in a buffer.
   * 
   * @param buffer the buffer to be read to.
   */
  public void read(Buffer buffer) {
    Integer bytes =
        fs.syncReadFile(fd, buffer.getBytes(), buffer.getStart(), buffer.getCurrentSize());

    updateBuffer(buffer, bytes);
  }

  /**
   * Async read of a file.
   * 
   * @param buffer the buffer to be read to.
   * @param callback the execution block
   */
  public void read(Buffer buffer, Runnable callback) {
    fs.asyncReadFile(fd, buffer.getBytes(), buffer.getStart(), buffer.getCurrentSize(), (bytes) -> {
      updateBuffer(buffer, bytes);
      callback.run();
    });
  }

  /**
   * Syncronic write of a buffer.
   * 
   * @param buffer the buffer tp write
   */
  public void write(Buffer buffer) {

    verifyFdForWritting();

    if (Objects.isNull(buffer)) {
      return;
    }

    fs.syncWriteFile(fd, buffer.getBytes(), buffer.getStart(), buffer.getCurrentSize());
  }

  /**
   * Async write of a buffer.
   * 
   * @param buffer the buffer to write
   * @param callback a runnable
   */
  public void write(Buffer buffer, Runnable callback) {

    verifyFdForWritting();

    if (Objects.isNull(buffer)) {
      return;
    }

    fs.asyncWriteFile(fd, buffer.getBytes(), buffer.getStart(), buffer.getCurrentSize(), callback);
  }


  /**
   * Verifies if the File-descriptor is OK.
   * 
   * @throws CanNotWriteFileException when the file descriptor is not OK.
   */
  private void verifyFdForWritting() {
    if (fd.equals(ERROR)) {
      throw new CanNotWriteFileException("No file to write in");
    }
  }

  /**
   * Validates bytes
   * 
   * @param bytes the bytes to verify
   * @throws CanNotReadFileException when an error occured while reading.
   */
  private void verifyBytes(Integer bytes) {
    if (bytes.equals(ERROR)) {
      throw new CanNotReadFileException("Buffer could not be written");
    }
  }

  /**
   * Updates the buffer's offset with the bytes.
   * 
   * @param buffer the buffer to modify
   * @param bytes the bytes to update
   */
  private void updateBuffer(Buffer buffer, Integer bytes) {
    verifyBytes(bytes);
    buffer.setEnd(bytes);
    buffer.limit(bytes);
  }

}
