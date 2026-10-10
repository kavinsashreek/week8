import java.util.*;

public class DeliveryFeeCalculator {
    interface Delivery { double fee(); }

    static class Standard implements Delivery {
        double weight, distance;
        Standard(double w, double d) { weight = w; distance = d; }
        public double fee() { return 5 + 0.50 * weight + 0.10 * distance; }
    }
    static class Express implements Delivery {
        double weight, distance;
        Express(double w, double d) { weight = w; distance = d; }
        public double fee() { return 15 + weight + 0.20 * distance; }
    }
    static class International implements Delivery {
        double weight, distance, customs;
        International(double w, double d, double c) { weight = w; distance = d; customs = c; }
        public double fee() { return 25 + 2 * weight + 0.50 * distance + customs; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0];
            double weight = Double.parseDouble(p[1]);
            double distance = Double.parseDouble(p[2]);
            Delivery delivery;
            if (type.equals("STANDARD")) delivery = new Standard(weight, distance);
            else if (type.equals("EXPRESS")) delivery = new Express(weight, distance);
            else delivery = new International(weight, distance, Double.parseDouble(p[3]));
            double fee = delivery.fee();
            System.out.printf(Locale.US, "%s: %.2f%n", type, fee);
            total += fee;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}