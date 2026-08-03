class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>(); 
        combition(candidates,0, target ,new ArrayList<>(), ans);
        return ans ; 
    } 
    public static void combition(int[] arr , int index ,int target, ArrayList<Integer> list , List<List<Integer>>ans){
        // base condition
        if(index == arr.length){
            if(target == 0){
                ans.add( new ArrayList<>(list));
            }
            return ;
        } 
        // take same index 
        if(arr[index] <= target){
            list.add(arr[index]);
            combition(arr,index, target -arr[index] , list , ans);
            list.remove(list.size()-1);
        } 
        // take different index 
        combition(arr, index +1,target , list , ans);
    }
}