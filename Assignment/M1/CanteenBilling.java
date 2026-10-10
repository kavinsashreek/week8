import java.util.*;

public class CanteenBilling {
    interface Bill { double finalAmount(); }

    static class StudentBill implements Bill {
        double amount;
        StudentBill(double amount) { this.amount = amount; }
        public double finalAmount() { return amount * 0.90; }
    }
    static class StaffBill implements Bill {
        double amount;
        StaffBill(double amount) { this.amount = amount; }
        public double finalAmount() { return amount * 0.95; }
    }
    static class GuestBill implements Bill {
        double amount;
        GuestBill(double amount) { this.amount = amount; }
        public double finalAmount() { return amount + 10; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);
            Bill bill;
            if (type.equals("STUDENT")) bill = new StudentBill(amount);
            else if (type.equals("STAFF")) bill = new StaffBill(amount);
            else bill = new GuestBill(amount);
            double result = bill.finalAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", type, result);
            total += result;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}