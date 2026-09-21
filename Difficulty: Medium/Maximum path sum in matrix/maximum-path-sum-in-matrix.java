class Solution {
    public int maximumPath(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[n - 1][j] = mat[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {

            for (int j = 0; j < m; j++) {

                int best = dp[i + 1][j];

                if (j - 1 >= 0) {
                    best = Math.max(best, dp[i + 1][j - 1]);
                }

                if (j + 1 < m) {
                    best = Math.max(best, dp[i + 1][j + 1]);
                }

                dp[i][j] = mat[i][j] + best;
            }
        }

        int ans = 0;

        for (int j = 0; j < m; j++) {
            ans = Math.max(ans, dp[0][j]);
        }

        return ans;
    }
}