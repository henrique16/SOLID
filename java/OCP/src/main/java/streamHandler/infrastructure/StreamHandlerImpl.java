package streamHandler.infrastructure;
import java.io.ByteArrayOutputStream;
import streamHandler.interfaces.IStreamHandler;

public class StreamHandlerImpl implements IStreamHandler {
  @Override
  public ByteArrayOutputStream getByteArrayOutputStream() {
    return new ByteArrayOutputStream();
  }
}
