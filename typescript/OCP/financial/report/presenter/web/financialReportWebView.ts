import { FinancialReportWebModel } from "./financialReportWebModel";

export interface FinancialReportWebView {
  createFinancialReportWebView(model: FinancialReportWebModel): void;
}
