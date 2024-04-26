import java.text.NumberFormat;

public class MortgageReport {

  private MortgageCalculator calculator;
  private NumberFormat currency;

  public MortgageReport(MortgageCalculator calculator) {
    this.calculator = calculator;
    currency = NumberFormat.getCurrencyInstance();
  }

  public void printMortgage() {
    System.out.println();
    double mortgage = calculator.calculateMortgage();
    System.out.println("MORTGAGE");
    System.out.println("--------");
    System.out.println("Monthly Payments: " + currency.format(mortgage));
  }

  public void printPaymentSchedule() {
    System.out.println();
    System.out.println("PAYMENT SCHEDULE");
    System.out.println("----------------");
    for (double balance : calculator.getRemainingBalances())
      System.out.println(currency.format(balance));
  }
}
