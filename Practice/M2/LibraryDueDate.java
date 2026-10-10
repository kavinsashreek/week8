import java.time.LocalDate;
import java.util.*;
import java.util.regex.*;

public class LibraryDueDate {
    interface LibraryItem { LocalDate dueDate(); String title(); }

    static class BorrowedItem implements LibraryItem {
        String itemTitle;
        int days;
        BorrowedItem(String title, int days) { itemTitle = title; this.days = days; }
        public LocalDate dueDate() { return LocalDate.parse("2023-10-26").plusDays(days); }
        public String title() { return itemTitle; }
    }

    static String[] tokens(String line) {
        Matcher m = Pattern.compile("\\\"([^\\\"]*)\\\"|(\\S+)").matcher(line);
        java.util.ArrayList<String> list = new java.util.ArrayList<>();
        while (m.find()) list.add(m.group(1) != null ? m.group(1) : m.group(2));
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String[] p = tokens(sc.nextLine());
            int days;
            if (p[0].equals("BOOK")) days = 14;
            else if (p[0].equals("DVD")) days = 7;
            else days = 3;
            LibraryItem item = new BorrowedItem(p[1], days);
            System.out.println(item.title() + ": " + item.dueDate());
        }
    }
}