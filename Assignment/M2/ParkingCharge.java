import java.util.*;

public class ParkingCharge {
    interface Vehicle { double charge(); }

    static class Bike implements Vehicle {
        int hours;
        Bike(int hours) { this.hours = hours; }
        public double charge() { return hours * 10.0; }
    }
    static class Car implements Vehicle {
        int hours;
        Car(int hours) { this.hours = hours; }
        public double charge() { return 30 + (hours - 1) * 20.0; }
    }
    static class Truck implements Vehicle {
        int hours;
        Truck(int hours) { this.hours = hours; }
        public double charge() { return Math.max(100, hours * 50.0); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0];
            int hours = Integer.parseInt(p[1]);
            Vehicle vehicle;
            if (type.equals("BIKE")) vehicle = new Bike(hours);
            else if (type.equals("CAR")) vehicle = new Car(hours);
            else vehicle = new Truck(hours);
            double charge = vehicle.charge();
            System.out.printf(Locale.US, "%s: %.2f%n", type, charge);
            total += charge;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}