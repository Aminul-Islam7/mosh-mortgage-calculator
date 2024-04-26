import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static int MONTHS_IN_YEAR = 12;
    final static int CENT = 100;

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal ($1K - $1M)", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate (1 - 30)", 1, 30);
        byte period = (byte) readNumber("Period (Years) (1 - 30)", 1, 30);

        printMortgage(principal, annualInterest, period);
        printPaymentSchedule(period, principal, annualInterest);
    }

    private static void printMortgage(int principal, float annualInterest, byte period) {
        System.out.println();
        double mortgage = calculateMortgage(principal, annualInterest, period);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println(STR."Monthly Payments: \{NumberFormat.getCurrencyInstance().format(mortgage)}");
    }

    public static void printPaymentSchedule(byte period, int principal, float annualInterest) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= period * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterest, period, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(prompt + ": ");
            double value = scan.nextDouble();
            if (value >= min && value <= max)
                return value;
            System.out.println(STR."Enter a value between \{min} and \{max}");
        }
    }

    public static double calculateBalance(
            int principal,
            float annualInterest,
            byte period,
            short numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / CENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (period * MONTHS_IN_YEAR);

        return principal * ((Math.pow(1 + monthlyInterest, numberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
    }

    public static double calculateMortgage(int principal, float annualInterest, byte period) {
        float monthlyInterest = annualInterest / CENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (period * MONTHS_IN_YEAR);

        return principal
                * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments))
                / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
    }
}
