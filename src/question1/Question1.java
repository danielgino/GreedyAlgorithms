package question1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1 {
    public static void main(String[] args) {

        int[] coins = {1, 6, 10};
        int sumTarget = 12;
        greedyCoins(coins, sumTarget);
        System.out.println("========================");
       dynamicPlanning(coins,sumTarget);

    }

    public static void greedyCoins(int[] coins, int sumTarget) {
        Arrays.sort(coins);
        List<Integer> usedCoins = new ArrayList<>();
        for (int i = coins.length - 1; i >= 0 && sumTarget > 0; i--) {
            while (sumTarget >= coins[i]) {
                sumTarget -= coins[i];
                usedCoins.add(coins[i]);
            }
        }
        System.out.println("Greedy solution: ");
        showSolution(usedCoins);
    }
    public static void dynamicPlanning(int[] coins, int sumTarget) {
        int[] dp = new int[sumTarget + 1];
        int[] prev = new int[sumTarget + 1];
        Arrays.fill(dp, sumTarget + 1);
        Arrays.fill(prev, -1);
        dp[0] = 0;

        for (int i = 1; i <= sumTarget; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                    prev[i] = coin;
                }
            }
        }

        if (dp[sumTarget] > sumTarget) {
            System.out.println("No solution possible.");
            return;
        }

        List<Integer> usedCoins = new ArrayList<>();
        int current = sumTarget;
        while (current > 0) {
            int coin = prev[current];
            usedCoins.add(coin);
            current -= coin;
        }
        System.out.println("Dynamic Planning: ");
        showSolution(usedCoins);
    }
    public static void showSolution(List<Integer> coins){
        int totalSum=0;
        for (Integer c:coins){
            System.out.print(c+",");
            totalSum+=c;
        }
        System.out.println();
        System.out.println("The Sum Of Coins: "+totalSum);
    }

}