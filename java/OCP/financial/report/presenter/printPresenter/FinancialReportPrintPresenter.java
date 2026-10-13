package financial.report.presenter.printPresenter;

import financial.report.controller.IFinancialReportPresenter;
import financial.report.interfaces.FinancialReportAnswer;

public class FinancialReportPrintPresenter implements IFinancialReportPresenter {
  private IFinancialReportPrintView financialReportPrintView;

  public FinancialReportPrintPresenter(IFinancialReportPrintView financialReportPrintView) {
    this.financialReportPrintView = financialReportPrintView;
  }

  @Override
  public <T extends FinancialReportAnswer> String presentFinancialReport(T financialReportAnswer) {
    FinancialReportPrintModel financialReportPrintModel = new FinancialReportPrintModel(
      financialReportAnswer.amount,
      financialReportAnswer.description,
      "PDF Report"
    );
    return this.financialReportPrintView.createFinancialReportPrintView(financialReportPrintModel);
  }
}
