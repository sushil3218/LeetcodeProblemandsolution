class Solution {
    public int maxAbsoluteSum(int[] nums) {
       int max =  0; 
       int currmax = 0; 
       int min = 0; 
       int currmin = 0;
       for(int i =0; i<nums.length;i++){
          currmax =Math.max(nums[i] , nums[i]+currmax);
          max = Math.max(currmax , max);
          currmin =Math.min(nums[i] , nums[i]+currmin); 
          min = Math.min(currmin,min);

       } 
       return Math.max(max, -min);
    }
}