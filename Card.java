//THODORHS MARINOS AM:5426;
import java.util.HashMap;
import java.util.Map;

public class Card {
    private final String suit;
    private final int rank;

    private static final Map<Integer, String> rankToString = new HashMap<>();
    static {
        rankToString.put(11, "J");
        rankToString.put(12, "Q");
        rankToString.put(13, "K");
        rankToString.put(14, "A");
    }

    public boolean greaterThan(Card otherCard) {
        return this.rank > otherCard.rank;
    }
    public boolean consecutive(Card otherCard) {
        return Math.abs(this.rank - otherCard.rank) == 1;
    }
    public boolean between(Card[] cards) {
        return this.greaterThan(cards[0]) && this.greaterThan(cards[1]) || !this.greaterThan(cards[0]) || !this.greaterThan(cards[1]);
    }


    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }
    public String toString() {
        String rankStr = rankToString.getOrDefault(rank, Integer.toString(rank));
        return rankStr + suit;
    }

    public boolean equals(Object X) {
        if (this == X) {
            return true;
        }
        if (X == null) {
            return false;
        } else if (getClass() != X.getClass()) {
            return false;
        }
        Card card = (Card) X;
        return rank == card.rank;
    }
    public boolean isJack() {
        return rank == 11;
    }

    public boolean isHighCard() {
        return rank >= 10;
    }

    public boolean isTwoClubs() {
        return "Clubs".equals(suit) && rank == 2;
    }

    public boolean isTenDiamond() {
        return "Diamonds".equals(suit) && rank == 10;
    }

    public int getRank() {
        return rank;
    }
}
