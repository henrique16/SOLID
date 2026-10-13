package apiRest;
import java.util.ArrayList;
import java.util.HashMap;
import com.sun.net.httpserver.HttpHandler;
import interfaces.ApiRestMap;
import interfaces.IApiRestAdapter;

public class ApiRest implements IApiRestAdapter {
  private ArrayList<IApiRestAdapter> apiRestAdapters;
  private ApiRestMap apiRestMap; 

  public ApiRest(ArrayList<IApiRestAdapter> apiRestAdapters) {
    this.apiRestAdapters = apiRestAdapters;
    this.apiRestMap = new ApiRestMap(new HashMap<String, HttpHandler>());
  }

  @Override
  public ApiRestMap getRoutes() {
    this.apiRestAdapters.forEach(apiRestAdapter -> {
      this.apiRestMap.routes.putAll(apiRestAdapter.getRoutes().routes);
    });

    return apiRestMap;
  }
}
