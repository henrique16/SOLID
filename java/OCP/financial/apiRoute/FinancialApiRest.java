package financial.apiRoute;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import financial.report.PresentFinancialReport;
import financial.report.controller.FinancialReportPresenterType;
import financial.report.interfaces.FinancialReportRequest;
import interfaces.ApiRestMap;
import interfaces.IApiRestAdapter;

public class FinancialApiRest implements IApiRestAdapter {
  private ApiRestMap apiRestMap;

  public FinancialApiRest() {
    this.apiRestMap = new ApiRestMap(new HashMap<String, HttpHandler>());
  }

  @Override
  public ApiRestMap getRoutes() {
    this.apiRestMap.routes.put("/financial/getWebViewReport", this::getWebViewReport);
    this.apiRestMap.routes.put("/financial/getPDFViewReport", this::getPDFViewReport);

    return this.apiRestMap;
  }

  private void getWebViewReport(HttpExchange exchange) throws IOException {
    System.out.println("query: " + exchange.getRequestURI().getQuery());
    System.out.println("requestBody: " + exchange.getRequestBody().read());
    System.out.println("requestHeaders: " + exchange.getRequestHeaders().entrySet().toString());
    PresentFinancialReport presentFinancialReport = new PresentFinancialReport(
      FinancialReportPresenterType.WEB, 
      new FinancialReportRequest(1)
    );
    String response = presentFinancialReport.execute();

    exchange.sendResponseHeaders(200, response.getBytes().length);

    try (OutputStream os = exchange.getResponseBody()) {
      os.write(response.getBytes());
    }
  }

  private void getPDFViewReport(HttpExchange exchange) throws IOException {
    System.out.println("query: " + exchange.getRequestURI().getQuery());
    System.out.println("requestBody: " + exchange.getRequestBody().read());
    System.out.println("requestHeaders: " + exchange.getRequestHeaders().entrySet().toString());
    PresentFinancialReport presentFinancialReport = new PresentFinancialReport(
      FinancialReportPresenterType.PDF, 
      new FinancialReportRequest(2)
    );
    String response = presentFinancialReport.execute();

    exchange.sendResponseHeaders(200, response.getBytes().length);

    try (OutputStream os = exchange.getResponseBody()) {
      os.write(response.getBytes());
    }
  }
}
