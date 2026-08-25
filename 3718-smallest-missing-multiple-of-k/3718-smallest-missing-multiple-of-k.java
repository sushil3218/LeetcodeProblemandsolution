class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set  = new HashSet<>();
        for(int i : nums){
            set.add(i);
        } 
        int i = 1 ;
        while(i<i+1){
            if(!set.contains(i*k)){
                return i*k ;
            } 
            i++ ;
        } 
        return 0 ;
    }
}