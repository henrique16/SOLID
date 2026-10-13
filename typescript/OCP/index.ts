import { FinancialReportPresenterType } from "./financial/report/controller/financialReportPresenterType";
import { PresentFinancialReport } from "./financial/report/presentFinancialReport";

new PresentFinancialReport(FinancialReportPresenterType.WEB, { reportId: "1" })
