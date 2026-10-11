package financial.report.presenter.webPresenter;
import financial.report.controller.FinancialReportPresenter;
import financial.report.interfaces.FinancialReportAnswer;

public class FinancialReportWebPresenter implements FinancialReportPresenter {
  private FinancialReportWebView financialReportWebView;

  public FinancialReportWebPresenter(FinancialReportWebView financialReportWebView) {
    this.financialReportWebView = financialReportWebView;
  }

  @Override
  public <T extends FinancialReportAnswer> void presentFinancialReport(T financialReportAnswer) {
    FinancialReportWebModel financialReportWebModel = new FinancialReportWebModel(
      financialReportAnswer.amount,
      financialReportAnswer.description,
      "Financial Report",
      "This is a financial report"
    );
    this.financialReportWebView.createFinancialReportWebView(financialReportWebModel);
  }
}
