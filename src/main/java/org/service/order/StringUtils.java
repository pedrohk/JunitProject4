package org.service.order;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public class StringUtils {

    public String reverse(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }
    public boolean isPalindrome(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }

        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ROOT);

        String reversedCleaned = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversedCleaned);
    }
    public Map<String, Integer> countWordOccurrences(String text) {
        Map<String, Integer> wordCounts = new HashMap<>();
        if (text == null || text.trim().isEmpty()) {
            return wordCounts;
        }

        Pattern pattern = Pattern.compile("[\\s.,;!?()-/\\\\]+");
        String[] words = pattern.split(text.toLowerCase(Locale.ROOT));

        for (String word : words) {
            if (!word.trim().isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }
        return wordCounts;
    }
    public int calculateLevenshteinDistance(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Strings cannot be null for Levenshtein distance calculation.");
        }

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];


        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1,
                                dp[i][j - 1] + 1),
                        dp[i - 1][j - 1] + cost);
            }
        }
        return dp[m][n];
    }
}