package financial.report.controller;
import financial.report.interfaces.FinancialReportAnswer;

public interface IFinancialReportPresenter {
  public <T extends FinancialReportAnswer, R> R presentFinancialReport(T financialReportAnswer);
}
