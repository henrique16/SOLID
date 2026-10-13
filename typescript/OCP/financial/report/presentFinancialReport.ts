import { FinancialReportController } from "./controller/financialReportController";
import { FinancialReportPresenter } from "./controller/financialReportPresenter";
import { FinancialReportPresenterType } from "./controller/financialReportPresenterType";
import { FinancialReportDataGateway } from "./interface/financialReportDataGateway";
import { FinancialReportGenerator } from "./interface/financialReportGenerator";
import { FinancialReportRequest } from "./interface/financialReportRequest";
import { FinancialReportRequester } from "./interface/financialReportRequester";
import { FinancialReportWebPresenter } from "./presenter/web/financialReportWebPresenter";
import { FinancialReportWebView } from "./presenter/web/financialReportWebView";
import { FinancialReportDataMap } from "./repository/financialReportDataMap";
import { FinancialReportWebViewImpl } from "./view/web/financialReportWebView";

export class PresentFinancialReport {
  constructor (
    private financialReportPresenterType: FinancialReportPresenterType,
    private financialReportRequest: FinancialReportRequest
  ) {
    this.execute()
  }

  execute() {
    const createWebView: FinancialReportWebView = new FinancialReportWebViewImpl()
    const financialReportDataGateway: FinancialReportDataGateway = new FinancialReportDataMap()
    const financialReportRequester: FinancialReportRequester = new FinancialReportGenerator(financialReportDataGateway)
    let financialReportPresenter: FinancialReportPresenter = new FinancialReportWebPresenter(createWebView)

    switch (this.financialReportPresenterType) {
      case FinancialReportPresenterType.PDF:
        financialReportPresenter = {} as any
        break;
    }

    const controller = new FinancialReportController(financialReportRequester, financialReportPresenter)
    controller.presentFinancialReport(this.financialReportRequest)
  }
}
