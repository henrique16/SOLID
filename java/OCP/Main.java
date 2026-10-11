import financial.report.PresentFinancialReport;
import financial.report.controller.FinancialReportPresenterType;
import financial.report.interfaces.FinancialReportRequest;

public class Main {
  public static void main(String[] args) {
    new PresentFinancialReport(
      FinancialReportPresenterType.WEB, 
      new FinancialReportRequest(1)
    );
  }
}
