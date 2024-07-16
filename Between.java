import java.util.Scanner;
public class Between {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Pot money? : ");
        int dealerMoney = input.nextInt();
        System.out.println("Player money?: ");
        int playerMoney = input.nextInt();

        BetweenDealer dealer = new BetweenDealer(dealerMoney);
        BetweenPlayer player = new BetweenPlayer(playerMoney);

        while (!player.isBroke() && !dealer.emptyPot()) {
            dealer.play(player);
        }

        if (dealer.emptyPot()) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer wins!");
        }
        System.out.println();
    }
}
