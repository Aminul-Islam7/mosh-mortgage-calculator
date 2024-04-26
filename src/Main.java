public class Main {
    public static void main(String[] args) {
        var mortgage = new Mortgage(180000, 4f, (byte) 10);
        mortgage.printMortgage();
        mortgage.printPaymentSchedule();
    }
}
