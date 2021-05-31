package fs.exceptions.file;

/**
 * File exceptions.
 */
public class CanNotCloseFileException extends RuntimeException {

  /**
   * Throws a new Can not close file.
   * 
   * @param cause the cause of failure.
   * @throws RuntimeException if file could not be closed.
   */
  public CanNotCloseFileException(String cause) {
    super("Couldn't close file: " + cause);
  }
}
