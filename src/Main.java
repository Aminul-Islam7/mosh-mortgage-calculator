import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MONTHS_IN_YEAR = 12;
        final int CENT = 100;

        int principal;
        float annualInterest;
        float monthlyInterest;
        int numberOfPayments;
        byte period;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 &&  principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }

        while (true) {
            System.out.print("Annual Interest Rate (1 - 30): ");
            annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 &&  annualInterest <= 30) {
                monthlyInterest = annualInterest / CENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        while (true) {
            System.out.print("Period (Years) (1 - 30): ");
            period = scanner.nextByte();
            if (period >= 1 &&  period <= 30) {
                numberOfPayments = period * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage =   principal *
                (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments))
                / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
        System.out.println(STR."Mortgage: \{NumberFormat.getCurrencyInstance().format(mortgage)}");
    }
}
