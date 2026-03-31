import java.util.Random;

// Node class for Queue (Linked List)
class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

// Queue using Linked List
class Queue {
    Node front = null;
    Node rear = null;

    void enqueue(String data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    void display() {
        Node temp = front;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

// Player class
class Player {
    String name;
    String[] cards = new String[9];
    Queue cardQueue = new Queue();

    Player(String name) {
        this.name = name;
    }

    // Sort cards by rank (simple bubble sort)
    void sortCards() {
        String[] rankOrder = {"2","3","4","5","6","7","8","9","10",
                "Jack","Queen","King","Ace"};

        for (int i = 0; i < cards.length - 1; i++) {
            for (int j = 0; j < cards.length - i - 1; j++) {

                int rank1 = getRankValue(cards[j], rankOrder);
                int rank2 = getRankValue(cards[j + 1], rankOrder);

                if (rank1 > rank2) {
                    String temp = cards[j];
                    cards[j] = cards[j + 1];
                    cards[j + 1] = temp;
                }
            }
        }
    }

    int getRankValue(String card, String[] rankOrder) {
        String rank = card.split(" ")[0];
        for (int i = 0; i < rankOrder.length; i++) {
            if (rank.equals(rankOrder[i])) {
                return i;
            }
        }
        return -1;
    }

    // Add sorted cards to queue
    void addToQueue() {
        for (int i = 0; i < cards.length; i++) {
            cardQueue.enqueue(cards[i]);
        }
    }

    void display() {
        System.out.println(name + " cards:");
        cardQueue.display();
        System.out.println();
    }
}

// Queue for Players
class PlayerQueue {
    Player[] players = new Player[4];
    int front = 0, rear = -1;

    void enqueue(Player p) {
        players[++rear] = p;
    }

    void display() {
        for (int i = front; i <= rear; i++) {
            players[i].display();
        }
    }
}

public class DeckOfCardsWithQueue {

    public static void main(String[] args) {

        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"};

        // Create deck
        String[] deck = new String[52];
        int index = 0;

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index++] = ranks[j] + " of " + suits[i];
            }
        }

        // Shuffle
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = rand.nextInt(deck.length);

            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }

        // Create players
        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player("Player " + (i + 1));
        }

        // Distribute cards
        int cardIndex = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 9; j++) {
                players[i].cards[j] = deck[cardIndex++];
            }
        }

        // Sort and add to queue
        for (int i = 0; i < 4; i++) {
            players[i].sortCards();
            players[i].addToQueue();
        }

        // Player queue
        PlayerQueue pq = new PlayerQueue();
        for (int i = 0; i < 4; i++) {
            pq.enqueue(players[i]);
        }

        // Display
        pq.display();
    }
}