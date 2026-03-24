import java.util.Random;

public class Day4P2 {
    public static void main(String[] args) {
        Random random = new Random();

        int player1Position = 0;
        int player2Position = 0;
        int diceCount = 0;

        while (player1Position < 100 && player2Position < 100) {

            // Player 1 turn
            player1Position = playTurn("Player 1", player1Position, random);
            diceCount++;
            if (player1Position == 100) {
                System.out.println("Player 1 wins!");
                break;
            }

            // Player 2 turn
            player2Position = playTurn("Player 2", player2Position, random);
            diceCount++;
            if (player2Position == 100) {
                System.out.println("Player 2 wins!");
                break;
            }
        }

        System.out.println("Total number of dice rolls: " + diceCount);
    }

    public static int playTurn(String playerName, int position, Random random) {
        boolean playAgain;

        do {
            playAgain = false;

            int die = random.nextInt(6) + 1;     // 1 to 6
            int option = random.nextInt(3);      // 0 = No Play, 1 = Ladder, 2 = Snake

            System.out.println(playerName + " rolled: " + die);

            if (option == 0) {
                System.out.println(playerName + " got No Play");
            } else if (option == 1) {
                System.out.println(playerName + " got Ladder");
                if (position + die <= 100) {
                    position += die;
                }
                playAgain = true; // player gets another chance
            } else {
                System.out.println(playerName + " got Snake");
                position -= die;
                if (position < 0) {
                    position = 0;
                }
            }

            System.out.println(playerName + " position: " + position);
            System.out.println("-----------------------");

        } while (playAgain && position < 100);

        return position;
    }
}