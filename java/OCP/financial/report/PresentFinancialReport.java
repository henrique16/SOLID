package financial.report;
import financial.report.controller.FinancialReportController;
import financial.report.controller.IFinancialReportPresenter;
import financial.report.controller.FinancialReportPresenterType;
import financial.report.interfaces.IFinancialReportDataGateway;
import financial.report.interfaces.FinancialReportGenerator;
import financial.report.interfaces.FinancialReportRequest;
import financial.report.interfaces.IFinancialReportRequester;
import financial.report.presenter.printPresenter.FinancialReportPrintPresenter;
import financial.report.presenter.webPresenter.FinancialReportWebPresenter;
import financial.report.repository.FinancialDataMap;
import financial.report.view.pdfView.FinancialReportPrintView;
import financial.report.view.webView.FinancialReportWebView;
import interfaces.IJsonParser;
import jsonParser.JsonParser;

// Facade
public class PresentFinancialReport {
  private FinancialReportPresenterType financialReportPresenterType;
  private FinancialReportRequest financialReportRequest;

  public PresentFinancialReport(
    FinancialReportPresenterType financialReportPresenterType,
    FinancialReportRequest financialReportRequest
  ) {
    this.financialReportPresenterType = financialReportPresenterType;
    this.financialReportRequest = financialReportRequest;
  }

  public String execute() {
    IFinancialReportDataGateway financialReportDataGateway = new FinancialDataMap();
    IFinancialReportRequester financialReportRequester = new FinancialReportGenerator(financialReportDataGateway);
    IFinancialReportPresenter financialReportPresenter = this.mapPresenterByType(this.financialReportPresenterType);

    FinancialReportController financialReportController = new FinancialReportController(
      financialReportRequester,
      financialReportPresenter
    );
    return financialReportController.presentFinancialReport(this.financialReportRequest);
  }

  private IFinancialReportPresenter mapPresenterByType(FinancialReportPresenterType financialReportPresenterType) {
    IFinancialReportPresenter financialReportPresenter;
    IJsonParser jsonParser = new JsonParser();

    switch (this.financialReportPresenterType) {
      case WEB:
        FinancialReportWebView financialReportWebView = new FinancialReportWebView(jsonParser);
        financialReportPresenter = new FinancialReportWebPresenter(financialReportWebView);
        break;
      case PDF:
        FinancialReportPrintView financialReportPrintView = new FinancialReportPrintView(jsonParser);
        financialReportPresenter = new FinancialReportPrintPresenter(financialReportPrintView);
        break;
    
      default:
        financialReportWebView = new FinancialReportWebView(jsonParser);
        financialReportPresenter = new FinancialReportWebPresenter(financialReportWebView);
        break;
    }

    return financialReportPresenter;
  }
}
