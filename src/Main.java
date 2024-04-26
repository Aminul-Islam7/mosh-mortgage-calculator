import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        final int MONTHS_IN_YEAR = 12;
        final int CENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat() / CENT;
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte period = scanner.nextByte();
        int numberOfPayments = period * MONTHS_IN_YEAR;

        double mortgage =   principal *
                            (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments))
                            / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }
}
