import { FinancialReportPresenter } from "../../controller/financialReportPresenter";
import { FinancialReportWebModel } from "./financialReportWebModel";
import { FinancialReportWebView } from "./financialReportWebView";

export class FinancialReportWebPresenter implements FinancialReportPresenter {
  constructor(
    private financialReportWebView: FinancialReportWebView
  ) { }

  presentFinancialReport(...args: Parameters<FinancialReportPresenter["presentFinancialReport"]>): ReturnType<FinancialReportPresenter["presentFinancialReport"]> {
    const [report] = args;
    const model = {
      amount: report.amount,
      description: report.description,
      date: report.date,
      title: "Test 1"
    } as FinancialReportWebModel;
    this.financialReportWebView.createFinancialReportWebView(model)
  }
}
