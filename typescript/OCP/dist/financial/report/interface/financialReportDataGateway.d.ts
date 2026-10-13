import { FinancialEntity } from "./financialEntity";
export interface FinancialReportDataGateway {
    getFinancialReportData(financialId: string): Promise<FinancialEntity>;
}
//# sourceMappingURL=financialReportDataGateway.d.ts.map