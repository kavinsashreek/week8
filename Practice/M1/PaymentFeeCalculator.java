import java.util.*;

public class PaymentFeeCalculator {
    interface Payment { double finalAmount(); }

    static class Card implements Payment {
        double amount;
        Card(double amount) { this.amount = amount; }
        public double finalAmount() { return amount * 1.02; }
    }
    static class Wallet implements Payment {
        double amount;
        Wallet(double amount) { this.amount = amount; }
        public double finalAmount() { return amount * 1.01; }
    }
    static class BankTransfer implements Payment {
        double amount;
        BankTransfer(double amount) { this.amount = amount; }
        public double finalAmount() { return amount; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0];
            double amount = Double.parseDouble(p[1]);
            Payment payment;
            if (type.equals("CARD")) payment = new Card(amount);
            else if (type.equals("WALLET")) payment = new Wallet(amount);
            else payment = new BankTransfer(amount);
            double adjusted = payment.finalAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", type, adjusted);
            total += adjusted;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}