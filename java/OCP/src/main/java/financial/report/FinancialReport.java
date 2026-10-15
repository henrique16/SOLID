package financial.report;
import financial.report.controller.FinancialReportController;
import financial.report.controller.FinancialReportPresenterType;
import financial.report.controller.IFinancialReportPresenter;
import financial.report.interfaces.FinancialReportRequest;
import financial.report.interfaces.IFinancialReportRequester;

public class FinancialReport {
  private IFinancialReportRequester financialReportRequester;
  private IFinancialReportPresenter financialReportWebPresenter;
  private IFinancialReportPresenter financialReportPdfPresenter;
  private FinancialReportController webFinancialReportController;
  private FinancialReportController pdfFinancialReportController;

  public FinancialReport(
    IFinancialReportRequester financialReportRequester,
    IFinancialReportPresenter financialReportWebPresenter,
    IFinancialReportPresenter financialReportPdfPresenter
  ) {
    this.financialReportRequester = financialReportRequester;
    this.financialReportWebPresenter = financialReportWebPresenter;
    this.financialReportPdfPresenter = financialReportPdfPresenter;
    this.webFinancialReportController = new FinancialReportController(
      this.financialReportRequester, 
      this.financialReportWebPresenter
    );
    this.pdfFinancialReportController = new FinancialReportController(
      this.financialReportRequester, 
      this.financialReportPdfPresenter
    );
  }

  public <T extends FinancialReportRequest, R> R presentFinancialReport(FinancialReportPresenterType financialReportPresenterType, T financialReportRequest) {
    switch (financialReportPresenterType) {
      case WEB:
        return this.webFinancialReportController.presentFinancialReport(financialReportRequest);
    
      case PDF:
        return this.pdfFinancialReportController.presentFinancialReport(financialReportRequest);

      default:
        throw new IllegalArgumentException("Financial report presenter type not supported");
    }
  }
}
