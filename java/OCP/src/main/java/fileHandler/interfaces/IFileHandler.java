package fileHandler.interfaces;

public interface IFileHandler {
  /**
   * Read a file and return the content as a string
   * @param path /path/to/file.txt
   * @return the content of the file as a string
   */
  public String readFile(String path);

  /**
   * Read a file and return the content as a byte array
   * @param path /path/to/file.txt
   * @return the content of the file as a byte array
   */
  public byte[] readFileAsBytes(String path);
}
