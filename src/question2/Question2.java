package question2;

import java.util.Arrays;

public class Question2 {

    public static void main(String[] args) {
        String[] words = {"The", "Daniel", "Sharon", "Fox", "Parking", "Game", "Greedy", "Lazy"};
        int L = 10;

        greedyLineBreak(words, L);
        System.out.println("=========================");
        dynamicLineBreak(words, L);
    }

    public static void dynamicLineBreak(String[] words, int L) {
        System.out.println("Dynamic Programming:");
        int n = words.length;
        int[] lengths = Arrays.stream(words).mapToInt(String::length).toArray();
        int[] dp = new int[n + 1];
        int[] breaks = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int lineLength = -1;
            for (int j = i; j < n; j++) {
                lineLength += lengths[j] + 1;
                if (lineLength > L) break;
                int penalty = L - lineLength;
                if (dp[j + 1] + penalty < dp[i]) {
                    dp[i] = dp[j + 1] + penalty;
                    breaks[i] = j + 1;
                }
            }
        }

        int i = 0;
        while (i < n) {
            int j = breaks[i];
            StringBuilder line = new StringBuilder();
            for (int k = i; k < j; k++) {
                line.append(words[k]);
                if (k < j - 1) line.append(" ");
            }
            int lineLength = line.length();
            int penalty = L - lineLength;
            System.out.println(line + " | penalty: " + penalty);
            i = j;
        }

        System.out.println("Total penalty: " + dp[0]);
    }

    public static void greedyLineBreak(String[] words, int L) {
        System.out.println("Greedy Solution:");
        int currentLineLength = 0;
        int totalPenalty = 0;

        for (int i = 0; i < words.length; ) {
            currentLineLength = 0;
            StringBuilder line = new StringBuilder();
            int lineStart = i;

            while (i < words.length && (currentLineLength + words[i].length() + (line.length() > 0 ? 1 : 0)) <= L) {
                if (line.length() > 0) {
                    line.append(" ");
                    currentLineLength += 1;
                }
                line.append(words[i]);
                currentLineLength += words[i].length();
                i++;
            }

            int penalty = L - currentLineLength;
            totalPenalty += penalty;

            System.out.println(line.toString() + " | penalty: " + penalty);
        }

        System.out.println("Total penalty: " + totalPenalty);
    }
}
