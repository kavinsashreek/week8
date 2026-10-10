import java.util.*;

public class FestivalBonus {
    interface Employee { double bonus(); String name(); }

    static class FullTime implements Employee {
        String employeeName; double salary;
        FullTime(String name, double salary) { this.employeeName = name; this.salary = salary; }
        public double bonus() { return salary * 0.10; }
        public String name() { return employeeName; }
    }
    static class PartTime implements Employee {
        String employeeName; double salary;
        PartTime(String name, double salary) { this.employeeName = name; this.salary = salary; }
        public double bonus() { return salary * 0.05; }
        public String name() { return employeeName; }
    }
    static class Intern implements Employee {
        String employeeName; double salary;
        Intern(String name, double salary) { this.employeeName = name; this.salary = salary; }
        public double bonus() { return 2000.0; }
        public String name() { return employeeName; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0], name = p[1];
            double salary = Double.parseDouble(p[2]);
            Employee employee;
            if (type.equals("FULLTIME")) employee = new FullTime(name, salary);
            else if (type.equals("PARTTIME")) employee = new PartTime(name, salary);
            else employee = new Intern(name, salary);
            double bonus = employee.bonus();
            System.out.printf(Locale.US, "%s: %.2f%n", employee.name(), bonus);
            total += bonus;
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
    }
}