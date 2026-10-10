import java.util.*;
import java.util.regex.*;

public class QuestionGrader {
    interface Question { double score(); String type(); }

    static class ObjectiveQuestion implements Question {
        String questionType, correct, answer;
        double points;
        ObjectiveQuestion(String type, String correct, String answer, double points) {
            questionType = type; this.correct = correct; this.answer = answer; this.points = points;
        }
        public double score() { return answer.equals(correct) ? points : 0.0; }
        public String type() { return questionType; }
    }
    static class EssayQuestion implements Question {
        String correct, answer;
        double points;
        EssayQuestion(String correct, String answer, double points) {
            this.correct = correct; this.answer = answer; this.points = points;
        }
        public double score() {
            int matches = 0;
            String lowerAnswer = answer.toLowerCase(Locale.ROOT);
            for (String keyword : correct.split(",")) {
                String key = keyword.trim().toLowerCase(Locale.ROOT);
                if (!key.isEmpty() && lowerAnswer.contains(key)) matches++;
            }
            if (matches >= 2) return points * 0.75;
            if (matches == 1) return points * 0.50;
            return 0.0;
        }
        public String type() { return "ESSAY"; }
    }

    static String[] tokens(String line) {
        Matcher m = Pattern.compile("\\\"([^\\\"]*)\\\"|(\\S+)").matcher(line);
        ArrayList<String> list = new ArrayList<>();
        while (m.find()) list.add(m.group(1) != null ? m.group(1) : m.group(2));
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = tokens(sc.nextLine());
            String type = p[0];
            double points = Double.parseDouble(p[4]);
            Question question;
            if (type.equals("ESSAY")) question = new EssayQuestion(p[2], p[3], points);
            else question = new ObjectiveQuestion(type, p[2], p[3], points);
            double score = question.score();
            System.out.printf(Locale.US, "%s: %.2f%n", question.type(), score);
            total += score;
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }
}