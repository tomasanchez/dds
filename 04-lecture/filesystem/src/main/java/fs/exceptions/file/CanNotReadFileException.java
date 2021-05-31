package fs.exceptions.file;

/**
 * File exceptions.
 */
public class CanNotReadFileException extends RuntimeException {

  /**
   * Throws a new Can not read file.
   * 
   * @param cause the cause of failure.
   * @throws RuntimeException if file could not be read.
   */
  public CanNotReadFileException(String cause) {
    super("Couldn't read file: " + cause);
  }
}
