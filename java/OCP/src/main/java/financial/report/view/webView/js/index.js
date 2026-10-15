class InitialDataHandler {
  constructor() {
    this.data = data;
  }

  get() {
    return { ...this.data };
  }
}

class RequestAdapter {
  open(url = undefined, target = undefined, features = undefined) {
    window.open(url, target, features);
  }
}

class FinancialReportRequester {
  constructor(requestAdapter) {
    this.requestAdapter = requestAdapter;
  }

  async getPdf() {
    this.requestAdapter.open("/financial/getPDFViewReport", "_blank");
  }
}

window.onload = () => {
  const requestAdapter = new RequestAdapter();
  const financialReportRequester = new FinancialReportRequester(requestAdapter)
  const initialDataHandler = new InitialDataHandler();

  const financialTitle = document.getElementById("[FINANCIAL_TITLE]");
  const financialContent = document.getElementById("[FINANCIAL_CONTENT]");
  const financialAmount = document.getElementById("[FINANCIAL_AMOUNT]");
  const financialDescription = document.getElementById("[FINANCIAL_DESCRIPTION]");
  const financialGetPdf = document.getElementById("[FINANCIAL_GET_PDF]");
  
  const initialData = initialDataHandler.get();

  console.log(initialData);
  financialTitle.value = initialData.title;
  financialContent.value = initialData.content;
  financialAmount.value = initialData.amount;
  financialDescription.value = initialData.description;

  financialGetPdf.addEventListener("click", function () {
    financialReportRequester.getPdf();
  })
}
