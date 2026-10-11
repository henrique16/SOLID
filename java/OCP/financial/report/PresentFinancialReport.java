package financial.report;
import financial.report.controller.FinancialReportController;
import financial.report.controller.FinancialReportPresenter;
import financial.report.controller.FinancialReportPresenterType;
import financial.report.interfaces.FinancialReportAnswer;
import financial.report.interfaces.FinancialReportDataGateway;
import financial.report.interfaces.FinancialReportGenerator;
import financial.report.interfaces.FinancialReportRequest;
import financial.report.interfaces.FinancialReportRequester;
import financial.report.presenter.webPresenter.FinancialReportWebPresenter;
import financial.report.repository.FinancialDataMap;
import financial.report.view.webView.FinancialReportWebView;

// Facade Pattern
public class PresentFinancialReport {
  private FinancialReportPresenterType financialReportPresenterType;
  private FinancialReportRequest financialReportRequest;

  public PresentFinancialReport(
    FinancialReportPresenterType financialReportPresenterType,
    FinancialReportRequest financialReportRequest
  ) {
    this.financialReportPresenterType = financialReportPresenterType;
    this.financialReportRequest = financialReportRequest;
    this.execute();
  }

  private void execute() {
    FinancialReportDataGateway financialReportDataGateway = new FinancialDataMap();
    FinancialReportRequester financialReportRequester = new FinancialReportGenerator(financialReportDataGateway);
    FinancialReportPresenter financialReportPresenter;
    
    switch (this.financialReportPresenterType) {
      case WEB:
        FinancialReportWebView financialReportWebView = new FinancialReportWebView();
        financialReportPresenter = new FinancialReportWebPresenter(financialReportWebView);
        break;
      case PDF:
        financialReportPresenter = new D();
        break;
    
      default:
        financialReportWebView = new FinancialReportWebView();
        financialReportPresenter = new FinancialReportWebPresenter(financialReportWebView);
        break;
    }

    FinancialReportController financialReportController = new FinancialReportController(
      financialReportRequester,
      financialReportPresenter
    );
    financialReportController.presentFinancialReport(this.financialReportRequest);
  }
}

class B implements FinancialReportPresenter {
  @Override
  public <T extends FinancialReportAnswer> void presentFinancialReport(T financialReportAnswer) {
    throw new UnsupportedOperationException("Unimplemented method 'presentFinancialReport'");
  }
}

class D implements FinancialReportPresenter {
  @Override
  public <T extends FinancialReportAnswer> void presentFinancialReport(T financialReportAnswer) {
    throw new UnsupportedOperationException("Unimplemented method 'presentFinancialReport'");
  }
}
