package financial.report.view.webView;
import fileHandler.interfaces.IFileHandler;
import financial.report.presenter.webPresenter.FinancialReportWebModel;
import financial.report.presenter.webPresenter.IFinancialReportWebView;
import jsonParser.interfaces.IJsonParser;

public class FinancialReportWebView implements IFinancialReportWebView {
  private IJsonParser jsonParser;
  private IFileHandler fileHandler;
  private String htmlPath = "src/main/java/financial/report/view/webView/html/index.html";
  private String jsPath = "src/main/java/financial/report/view/webView/js/index.js";

  public FinancialReportWebView(IJsonParser jsonParser, IFileHandler fileHandler) {
    this.jsonParser = jsonParser;
    this.fileHandler = fileHandler;
  }

  @Override
  public String createFinancialReportWebView(FinancialReportWebModel financialReportWebModel) {
    String json = this.jsonParser.createJson(financialReportWebModel);
    String html = this.fileHandler.readFile(this.htmlPath);

    html = html.replace("{{data}}", "var data = " + json + ";");
    return html;
  }

  @Override
  public String getJsContent() {
    String js = this.fileHandler.readFile(this.jsPath);
    return js;
  }
}
