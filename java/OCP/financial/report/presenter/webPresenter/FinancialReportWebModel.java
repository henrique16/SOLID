package financial.report.presenter.webPresenter;
import financial.report.interfaces.FinancialReportAnswer;
import java.math.BigDecimal;

public class FinancialReportWebModel extends FinancialReportAnswer {
  public String title;
  public String content;

  public FinancialReportWebModel(BigDecimal amount, String description, String title, String content) {
    super(amount, description);
    this.title = title;
    this.content = content;
  }
}
