"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.FinancialReportWebPresenter = void 0;
class FinancialReportWebPresenter {
    financialReportWebView;
    constructor(financialReportWebView) {
        this.financialReportWebView = financialReportWebView;
    }
    presentFinancialReport(...args) {
        const [report] = args;
        const model = {
            amount: report.amount,
            description: report.description,
            date: report.date,
            title: "Test 1"
        };
        this.financialReportWebView.createFinancialReportWebView(model);
    }
}
exports.FinancialReportWebPresenter = FinancialReportWebPresenter;
//# sourceMappingURL=financialReportWebPresenter.js.map