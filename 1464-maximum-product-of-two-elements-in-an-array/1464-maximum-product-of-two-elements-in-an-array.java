class Solution {
    public int maxProduct(int[] nums) {
        int maxsum = 0; 
        for(int i =0; i<nums.length; i++){
            int sum = 0;
            for(int j =i+1; j<nums.length; j++){
                sum = (nums[i] -1)* (nums[j] -1);
                maxsum = Math.max(maxsum , sum );
            }
        } 
         return maxsum ;
    }
}