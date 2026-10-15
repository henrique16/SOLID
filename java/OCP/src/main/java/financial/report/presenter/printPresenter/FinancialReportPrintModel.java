package financial.report.presenter.printPresenter;

import java.math.BigDecimal;

public class FinancialReportPrintModel {
  public BigDecimal amount;
  public String description;
  public String message;

  public FinancialReportPrintModel(BigDecimal amount, String description, String message) {
    this.amount = amount;
    this.description = description;
    this.message = message;
  }
}
