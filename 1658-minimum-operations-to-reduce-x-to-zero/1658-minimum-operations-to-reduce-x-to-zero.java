class Solution {
    public int minOperations(int[] nums, int x) { 
        int n = nums.length ;
        int total = 0 ;
        for(int i= 0; i< n; i++){
            total += nums[i] ;
        } 
        int target = total - x ; 
        if(target <0){
            return -1;
        }
        if(target == 0){
                return n ;
            }
        int sum = 0; 
        int left = 0; 
        int count = -1 ;
        for(int right = 0; right<n ; right++){
            sum +=nums[right] ;
            while(sum > target){
                sum -= nums[left++];
            }
            if(sum == target){
              count = Math.max(count , right - left +1);
            }
            
        }
        if(count == -1){
                return -1 ;
            }
            return n- count ;
    }
}