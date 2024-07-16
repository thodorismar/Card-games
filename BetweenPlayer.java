import java.util.Scanner;
public class BetweenPlayer {
    private int money;

    public BetweenPlayer(int money) {
        this.money = money;
    }

    public int bid(int pot) {
        Scanner scanner = new Scanner(System.in);
        int bid;

        do {
            System.out.println("Your money: " + money);
            System.out.println("Current pot: " + pot);
            System.out.print("Place your bet: ");
            bid = scanner.nextInt();

            if (bid < 1 || bid > money || bid > pot) {
                System.out.println("Invalid bid. Your bid must be at least 1 and no more than the money you or the dealer have.");
            }
        } while (bid < 1 || bid > money || bid > pot);

        return bid;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void subtractMoney(int amount) {
        money -= amount;
    }

    public boolean isBroke() {
        return money <= 0;
    }
}
