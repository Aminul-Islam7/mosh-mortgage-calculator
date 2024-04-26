import static java.lang.StringTemplate.STR;

import java.text.NumberFormat;

public class MortgageReport {

  private MortgageCalculator calculator;

  public MortgageReport(MortgageCalculator calculator) {
    this.calculator = calculator;
  }

  public void printMortgage() {
    System.out.println();
    double mortgage = calculator.calculateMortgage();
    System.out.println("MORTGAGE");
    System.out.println("--------");
    System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgage));
  }

  public void printPaymentSchedule() {
    System.out.println();
    System.out.println("PAYMENT SCHEDULE");
    System.out.println("----------------");
    for (double balance : calculator.getRemainingBalances())
      System.out.println(NumberFormat.getCurrencyInstance().format(balance));
  }
}
