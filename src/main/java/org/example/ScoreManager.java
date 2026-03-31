import java.util.Scanner;

public class ScoreManager {

    // Store student names and scores
    static String[] names  = new String[100];
    static int[]    scores = new int[100];
    static int      count  = 0;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=== Welcome to Score Manager ===");

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Score");
            System.out.println("2. View All Scores");
            System.out.println("3. Find Highest Score");
            System.out.println("4. Find Lowest Score");
            System.out.println("5. Find Average Score");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1: addScore();     break;
                case 2: viewScores();   break;
                case 3: highScore();    break;
                case 4: lowScore();     break;
                case 5: avgScore();     break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add a student name and score
    static void addScore() {
        System.out.print("Enter Student Name  : ");
        String name = scanner.nextLine();

        System.out.print("Enter Score (0-100) : ");
        int score = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        // Validate score
        if (score < 0 || score > 100) {
            System.out.println("Score must be between 0 and 100!");
            return;
        }

        names[count]  = name;
        scores[count] = score;
        count++;

        System.out.println("Score added for " + name + "!");
    }

    // View all scores with grade
    static void viewScores() {
        if (count == 0) {
            System.out.println("No scores yet!");
            return;
        }

        System.out.println("\n--- All Scores ---");
        System.out.printf("%-5s %-20s %-10s %-5s%n",
                "No.", "Name", "Score", "Grade");
        System.out.println("------------------------------------------");

        for (int i = 0; i < count; i++) {
            System.out.printf("%-5d %-20s %-10d %-5s%n",
                    (i + 1), names[i], scores[i], getGrade(scores[i]));
        }
    }

    // Get grade based on score
    static String getGrade(int score) {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else if (score >= 60) return "D";
        else return "F";
    }

    // Find highest score
    static void highScore() {
        if (count == 0) { System.out.println("No scores yet!"); return; }

        int    max     = scores[0];
        String maxName = names[0];

        for (int i = 1; i < count; i++) {
            if (scores[i] > max) {
                max     = scores[i];
                maxName = names[i];
            }
        }
        System.out.println("Highest Score : " + maxName + " = " + max +
                " (" + getGrade(max) + ")");
    }

    // Find lowest score
    static void lowScore() {
        if (count == 0) { System.out.println("No scores yet!"); return; }

        int    min     = scores[0];
        String minName = names[0];

        for (int i = 1; i < count; i++) {
            if (scores[i] < min) {
                min     = scores[i];
                minName = names[i];
            }
        }
        System.out.println("Lowest Score  : " + minName + " = " + min +
                " (" + getGrade(min) + ")");
    }

    // Find average score
    static void avgScore() {
        if (count == 0) { System.out.println("No scores yet!"); return; }

        int total = 0;
        for (int i = 0; i < count; i++) total += scores[i];

        double avg = (double) total / count;
        System.out.printf("Average Score : %.2f (%s)%n", avg, getGrade((int) avg));
    }
}