import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void print() {
        for (Card card : cards) {
            System.out.print(card + "      ");
        }
        System.out.println();
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(i + "       ");
        }
        System.out.println();
    }

    public Card getCard(int position) {
        return cards.remove(position);
    }

    public Card selectComputerCard(Card topCard) {
        if (topCard == null) {
            return cards.remove(0);
        }

        for (Card card : cards) {
            if (card.getRank() == topCard.getRank() || card.isJack()) {
                cards.remove(card);
                return card;
            }
        }
        return cards.remove(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
