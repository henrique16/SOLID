package financial.report.interfaces;
import java.math.BigDecimal;

public class FinancialEntity {
  public Integer id;
  public BigDecimal amount;
  public String description;

  public FinancialEntity(Integer id, BigDecimal amount, String description) {
    this.id = id;
    this.amount = amount;
    this.description = description;
  }
}
