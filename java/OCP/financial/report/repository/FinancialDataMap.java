package financial.report.repository;
import java.math.BigDecimal;
import financial.report.interfaces.FinancialEntity;
import financial.report.interfaces.IFinancialReportDataGateway;

public class FinancialDataMap implements IFinancialReportDataGateway {
  public FinancialEntity getById(Integer id) {
    return new FinancialEntity(id, new BigDecimal(10000), "Test 1");
  }
}
