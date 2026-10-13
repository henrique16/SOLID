import { FinancialReportAnswer } from "../interface/financialReportAnswer"

export interface FinancialReportPresenter {
  presentFinancialReport<T extends FinancialReportAnswer>(report: T): void
}
