package financial.report.interfaces;
import java.math.BigDecimal;

public class FinancialReportAnswer {
  public BigDecimal amount;
  public String description;

  public FinancialReportAnswer(BigDecimal amount, String description) {
    this.amount = amount;
    this.description = description;
  }
}
