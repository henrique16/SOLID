package financial.report.view.webView;
import financial.report.presenter.webPresenter.FinancialReportWebModel;
import financial.report.presenter.webPresenter.IFinancialReportWebView;
import interfaces.IFileHandler;
import interfaces.IJsonParser;

public class FinancialReportWebView implements IFinancialReportWebView {
  private IJsonParser jsonParser;
  private IFileHandler fileHandler;

  public FinancialReportWebView(IJsonParser jsonParser, IFileHandler fileHandler) {
    this.jsonParser = jsonParser;
    this.fileHandler = fileHandler;
  }

  @Override
  public String createFinancialReportWebView(FinancialReportWebModel financialReportWebModel) {
    String json = this.jsonParser.createJson(financialReportWebModel);
    String html = this.fileHandler.readFile("financial/report/view/webView/html/index.html");

    html = html.replace("{{data}}", "var data = " + json + ";");
    return html;
  }

  @Override
  public String getJsContent() {
    String js = this.fileHandler.readFile("financial/report/view/webView/js/index.js");
    return js;
  }
}
