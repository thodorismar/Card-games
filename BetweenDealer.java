public class BetweenDealer {
    private CardStack stack;
    private int pot;

    public BetweenDealer(int pot) {
        this.pot = pot;
        this.stack = new CardStack(6);
        stack.shuffle();
    }

    public boolean emptyPot() {
        return pot <= 0;
    }

    public void play(BetweenPlayer player) {
        if (stack.isHalfEmpty()) {
            stack = new CardStack(6);
            stack.shuffle();
        }

        BetweenTable table = new BetweenTable(stack);
        table.drawTableCards();

        if (table.defaultPlayerLoss()) {
            System.out.println("Default loss of Player.");
            player.subtractMoney(1);
            pot++;
        } else {
            int playerBid = player.bid(pot);
            table.drawPlayerCard();
            if (table.betweenCard()) {
                System.out.println("Player wins!");
                player.addMoney(playerBid);
                pot -= playerBid;
            } else {
                System.out.println("Player loses!");
                player.subtractMoney(playerBid);
                pot += playerBid;
            }
        }
    }
}
