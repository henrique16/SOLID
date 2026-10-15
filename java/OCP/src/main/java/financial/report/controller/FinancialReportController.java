package financial.report.controller;
import financial.report.interfaces.FinancialReportAnswer;
import financial.report.interfaces.FinancialReportRequest;
import financial.report.interfaces.IFinancialReportRequester;

public class FinancialReportController {
  private IFinancialReportRequester financialReportRequester;
  private IFinancialReportPresenter financialReportPresenter;

  public FinancialReportController(
    IFinancialReportRequester financialReportRequester,
    IFinancialReportPresenter financialReportPresenter
  ) {
    this.financialReportRequester = financialReportRequester;
    this.financialReportPresenter = financialReportPresenter;
  }

  public <T extends FinancialReportRequest, R> R presentFinancialReport(T financialReportRequest) {
    FinancialReportAnswer financialReportAnswer = this.financialReportRequester.getFinancialReport(financialReportRequest);
    return this.financialReportPresenter.presentFinancialReport(financialReportAnswer);
  }
}
