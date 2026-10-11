package financial.report.controller;
import financial.report.interfaces.FinancialReportAnswer;
import financial.report.interfaces.FinancialReportRequest;
import financial.report.interfaces.FinancialReportRequester;

public class FinancialReportController {
  private FinancialReportRequester financialReportRequester;
  private FinancialReportPresenter financialReportPresenter;

  public FinancialReportController(
    FinancialReportRequester financialReportRequester,
    FinancialReportPresenter financialReportPresenter
  ) {
    this.financialReportRequester = financialReportRequester;
    this.financialReportPresenter = financialReportPresenter;
  }

  public <T extends FinancialReportRequest> void presentFinancialReport(T financialReportRequest) {
    FinancialReportAnswer financialReportAnswer = this.financialReportRequester.getFinancialReport(financialReportRequest);
    this.financialReportPresenter.presentFinancialReport(financialReportAnswer);
  }
}
