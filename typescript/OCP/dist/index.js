"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const financialReportPresenterType_1 = require("./financial/report/controller/financialReportPresenterType");
const presentFinancialReport_1 = require("./financial/report/presentFinancialReport");
new presentFinancialReport_1.PresentFinancialReport(financialReportPresenterType_1.FinancialReportPresenterType.WEB, { reportId: "1" });
//# sourceMappingURL=index.js.map