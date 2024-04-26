import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int principal = (int) readNumber("Principal ($1K - $1M)", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate (1 - 30)", 1, 30);
        byte period = (byte) readNumber("Period (Years) (1 - 30)", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterest, period);

        System.out.println(STR."Mortgage: \{NumberFormat.getCurrencyInstance().format(mortgage)}");
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

    public static double calculateMortgage(int principal, float annualInterest, byte period) {
        final int MONTHS_IN_YEAR = 12;
        final int CENT = 100;

        float monthlyInterest = annualInterest / CENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (period * MONTHS_IN_YEAR);

        return principal
                * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments))
                / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
    }
}
