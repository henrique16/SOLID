package financial.report.view.webView;
import financial.report.presenter.webPresenter.FinancialReportWebModel;
import financial.report.presenter.webPresenter.IFinancialReportWebView;
import interfaces.IJsonParser;

public class FinancialReportWebView implements IFinancialReportWebView {
  private IJsonParser jsonParser;

  public FinancialReportWebView(IJsonParser jsonParser) {
    this.jsonParser = jsonParser;
  }

  @Override
  public String createFinancialReportWebView(FinancialReportWebModel financialReportWebModel) {
    return this.jsonParser.createJson(financialReportWebModel);
  }
}
