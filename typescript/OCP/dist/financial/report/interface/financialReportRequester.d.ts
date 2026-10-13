import { FinancialReportAnswer } from "./financialReportAnswer";
import { FinancialReportRequest } from "./financialReportRequest";
export interface FinancialReportRequester {
    getFinancialReport(request: FinancialReportRequest): Promise<FinancialReportAnswer>;
}
//# sourceMappingURL=financialReportRequester.d.ts.map