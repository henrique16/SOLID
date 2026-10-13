package financial.report.presenter.webPresenter;
import financial.report.controller.IFinancialReportPresenter;
import financial.report.interfaces.FinancialReportAnswer;

public class FinancialReportWebPresenter implements IFinancialReportPresenter {
  private IFinancialReportWebView financialReportWebView;

  public FinancialReportWebPresenter(IFinancialReportWebView financialReportWebView) {
    this.financialReportWebView = financialReportWebView;
  }

  @Override
  public <T extends FinancialReportAnswer> String presentFinancialReport(T financialReportAnswer) {
    FinancialReportWebModel financialReportWebModel = new FinancialReportWebModel(
      financialReportAnswer.amount,
      financialReportAnswer.description,
      "Financial Report",
      "This is a financial report"
    );
    return this.financialReportWebView.createFinancialReportWebView(financialReportWebModel);
  }
}
