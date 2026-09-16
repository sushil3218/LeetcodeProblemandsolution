class Solution { 
    public static int subsequence(int[] arr , int ind ,int [] dp){
        if(ind < 0){
            return 0;
        }  
        if(ind == 0){
            return arr[0] ;
        } 
        if(dp[ind] != -1){
            return dp[ind];
        }
        int pick = subsequence(arr, ind -2 ,dp) + arr[ind];
        int notpick = subsequence(arr , ind-1 ,dp);
        dp[ind] = Math.max(pick,notpick);
        return dp[ind] ;
    }
    public int rob(int[] nums) { 
        int[] dp = new int[nums.length];
        Arrays.fill(dp ,-1);
        return subsequence(nums,nums.length -1,dp);
    }
}