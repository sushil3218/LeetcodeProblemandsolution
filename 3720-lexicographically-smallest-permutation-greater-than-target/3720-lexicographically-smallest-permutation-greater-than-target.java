class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];

        // Count characters of s
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = new char[s.length()];

        for (int i = 0; i < target.length(); i++) {

            int current = target.charAt(i) - 'a';

            // Try to keep target[i] equal
            if (freq[current] > 0) {

                ans[i] = target.charAt(i);
                freq[current]--;

            } else {

                // Cannot keep target[i].
                // Try smallest character greater than target[i].
                for (int c = current + 1; c < 26; c++) {

                    if (freq[c] > 0) {

                        ans[i] = (char) ('a' + c);
                        freq[c]--;

                        // Fill remaining characters smallest first
                        int pos = i + 1;

                        for (int x = 0; x < 26; x++) {
                            while (freq[x] > 0) {
                                ans[pos++] = (char) ('a' + x);
                                freq[x]--;
                            }
                        }

                        return new String(ans);
                    }
                }

                // No greater character at this position.
                // Backtrack.
                for (int j = i - 1; j >= 0; j--) {

                    // Put ans[j] back into frequency
                    freq[ans[j] - 'a']++;

                    int targetChar = target.charAt(j) - 'a';

                    // Find smallest character greater than target[j]
                    for (int c = targetChar + 1; c < 26; c++) {

                        if (freq[c] > 0) {

                            ans[j] = (char) ('a' + c);
                            freq[c]--;

                            // Fill rest in sorted order
                            int pos = j + 1;

                            for (int x = 0; x < 26; x++) {
                                while (freq[x] > 0) {
                                    ans[pos++] = (char) ('a' + x);
                                    freq[x]--;
                                }
                            }

                            return new String(ans);
                        }
                    }
                }

                return "";
            }
        }

        // We matched target completely.
        // Need a strictly greater permutation.
        for (int j = target.length() - 1; j >= 0; j--) {

            freq[ans[j] - 'a']++;

            int targetChar = target.charAt(j) - 'a';

            for (int c = targetChar + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    ans[j] = (char) ('a' + c);
                    freq[c]--;

                    int pos = j + 1;

                    for (int x = 0; x < 26; x++) {
                        while (freq[x] > 0) {
                            ans[pos++] = (char) ('a' + x);
                            freq[x]--;
                        }
                    }

                    return new String(ans);
                }
            }
        }

        return "";
    }
}