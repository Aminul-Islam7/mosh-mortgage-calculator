public class MortgageCalculator {
  private final int CENT = 100;
  private final int MONTHS_IN_YEAR = 12;

  private int principal;
  private float annualInterest;
  private byte period;

  public MortgageCalculator(int principal, float annualInterest, byte period) {
    this.principal = principal;
    this.annualInterest = annualInterest;
    this.period = period;
  }

  public double calculateBalance(short numberOfPaymentsMade) {
    float monthlyInterest = getMonthlyInterest();
    short numberOfPayments = getNumberOfPayments();

    return principal * ((Math.pow(1 + monthlyInterest, numberOfPayments)
        - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
  }

  public double calculateMortgage() {
    float monthlyInterest = getMonthlyInterest();
    short numberOfPayments = getNumberOfPayments();

    return principal
        * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments))
        / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
  }

  public double[] getRemainingBalances() {
    var balances = new double[getNumberOfPayments()];
    for (short month = 1; month <= getNumberOfPayments(); month++)
      balances[month - 1] = calculateBalance(month);

    return balances;
  }

  private float getMonthlyInterest() {
    return annualInterest / CENT / MONTHS_IN_YEAR;
  }

  private short getNumberOfPayments() {
    return (short) (period * MONTHS_IN_YEAR);
  }
}
