class Solution {

    public static int coin(int index, int[] coins, int amount,int[][]dp) {

        // Amount completed
        if (amount == 0) {
            return 0;
        }
        if(dp[index][amount] != -1){
            return dp[index][amount] ;
        }
        // No coins left
        if (index == coins.length) {
            return Integer.MAX_VALUE;
        }

        int take = Integer.MAX_VALUE;

        // Take current coin
        if (coins[index] <= amount) {

            int result = coin(index, coins, amount - coins[index],dp);

            if (result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }

        // Do not take current coin
        int notTake = coin(index + 1, coins, amount,dp);

        dp[index][amount] = Math.min(take, notTake);
        return dp[index][amount] ;
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1] ;  
        for(int i =0; i<dp.length ; i++){
        Arrays.fill(dp[i], -1);
        }
        int ans = coin(0, coins, amount,dp);

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
    }
}