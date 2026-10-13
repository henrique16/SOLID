import { FinancialReportRequest } from "../interface/financialReportRequest";
import { FinancialReportRequester } from "../interface/financialReportRequester";
import { FinancialReportPresenter } from "./financialReportPresenter";
export declare class FinancialReportController {
    private financialReportRequester;
    private financialReportPresenter;
    constructor(financialReportRequester: FinancialReportRequester, financialReportPresenter: FinancialReportPresenter);
    presentFinancialReport<T extends FinancialReportRequest>(request: T): void;
}
//# sourceMappingURL=financialReportController.d.ts.map