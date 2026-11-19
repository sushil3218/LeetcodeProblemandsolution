class Solution {
    public int minimizeSum(int[] nums) {
          Arrays.sort(nums);

        // Step 2: Find array length
        int n = nums.length;

        // Step 3: Calculate all three possibilities

        // Change two smallest elements
        int ans1 = nums[n - 1] - nums[2];

        // Change smallest and largest elements
        int ans2 = nums[n - 2] - nums[1];

        // Change two largest elements
        int ans3 = nums[n - 3] - nums[0];

        // Step 4: Return minimum answer
        return Math.min(ans1, Math.min(ans2, ans3));
    }
}