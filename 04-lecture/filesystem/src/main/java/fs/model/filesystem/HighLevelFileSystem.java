package fs.model.filesystem;

import fs.model.file.File;

public class HighLevelFileSystem {

  private LowLevelFileSystem fs;

  public HighLevelFileSystem(LowLevelFileSystem lowLevelFileSystem) {
    this.setFs(lowLevelFileSystem);
  }

  public void setFs(LowLevelFileSystem lowLevelFileSystem) {
    this.fs = lowLevelFileSystem;
  }

  public File open(String path) {
    return new File(fs, path);
  }

  public boolean isFile(String path) {
    return this.fs.isRegularFile(path);
  }

  public boolean isDirectory(String path) {
    return this.fs.isDirectory(path);
  }

  public boolean exists(String path) {
    return this.fs.exists(path);
  }

}
