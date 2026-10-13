import { FinancialReportDataGateway } from "./financialReportDataGateway";
import { FinancialReportRequester } from "./financialReportRequester";
export declare class FinancialReportGenerator implements FinancialReportRequester {
    private financialReportDataGateway;
    constructor(financialReportDataGateway: FinancialReportDataGateway);
    getFinancialReport(...args: Parameters<FinancialReportRequester["getFinancialReport"]>): ReturnType<FinancialReportRequester["getFinancialReport"]>;
}
//# sourceMappingURL=financialReportGenerator.d.ts.map