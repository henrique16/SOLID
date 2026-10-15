package jsonParser.infrastructure;
import java.lang.reflect.Field;
import jsonParser.interfaces.IJsonParser;

public class UsJsonParser implements IJsonParser {
  @Override
  public String createJson(Object data) {
    Object dataObject = (Object) data;
    Class<?> currentClass = dataObject.getClass();
    boolean firstField = true;
    String json = "{";

    while (currentClass != null) {
      Field[] fields = currentClass.getDeclaredFields();

      for (Field field : fields) {
        try {
          Object value = field.get(dataObject);
          if (!firstField) {
            json += ",";
          }
          json += "\"" + field.getName() + "\":" + "\"" + value + "\"";
          firstField = false;

        } catch (Exception e) {
          System.err.println(e);
        }
      }

      currentClass = currentClass.getSuperclass();
    }
    json += "}";

    return json;
  }
}
