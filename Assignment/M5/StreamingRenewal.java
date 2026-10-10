import java.time.LocalDate;
import java.util.*;

public class StreamingRenewal {
    interface Plan { LocalDate renewalDate(); String name(); }

    static class Subscriber implements Plan {
        String subscriberName;
        LocalDate startDate;
        int validityDays;
        Subscriber(String name, LocalDate start, int days) {
            subscriberName = name; startDate = start; validityDays = days;
        }
        public LocalDate renewalDate() { return startDate.plusDays(validityDays); }
        public String name() { return subscriberName; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0], name = p[1];
            LocalDate start = LocalDate.parse(p[2]);
            int days;
            if (type.equals("BASIC")) days = 30;
            else if (type.equals("STANDARD")) days = 90;
            else days = 365;
            Plan plan = new Subscriber(name, start, days);
            System.out.println(plan.name() + ": " + plan.renewalDate());
        }
    }
}