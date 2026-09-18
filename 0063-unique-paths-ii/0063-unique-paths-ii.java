class Solution { 
    public static int findPaths(int i , int  j , int[][]arr ,int[][] dp){
        if(i< 0|| j< 0 || arr[i][j] == 1 ){
            return 0 ;
        }
        if(i == 0 && j == 0){
            return 1 ;
        }
        if(dp[i][j] != -1){
             return dp[i][j] ;
        }
        int up = findPaths( i-1 , j ,arr , dp);
        int left =findPaths( i , j-1, arr , dp);
        return dp[i][j] = up + left ;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n =  obstacleGrid.length ;
        int m = obstacleGrid[0].length ;
        int[] [] dp = new int[n][m] ;
        for(int i = 0; i< n ; i ++){
            Arrays.fill(dp[i] , -1) ;
        }
      return findPaths(n-1 , m-1 , obstacleGrid , dp);
    }
}