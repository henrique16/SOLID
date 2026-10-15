package financial.report.presenter.printPresenter;

public interface IFinancialReportPrintView {
  public byte[] createFinancialReportPrintView(FinancialReportPrintModel financialReportPrintModel);
}
