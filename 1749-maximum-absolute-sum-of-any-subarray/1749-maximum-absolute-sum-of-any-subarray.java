class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0; 
        int cur = 0; 
        int min = 0; 
        int curmin = 0;
         int sum = 0 ;
        for(int n : nums)  {
       cur = Math.max(n , cur+n); 
       max = Math.max(max ,cur); 
       curmin = Math.min(n , curmin+n);
       min = Math.min(curmin , min);
        }
        return Math.max(max ,-min) ;
      }

}