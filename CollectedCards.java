//THODORHS MARINOS AM:5426;
import java.util.ArrayList;
import java.util.List;

public class CollectedCards {
    private final List<Card> cards;

    public CollectedCards(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public boolean isXeri() {
        return cards.size() == 1;
    }

    public boolean isXeriWithJacks() {
        if (cards.size() == 1 && cards.get(0).isJack()) {
            return true;
        }
        return cards.size() == 2 && cards.get(0).isJack() && cards.get(1).isJack();
    }

    public List<Card> getCards() {
        return cards;
    }
}
