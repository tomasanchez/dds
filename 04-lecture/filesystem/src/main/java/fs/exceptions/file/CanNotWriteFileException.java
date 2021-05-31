package fs.exceptions.file;

/**
 * File exception.
 */
public class CanNotWriteFileException extends RuntimeException {

  /**
   * Throws a new Can not write file.
   * 
   * @param cause the cause of failure.
   * @throws RuntimeException if file could not be write.
   */
  public CanNotWriteFileException(String cause) {
    super("Couldn't write file: " + cause);
  }

}
