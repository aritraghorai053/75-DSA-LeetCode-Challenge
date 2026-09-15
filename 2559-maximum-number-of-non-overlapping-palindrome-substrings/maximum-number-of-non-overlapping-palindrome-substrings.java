class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        // pal[i][j] = true if s[i...j] is a palindrome
        boolean[][] pal = new boolean[n][n];

        // Build palindrome table
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        pal[i][j] = true;
                    } else {
                        pal[i][j] = pal[i + 1][j - 1];
                    }
                }
            }
        }

        // dp[i] = maximum palindromes from index i
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            // Option 1: skip this character
            dp[i] = dp[i + 1];

            // Option 2: choose a palindrome starting at i
            for (int j = i + k - 1; j < n; j++) {

                if (pal[i][j]) {
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