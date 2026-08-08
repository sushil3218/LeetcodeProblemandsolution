import java.util.*;

class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // suffix[j] = latest index in word1
        // from which word2[j...] can be matched exactly
        int[] suffix = new int[m + 1];

        Arrays.fill(suffix, -1);

        suffix[m] = n;

        int p = n - 1;

        // Build suffix information from right to left
        for (int j = m - 1; j >= 0; j--) {

            while (p >= 0 &&
                   word1.charAt(p) != word2.charAt(j)) {
                p--;
            }

            if (p < 0) {
                break;
            }

            suffix[j] = p;
            p--;
        }

        int[] ans = new int[m];

        int i = 0;
        int j = 0;

        boolean mismatchUsed = false;

        while (j < m) {

            boolean found = false;

            while (i < n) {

                // Already used our one allowed mismatch
                if (mismatchUsed) {

                    if (word1.charAt(i) == word2.charAt(j)) {

                        ans[j] = i;

                        i++;
                        j++;

                        found = true;
                        break;
                    }

                    i++;
                }

                // Mismatch is still available
                else {

                    // Case 1: Characters are equal
                    if (word1.charAt(i) == word2.charAt(j)) {

                        ans[j] = i;

                        i++;
                        j++;

                        found = true;
                        break;
                    }

                    // Case 2: Characters are different.
                    // We can use our one mismatch here
                    // only if the remaining part can be
                    // matched exactly.
                    else {

                        boolean last = (j == m - 1);

                        boolean canTake =
                                last || suffix[j + 1] > i;

                        if (canTake) {

                            ans[j] = i;

                            i++;
                            j++;

                            mismatchUsed = true;

                            found = true;
                            break;
                        }

                        // This index is not safe.
                        i++;
                    }
                }
            }

            // We couldn't find an index
            if (!found) {
                return new int[0];
            }
        }

        return ans;
    }
}