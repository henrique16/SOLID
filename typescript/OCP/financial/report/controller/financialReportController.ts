import { FinancialReportRequest } from "../interface/financialReportRequest";
import { FinancialReportRequester } from "../interface/financialReportRequester";
import { FinancialReportPresenter } from "./financialReportPresenter";

export class FinancialReportController {
  constructor(
    private financialReportRequester: FinancialReportRequester, 
    private financialReportPresenter: FinancialReportPresenter
  ) {}

  presentFinancialReport<T extends FinancialReportRequest>(request: T): void {
    (async () => {
      const reportId = request.reportId;
      const reportAnswer = await this.financialReportRequester.getFinancialReport({ reportId })
      this.financialReportPresenter.presentFinancialReport(reportAnswer)
    })();
  }
}
