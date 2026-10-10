import java.util.*;

public class ElectricityBill {
    interface Room { double bill(); }

    static class SingleRoom implements Room {
        double units;
        SingleRoom(double units) { this.units = units; }
        public double bill() { return units * 8.0; }
    }
    static class SharedRoom implements Room {
        double units;
        int occupants;
        SharedRoom(double units, int occupants) {
            this.units = units; this.occupants = occupants;
        }
        public double bill() { return units * 6.0 / occupants; }
    }
    static class AcRoom implements Room {
        double units;
        AcRoom(double units) { this.units = units; }
        public double bill() { return units * 10.0 + 200; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0];
            double units = Double.parseDouble(p[1]);
            Room room;
            if (type.equals("SINGLE")) room = new SingleRoom(units);
            else if (type.equals("SHARED")) room = new SharedRoom(units, Integer.parseInt(p[2]));
            else room = new AcRoom(units);
            double bill = room.bill();
            System.out.printf(Locale.US, "%s: %.2f%n", type, bill);
            total += bill;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}