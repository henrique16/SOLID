import financial.apiRoute.FinancialApiRest;
import interfaces.ApiRestMap;
import interfaces.IApiRestAdapter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import apiRest.ApiRest;

public class Main {
  public static void main(String[] args) throws IOException {
    ArrayList<IApiRestAdapter> arrayApiRestAdapters = new ArrayList<IApiRestAdapter>();
    IApiRestAdapter apiRestAdapter = new ApiRest(arrayApiRestAdapters);
    InetSocketAddress inetSocketAddress = new InetSocketAddress(8080);
    HttpServer server = HttpServer.create(inetSocketAddress, 0);

    Main.addApiRestAdapters(arrayApiRestAdapters);

    server.createContext("/", exchange -> {
      ApiRestMap apiRestMap = apiRestAdapter.getRoutes();
      String path = exchange.getRequestURI().getPath();
      System.out.println(path);
      HttpHandler httpHandler = apiRestMap.routes.get(path);

      if (httpHandler != null) {
        httpHandler.handle(exchange);

      } else {
        exchange.sendResponseHeaders(404, 0);
        try (OutputStream os = exchange.getResponseBody()) {
          os.write("Not found".getBytes());
        }
      }
    });

    server.start();
  }

  private static void addApiRestAdapters(ArrayList<IApiRestAdapter> arrayApiRestAdapters) {
    arrayApiRestAdapters.add(new FinancialApiRest());
  }
}
