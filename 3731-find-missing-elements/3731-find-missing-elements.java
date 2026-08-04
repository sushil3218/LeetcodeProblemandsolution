class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        //sorting 
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();  
        // first loop start from 0 gp at numms.length
        for(int i=0; i<nums.length-1;i++){
            // second loop just adding +1 in number nums[i] addin list j runing up to  nums[i+1] number ;
            // like start from nums[i] = 1 go up to +1 2 3 4 if nums[i+1]= 5 so
            for(int j=nums[i]+1; j<nums[i+1]; j++){
                list.add(j);
            }
        }
        System.out.println(list);
        return list ;
    }
}