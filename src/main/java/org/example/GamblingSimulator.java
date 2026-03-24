import java.util.Random;

public class GamblingSimulator {
    public static void main(String[] args) {
        final int STAKE = 100;
        final int BET = 1;
        final int DAYS = 20;

        Random random = new Random();

        int totalAmount = 0;
        int luckiestDay = 0;
        int unluckiestDay = 0;
        int maxWin = Integer.MIN_VALUE;
        int maxLoss = Integer.MAX_VALUE;

        int winDays = 0;
        int lossDays = 0;

        for (int day = 1; day <= DAYS; day++) {
            int cash = STAKE;

            while (cash > 50 && cash < 150) {
                if (random.nextBoolean()) {
                    cash += BET;
                } else {
                    cash -= BET;
                }
            }

            int netAmount = cash - STAKE;
            totalAmount += netAmount;

            System.out.println("Day " + day + ": " + (netAmount >= 0 ? "Won " : "Lost ") + netAmount);

            if (netAmount > 0) {
                winDays++;
            } else {
                lossDays++;
            }

            if (netAmount > maxWin) {
                maxWin = netAmount;
                luckiestDay = day;
            }

            if (netAmount < maxLoss) {
                maxLoss = netAmount;
                unluckiestDay = day;
            }
        }

        System.out.println("\nTotal amount after " + DAYS + " days: " + totalAmount);

        System.out.println("Winning days: " + winDays);
        System.out.println("Losing days: " + lossDays);

        System.out.println("Luckiest day: Day " + luckiestDay + " with amount " + maxWin);
        System.out.println("Unluckiest day: Day " + unluckiestDay + " with amount " + maxLoss);

        if (totalAmount > 0) {
            System.out.println("Gambler won overall, so continue playing next month.");
        } else {
            System.out.println("Gambler lost overall, so stop gambling next month.");
        }
    }
}