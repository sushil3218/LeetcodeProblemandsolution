class Solution {
    public int uniquePathsWithObstacles(int[][] matrix) {
        int n =  matrix.length ;
        int m = matrix[0].length ;
        int[] [] dp = new int[n][m] ;
        
       for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                // Base conditions
                if (matrix[i][j] == 1) {
                    // If there's an obstacle, no paths can pass through it
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    // Starting point has exactly one path
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Check if we can move up and left
                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];

                // Sum of paths from above and left
                dp[i][j] = up + left;
            }
        }

        // The answer is at the bottom-right cell
        return dp[n - 1][m - 1];
    }
}