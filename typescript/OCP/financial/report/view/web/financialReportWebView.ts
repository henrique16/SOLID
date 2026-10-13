import { FinancialReportWebView } from "../../presenter/web/financialReportWebView";

export class FinancialReportWebViewImpl implements FinancialReportWebView {
  createFinancialReportWebView(...args: Parameters<FinancialReportWebView["createFinancialReportWebView"]>): ReturnType<FinancialReportWebView["createFinancialReportWebView"]> {
    const [model] = args;
    const html = `
      <!DOCTYPE html>
      <html lang="en">
      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
      </head>
      <body>
        <h1>${model.title}</h1>
        <p>${model.amount}</p>
        <p>${model.description}</p>
        <p>${model.date}</p>
      </div>
      </body>
      </html>
      <div>`;

      console.log(html);
  }
}
