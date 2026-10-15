import financial.apiRest.FinancialApiRest;
import financial.report.FinancialReport;
import financial.report.controller.IFinancialReportPresenter;
import financial.report.interfaces.FinancialReportGenerator;
import financial.report.interfaces.IFinancialReportDataGateway;
import financial.report.interfaces.IFinancialReportRequester;
import financial.report.presenter.printPresenter.FinancialReportPrintPresenter;
import financial.report.presenter.printPresenter.IFinancialReportPrintView;
import financial.report.presenter.webPresenter.FinancialReportWebPresenter;
import financial.report.presenter.webPresenter.IFinancialReportWebView;
import financial.report.repository.FinancialDataMap;
import financial.report.view.pdfView.FinancialReportPrintView;
import financial.report.view.webView.FinancialReportWebView;
import interfaces.ApiRestMap;
import interfaces.IApiRestAdapter;
import interfaces.IFileHandler;
import interfaces.IJsonParser;
import jsonParser.JsonParser;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import apiRest.ApiRest;
import fileHandler.JavaFileHandler;

public class Main {
  public static void main(String[] args) throws IOException {
    IJsonParser jsonParser = new JsonParser();
    IFileHandler fileHandler = new JavaFileHandler();
    IFinancialReportDataGateway financialReportDataGateway = new FinancialDataMap();

    IFinancialReportWebView financialReportWebView = new FinancialReportWebView(
      jsonParser, 
      fileHandler
    );

    IFinancialReportPrintView financialReportPdfView = new FinancialReportPrintView(
      jsonParser
    );

    IFinancialReportRequester financialReportRequester = new FinancialReportGenerator(
      financialReportDataGateway
    );

    IFinancialReportPresenter financialReportWebPresenter = new FinancialReportWebPresenter(
      financialReportWebView
    );

    IFinancialReportPresenter financialReportPdfPresenter = new FinancialReportPrintPresenter(
      financialReportPdfView
    );

    FinancialReport financialReport = new FinancialReport(
      financialReportRequester,
      financialReportWebPresenter,
      financialReportPdfPresenter
    );
    
    ArrayList<IApiRestAdapter> arrayApiRestAdapters = new ArrayList<IApiRestAdapter>();
    IApiRestAdapter apiRestAdapter = new ApiRest(arrayApiRestAdapters);

    IApiRestAdapter financialApiRest = new FinancialApiRest(
      financialReport,
      financialReportWebView
    );

    arrayApiRestAdapters.add(financialApiRest);

    InetSocketAddress inetSocketAddress = new InetSocketAddress(8080);
    HttpServer server = HttpServer.create(inetSocketAddress, 0);

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
}
