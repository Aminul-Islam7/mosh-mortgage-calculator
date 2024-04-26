import java.util.Scanner;

public class Console {

  public static double readNumber(String prompt, double min, double max) {
    Scanner scan = new Scanner(System.in);
    while (true) {
      System.out.print(prompt + ": ");
      double value = scan.nextDouble();
      if (value >= min && value <= max)
        return value;
      System.out.println("Enter a value between " + min + " and " + max);
    }
  }
}
