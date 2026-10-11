package financial.report.interfaces;

public class FinancialReportGenerator implements FinancialReportRequester {
  private FinancialReportDataGateway financialReportDataGateway;

  public FinancialReportGenerator(FinancialReportDataGateway financialReportDataGateway) {
    this.financialReportDataGateway = financialReportDataGateway;
  }

  public <T extends FinancialReportAnswer, T2 extends FinancialReportRequest> T getFinancialReport(T2 request) {
    Integer financialId = request.id;
    FinancialEntity financialEntity = this.financialReportDataGateway.getById(financialId);
    FinancialReportAnswer financialReportAnswer = new FinancialReportAnswer(financialEntity.amount, financialEntity.description);
    return (T) financialReportAnswer;
  }
}
