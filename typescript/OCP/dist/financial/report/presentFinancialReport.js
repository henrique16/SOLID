"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.PresentFinancialReport = void 0;
const financialReportController_1 = require("./controller/financialReportController");
const financialReportPresenterType_1 = require("./controller/financialReportPresenterType");
const financialReportGenerator_1 = require("./interface/financialReportGenerator");
const financialReportWebPresenter_1 = require("./presenter/web/financialReportWebPresenter");
const financialReportDataMap_1 = require("./repository/financialReportDataMap");
const financialReportWebView_1 = require("./view/web/financialReportWebView");
class PresentFinancialReport {
    financialReportPresenterType;
    financialReportRequest;
    constructor(financialReportPresenterType, financialReportRequest) {
        this.financialReportPresenterType = financialReportPresenterType;
        this.financialReportRequest = financialReportRequest;
        this.execute();
    }
    execute() {
        const createWebView = new financialReportWebView_1.FinancialReportWebViewImpl();
        const financialReportDataGateway = new financialReportDataMap_1.FinancialReportDataMap();
        const financialReportRequester = new financialReportGenerator_1.FinancialReportGenerator(financialReportDataGateway);
        let financialReportPresenter = new financialReportWebPresenter_1.FinancialReportWebPresenter(createWebView);
        switch (this.financialReportPresenterType) {
            case financialReportPresenterType_1.FinancialReportPresenterType.PDF:
                financialReportPresenter = {};
                break;
        }
        const controller = new financialReportController_1.FinancialReportController(financialReportRequester, financialReportPresenter);
        controller.presentFinancialReport(this.financialReportRequest);
    }
}
exports.PresentFinancialReport = PresentFinancialReport;
//# sourceMappingURL=presentFinancialReport.js.map