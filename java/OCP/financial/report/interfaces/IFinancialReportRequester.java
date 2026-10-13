package financial.report.interfaces;

public interface IFinancialReportRequester {
  public <T extends FinancialReportAnswer, T2 extends FinancialReportRequest> T getFinancialReport(T2 request);
}
