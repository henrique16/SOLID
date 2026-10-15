package financial.apiRoute;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import financial.report.FinancialReport;
import financial.report.controller.FinancialReportPresenterType;
import financial.report.interfaces.FinancialReportRequest;
import financial.report.presenter.webPresenter.IFinancialReportWebView;
import interfaces.ApiRestMap;
import interfaces.IApiRestAdapter;

public class FinancialApiRest implements IApiRestAdapter {
  private ApiRestMap apiRestMap;
  private FinancialReport financialReport;
  private IFinancialReportWebView financialReportWebView;

  public FinancialApiRest(
    FinancialReport financialReport, 
    IFinancialReportWebView financialReportWebView
  ) {
    this.financialReport = financialReport;
    this.financialReportWebView = financialReportWebView;
    this.apiRestMap = new ApiRestMap(new HashMap<String, HttpHandler>());
  }

  @Override
  public ApiRestMap getRoutes() {
    this.apiRestMap.routes.put("/financial/getWebViewReport", this::getWebViewReport);
    this.apiRestMap.routes.put("/financial/script/getWebViewReport/index.js", this::getWebViewJsContent);
    this.apiRestMap.routes.put("/financial/getPDFViewReport", this::getPDFViewReport);

    return this.apiRestMap;
  }

  private void getWebViewReport(HttpExchange exchange) throws IOException {
    FinancialReportRequest financialReportRequest = new FinancialReportRequest(1);
    String response = this.financialReport.presentFinancialReport(FinancialReportPresenterType.WEB, financialReportRequest);

    exchange.getResponseHeaders().set("Content-Type", "text/html");
    exchange.sendResponseHeaders(200, response.getBytes().length);

    try (OutputStream os = exchange.getResponseBody()) {
      os.write(response.getBytes());
    }
  }

  private void getWebViewJsContent(HttpExchange exchange) throws IOException {
    String response = this.financialReportWebView.getJsContent();

    exchange.getResponseHeaders().set("Content-Type", "text/javascript");
    exchange.sendResponseHeaders(200, response.getBytes().length);

    try (OutputStream os = exchange.getResponseBody()) {
      os.write(response.getBytes());
    }
  }

  private void getPDFViewReport(HttpExchange exchange) throws IOException {
    FinancialReportRequest financialReportRequest = new FinancialReportRequest(2);
    String response = this.financialReport.presentFinancialReport(FinancialReportPresenterType.PDF, financialReportRequest);

    exchange.sendResponseHeaders(200, response.getBytes().length);

    try (OutputStream os = exchange.getResponseBody()) {
      os.write(response.getBytes());
    }
  }
}
