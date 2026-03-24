import java.util.Scanner;

public class Day5P6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Press Enter to start the stopwatch...");
        sc.nextLine();
        long startTime = System.currentTimeMillis();

        System.out.println("Press Enter to stop the stopwatch...");
        sc.nextLine();
        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;

        System.out.println("Elapsed Time: " + elapsedTime + " milliseconds");

        sc.close();
    }
}