import { FinancialReportDataGateway } from "./financialReportDataGateway";
import { FinancialReportRequester } from "./financialReportRequester";

export class FinancialReportGenerator implements FinancialReportRequester {
  constructor(private financialReportDataGateway: FinancialReportDataGateway) {}

  async getFinancialReport(...args: Parameters<FinancialReportRequester["getFinancialReport"]>): ReturnType<FinancialReportRequester["getFinancialReport"]> {
    const [request] = args;
    const financialEntity = await this.financialReportDataGateway.getFinancialReportData(request.reportId);
    return {
      amount: financialEntity.amount,
      description: financialEntity.description,
      date: new Date()
    }
  }
}
