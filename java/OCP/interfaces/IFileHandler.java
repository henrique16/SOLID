package interfaces;

public interface IFileHandler {
  /**
   * Read a file and return the content as a string
   * @param path /path/to/file.txt
   * @return the content of the file as a string
   */
  public String readFile(String path);
}
