class InitialDataHandler {
  constructor() {
    this.data = { ...data }
  }

  get() {
    return { ...this.data }
  }
}

window.onload = () => {
  const financialAmount = document.getElementById("[FINANCIAL_AMOUNT]");
  const financialDescription = document.getElementById("[FINANCIAL_DESCRIPTRION]");
  const initialDataHandler = new InitialDataHandler();
  const initialData = initialDataHandler.get();

  financialAmount.value = initialData.amount;
  financialDescription.value = initialData.description;
}
