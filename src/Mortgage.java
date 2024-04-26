import java.text.NumberFormat;

public class Mortgage {

  private static final byte MONTHS_IN_YEAR = 12;
  private static final byte CENT = 100;
  private int principal;
  private float monthlyInterest;
  private short numberOfPayments;

  public Mortgage(int principal, float annualInterest, byte period) {
    setPrincipal(principal);
    setMonthlyInterest(annualInterest);
    setNumberOfPayments(period);
  }

  private void setPrincipal(int principal) {
    if (principal < 1000 || principal > 1_000_000)
      throw new IllegalArgumentException("Principal must be between 1K and 1M");
    this.principal = principal;
  }

  private void setMonthlyInterest(float annualInterest) {
    if (annualInterest < 1 || annualInterest > 30)
      throw new IllegalArgumentException("Annual interest must be between 1 and 30");
    this.monthlyInterest = annualInterest / CENT / MONTHS_IN_YEAR;
  }

  private void setNumberOfPayments(short period) {
    if (period < 1 || period > 30)
      throw new IllegalArgumentException("Period must be between 1 and 30 years");
    this.numberOfPayments = (short) (period * MONTHS_IN_YEAR);
  }

  public void printMortgage() {
    System.out.println();
    double mortgage = calculateMortgage();
    System.out.println("MORTGAGE");
    System.out.println("--------");
    System.out.println(STR."Monthly Payments: \{NumberFormat.getCurrencyInstance().format(mortgage)}");
  }

  private double calculateMortgage() {
    return principal
        * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments))
        / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
  }

  public void printPaymentSchedule() {
    System.out.println();
    System.out.println("PAYMENT SCHEDULE");
    System.out.println("----------------");
    for (short month = 1; month <= numberOfPayments; month++) {
      double balance = calculateBalance(month);
      System.out.println(NumberFormat.getCurrencyInstance().format(balance));
    }
  }

  private double calculateBalance(short numberOfPaymentsMade) {
    return principal * ((Math.pow(1 + monthlyInterest, numberOfPayments)
        - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
  }

}
