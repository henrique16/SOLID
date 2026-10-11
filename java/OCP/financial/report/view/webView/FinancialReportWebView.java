package financial.report.view.webView;
import financial.report.presenter.webPresenter.FinancialReportWebModel;

public class FinancialReportWebView implements financial.report.presenter.webPresenter.FinancialReportWebView {
  @Override
  public void createFinancialReportWebView(FinancialReportWebModel financialReportWebModel) {
    System.out.println(financialReportWebModel.amount);
    System.out.println(financialReportWebModel.description);
    System.out.println(financialReportWebModel.title);
    System.out.println(financialReportWebModel.content);
  }
}
