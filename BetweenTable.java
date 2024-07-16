public class BetweenTable {
    private CardStack stack;
    private Card[] tableCards;
    private Card playerCard;

    public BetweenTable(CardStack stack) {
        this.stack = stack;
        this.tableCards = new Card[2];
    }

    public void drawTableCards() {
        tableCards[0] = stack.draw();
        tableCards[1] = stack.draw();
        System.out.println("Table Cards: " + tableCards[0] + ", " + tableCards[1]);
    }

    public boolean defaultPlayerLoss() {
        return tableCards[0].equals(tableCards[1]) || tableCards[0].consecutive(tableCards[1]);
    }

    public void drawPlayerCard() {
        playerCard = stack.draw();
        System.out.println("Player Card: " + playerCard);
    }

    public boolean betweenCard() {
        return playerCard.between(tableCards);
    }
}
