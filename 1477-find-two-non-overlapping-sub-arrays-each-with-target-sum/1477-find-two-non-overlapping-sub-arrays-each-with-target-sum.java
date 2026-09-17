class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int[] best = new int[n];

        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            // Shrink window if sum becomes too large
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // If current subarray has target sum
            if (sum == target) {

                int len = right - left + 1;

                // Check previous non-overlapping subarray
                if (left > 0 && best[left - 1] != 0) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                // Keep shortest subarray ending at/before right
                minLen = Math.min(minLen, len);
            }

            // Store best answer up to this index
            if (right > 0) {
                best[right] = best[right - 1];
            }

            if (sum == target) {
                best[right] = Math.min(
                    best[right] == 0 ? Integer.MAX_VALUE : best[right],
                    minLen
                );
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}