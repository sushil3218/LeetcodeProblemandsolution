class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) { 
        if(k<= 1){
            return 0;
        }
        int i = 0;
        int product = 1 ;
        int count  =0; 
        // travling the arr product the array
        for(int j=0; j<nums.length; j++){
            product *= nums[j]; 
            // if product is more than k div by lift lift ++ ;
            while(product >= k){
                product /= nums[i];
                i++ ;
            } 
            // count the subarray  by the length subarray l equals to the length of window by length  count the number of sub array 
            count += j-i+1;
        }
        return count ;
    }
}