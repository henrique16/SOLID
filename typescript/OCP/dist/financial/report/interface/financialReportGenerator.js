"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.FinancialReportGenerator = void 0;
class FinancialReportGenerator {
    financialReportDataGateway;
    constructor(financialReportDataGateway) {
        this.financialReportDataGateway = financialReportDataGateway;
    }
    async getFinancialReport(...args) {
        const [request] = args;
        const financialEntity = await this.financialReportDataGateway.getFinancialReportData(request.reportId);
        return {
            amount: financialEntity.amount,
            description: financialEntity.description,
            date: new Date()
        };
    }
}
exports.FinancialReportGenerator = FinancialReportGenerator;
//# sourceMappingURL=financialReportGenerator.js.map