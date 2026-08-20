class Solution {
    public int[] resultArray(int[] nums) {
        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length]; 
        int i =0; 
        int j = 0;  
        arr1[0] = nums[0];
        arr2[0] = nums[1] ;
        for(int k =2 ; k<nums.length ; k++ ){
            if(arr1[i]>arr2[j]){ 
                i++;
                arr1[i] = nums[k];
            }else{
                j++;
                arr2[j] =nums[k];
            }
        } 
        for(int k =0; k<=j; k++){
            i++;
            arr1[i] = arr2[k];
        } 
        return arr1 ;
    }
}