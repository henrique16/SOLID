package financial.report.repository;
import java.math.BigDecimal;
import financial.report.interfaces.FinancialEntity;
import financial.report.interfaces.FinancialReportDataGateway;

public class FinancialDataMap implements FinancialReportDataGateway {
  public FinancialEntity getById(Integer id) {
    return new FinancialEntity(id, new BigDecimal(111223.1122), "Test 1");
  }
}
