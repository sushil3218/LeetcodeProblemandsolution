class Solution {

    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = (long) k * getMin(coins);

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // Count how many different amounts are <= x
    private long count(long x, int[] coins) {

        long ans = 0;
        int n = coins.length;

        // All possible subsets of coins
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    lcm = getLCM(lcm, coins[i]);

                    // No multiple of this LCM can be <= x
                    if (lcm > x) {
                        break;
                    }
                }
            }

            if (lcm > x) {
                continue;
            }

            long value = x / lcm;

            // Odd number of coins -> add
            if (bits % 2 == 1) {
                ans += value;
            }
            // Even number of coins -> subtract
            else {
                ans -= value;
            }
        }

        return ans;
    }

    private long getGCD(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private long getLCM(long a, long b) {

        return (a / getGCD(a, b)) * b;
    }

    private int getMin(int[] coins) {

        int min = coins[0];

        for (int coin : coins) {
            min = Math.min(min, coin);
        }

        return min;
    }
}