package fileHandler;
import interfaces.IFileHandler;
import java.nio.file.Files;
import java.nio.file.Path;

public class JavaFileHandler implements IFileHandler {

  @Override
  public String readFile(String path) {

    
    try {
      Path filePath = Path.of(path);
      String content = Files.readString(filePath);
      return content;

    } catch (Exception e) {
      System.out.println(e);
      e.printStackTrace();
      throw new RuntimeException("File not found");
    }
  }
}
