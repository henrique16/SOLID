import { FinancialEntity } from "../interface/financialEntity";
import { FinancialReportDataGateway } from "../interface/financialReportDataGateway";

export class FinancialReportDataMap implements FinancialReportDataGateway {
  async getFinancialReportData(financialId: string): Promise<FinancialEntity> {
    return {
      amount: 100,
      description: "Test",
      id: financialId,
    }
  }
}
