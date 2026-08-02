class Solution {  
    //  Queck sort recurtion 
    public static void sortings(int[] arr , int low , int high){
        if(low < high){
        int piovt = partition(arr, low , high);
            sortings(arr, low , piovt-1);
            sortings(arr, piovt+1 , high);
        }
    } 
    // partion of arraya lift said samller than piovt and right said biger than piovt 
    public static int partition(int[] arr , int low ,  int high){
        int piovt = arr[high];
        int i  = low -1 ;
        for(int j =i+1; j<high ; j++){
            if(arr[j]<piovt){
                i++; 
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j]= temp ;
            }
        } 
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp ;
        return i+1 ;

    } 
    // method calling were stating 0 and high is arr.length -1 
    public void sortColors(int[] nums) {
        sortings(nums , 0, nums.length-1);
    }
}