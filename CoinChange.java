import java.util.Arrays;

public class CoinChange {
    public static int[] getCoins(int amount, int[] denominations) {
        int[] coins = new int[denominations.length];
        for (int i = denominations.length - 1; i >= 0; i--) {
            coins[i] = amount / denominations[i];
            amount %= denominations[i];
        }
        return coins;
    }

    public static void main(String[] args) {
        int amount = 43;
        int[] denominations = {1, 2, 5, 10, 20, 50};
        int[] coins = getCoins(amount, denominations);
        System.out.println("Minimum number of coins to make " + amount + " cents:");
        System.out.println(Arrays.toString(coins));
    }
}