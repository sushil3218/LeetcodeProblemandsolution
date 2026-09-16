class Solution { 
    public static int subsequence(int[] arr , int ind ,int [] dp){
        if(ind >= arr.length){
            return 0;
        }  
        if(dp[ind] != -1){
            return dp[ind];
        }
        int pick = subsequence(arr, ind +2 ,dp) + arr[ind];
        int notpick = subsequence(arr , ind+1 ,dp);
        dp[ind] = Math.max(pick,notpick);
        return dp[ind] ;
    }
    public int rob(int[] nums) { 
        int[] dp = new int[nums.length];
        Arrays.fill(dp ,-1);
        return subsequence(nums,0,dp);
    }
}