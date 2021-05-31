package fs.exceptions.file;

/**
 * File exceptions.
 */
public class CanNotOpenFileException extends RuntimeException {

  /**
   * Throws a new Can not open file.
   * 
   * @param cause the cause of failure.
   * @throws RuntimeException if file could not be opened.
   */
  public CanNotOpenFileException(String cause) {
    super("Couldn't open file: " + cause);
  }
}
