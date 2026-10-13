package jsonParser;
import java.lang.reflect.Field;
import interfaces.IJsonParser;

public class JsonParser implements IJsonParser {
  @Override
  public String createJson(Object data) {
    Object dataObject = (Object) data;
    Class<?> currentClass = dataObject.getClass();
    String json = "{";

    while (currentClass != null) {
      Field[] fields = currentClass.getDeclaredFields();

      for (int i = 0; i < fields.length; i++) {
        Field field = fields[i];

        try {
          Object value = field.get(dataObject);
          json += "\"" + field.getName() + "\":" + "\"" + value + "\"";
          if (i != fields.length - 1) {
            json += ",";
          }

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
