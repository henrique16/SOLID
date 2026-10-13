"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.FinancialReportController = void 0;
class FinancialReportController {
    financialReportRequester;
    financialReportPresenter;
    constructor(financialReportRequester, financialReportPresenter) {
        this.financialReportRequester = financialReportRequester;
        this.financialReportPresenter = financialReportPresenter;
    }
    presentFinancialReport(request) {
        (async () => {
            const reportId = request.reportId;
            const reportAnswer = await this.financialReportRequester.getFinancialReport({ reportId });
            this.financialReportPresenter.presentFinancialReport(reportAnswer);
        })();
    }
}
exports.FinancialReportController = FinancialReportController;
//# sourceMappingURL=financialReportController.js.map