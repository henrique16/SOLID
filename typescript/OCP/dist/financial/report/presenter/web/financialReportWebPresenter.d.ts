import { FinancialReportPresenter } from "../../controller/financialReportPresenter";
import { FinancialReportWebView } from "./financialReportWebView";
export declare class FinancialReportWebPresenter implements FinancialReportPresenter {
    private financialReportWebView;
    constructor(financialReportWebView: FinancialReportWebView);
    presentFinancialReport(...args: Parameters<FinancialReportPresenter["presentFinancialReport"]>): ReturnType<FinancialReportPresenter["presentFinancialReport"]>;
}
//# sourceMappingURL=financialReportWebPresenter.d.ts.map