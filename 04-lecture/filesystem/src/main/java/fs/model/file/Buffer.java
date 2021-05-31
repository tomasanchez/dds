package fs.model.file;

/**
 * Writting buffer.
 */
public class Buffer {

  /**
   * Los bytes of the buffer.
   */
  private byte[] bytes;

  /**
   * Las index used on the buffer.
   */
  private Integer start;

  /**
   * The buffer current size.
   */
  private Integer limit;

  /**
   * The max size that the buffer can have.
   */
  private Integer maxSize;

  /**
   * The end of the buffer.
   */
  private Integer end;

  /**
   * Generates a buffer.
   * 
   * @param size the size of the buffer.
   */
  public Buffer(Integer size) {
    this.limit = this.maxSize = size;
    this.bytes = new byte[size];
    this.start = 0;
    this.end = -1;
  }

  /**
   * Updates the limit of the buffer.
   * 
   * @param amount the amount to increment
   */
  public void limit(Integer amount) {
    this.limit = this.start + amount;
  }

  public void setEnd(Integer amount) {
    this.end += amount;
  }

  public byte[] getBytes() {
    return bytes.clone();
  }

  public void setBytes(byte[] bytes) {
    this.bytes = bytes.clone();
  }

  public Integer getCurrentSize() {
    return this.limit;
  }

  public Integer getStart() {
    return this.start;
  }

  public Integer getMaxSize() {
    return this.maxSize;
  }

  public Integer getEnd() {
    return this.end;
  }

}
