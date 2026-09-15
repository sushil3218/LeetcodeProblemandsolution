class Solution {

    public int maxPalindromes(String s, int k) {

        int n = s.length();

        // palindrome[i][j] tells whether s[i...j] is palindrome
        boolean[][] palindrome = new boolean[n][n];

        // Build palindrome table
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {

                    if (j - i <= 2 || palindrome[i + 1][j - 1]) {
                        palindrome[i][j] = true;
                    }
                }
            }
        }

        // dp[i] = maximum number of palindromes
        // that can be selected from i onward
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            // Don't take anything starting at i
            dp[i] = dp[i + 1];

            // Try every substring starting at i
            for (int j = i + k - 1; j < n; j++) {

                if (palindrome[i][j]) {

                    dp[i] = Math.max(
                        dp[i],
                        1 + dp[j + 1]
                    );
                }
            }
        }

        return dp[0];
    }
}