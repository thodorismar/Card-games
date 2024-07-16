import java.util.Random;

public class CardStack {
    private final Card[] cards;
    private int faceCard;
    private int size;

    public CardStack() {
        cards = new Card[52];
        faceCard = -1;
        size = 0;
        initializeDeck();
    }

    public CardStack(int numDecks) {
        cards = new Card[52 * numDecks];
        faceCard = -1;
        size = 0;
        for (int i = 0; i < numDecks; i++) {
            initializeDeck();
        }
    }

    private void initializeDeck() {
        String[] suits = {"S", "H", "D", "C"};
        for (String suit : suits) {
            for (int rank = 2; rank <= 14; rank++) {
                cards[++faceCard] = new Card(suit, rank);
                size++;
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = size - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public Card draw() {
        if (isEmpty()) {
            System.out.println("stack is empty.");
            return null;
        }
        return cards[faceCard--];
    }

    public boolean isEmpty() {
        return faceCard < 0;
    }

    public boolean isHalfEmpty() {
        return faceCard < (size) / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= faceCard; i++) {
            sb.append(cards[i]).append(",");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CardStack stack1 = new CardStack();
        System.out.println(stack1);

        Card topCard = stack1.draw();
        System.out.println(topCard);

        System.out.println(stack1);

        stack1.shuffle();
        System.out.println(stack1);

        for (int i = 0; i < 5; i++) {
            Card card1 = stack1.draw();
            Card card2 = stack1.draw();
            System.out.println(card1 + " " + card2);
        }
        System.out.println(stack1);
    }

}
