import java.util.*;

public class TransportFareCalculator {
    interface Transport { double fare(); }

    static class Bus implements Transport {
        double distance;
        Bus(double distance) { this.distance = distance; }
        public double fare() { return Math.min(10.0, 2 + 0.10 * distance); }
    }
    static class Train implements Transport {
        double distance;
        Train(double distance) { this.distance = distance; }
        public double fare() { return 3 + 0.15 * distance; }
    }
    static class Metro implements Transport {
        double distance, peakFactor;
        Metro(double distance, double factor) { this.distance = distance; peakFactor = factor; }
        public double fare() { return (1.50 + 0.20 * distance) * peakFactor; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0];
            double distance = Double.parseDouble(p[1]);
            Transport transport;
            if (type.equals("BUS")) transport = new Bus(distance);
            else if (type.equals("TRAIN")) transport = new Train(distance);
            else transport = new Metro(distance, Double.parseDouble(p[2]));
            double fare = transport.fare();
            System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
            total += fare;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}