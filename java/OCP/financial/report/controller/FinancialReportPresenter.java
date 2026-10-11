package financial.report.controller;
import financial.report.interfaces.FinancialReportAnswer;

public interface FinancialReportPresenter {
  public <T extends FinancialReportAnswer> void presentFinancialReport(T financialReportAnswer);
}
