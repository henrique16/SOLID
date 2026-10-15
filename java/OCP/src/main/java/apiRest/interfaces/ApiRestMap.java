package apiRest.interfaces;
import java.util.Map;
import com.sun.net.httpserver.HttpHandler;

public class ApiRestMap {
  public Map<String, HttpHandler> routes;

  public ApiRestMap(Map<String, HttpHandler> routes) {
    this.routes = routes;
  }
}
