package financial.report.view.pdfView;
import financial.report.presenter.printPresenter.FinancialReportPrintModel;
import financial.report.presenter.printPresenter.IFinancialReportPrintView;
import interfaces.IJsonParser;

public class FinancialReportPrintView implements IFinancialReportPrintView {
  private IJsonParser jsonParser;

  public FinancialReportPrintView(IJsonParser jsonParser) {
    this.jsonParser = jsonParser;
  }
  
  @Override
  public String createFinancialReportPrintView(FinancialReportPrintModel financialReportPrintModel) {
    return this.jsonParser.createJson(financialReportPrintModel);
  }
}
