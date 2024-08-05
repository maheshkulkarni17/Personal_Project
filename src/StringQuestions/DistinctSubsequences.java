package StringQuestions;

import java.util.HashSet;
import java.util.Set;

public class DistinctSubsequences {

    static int countSub(String str) {
        int n = (int) str.length();

        // Stores the count of
        // subStrings
        int ans = 0;

        // Stores the frequency
        // of characters
        int[] cnt = new int[26];

        // Initialised both pointers
        // to beginning of the String
        int i = 0, j = 0;

        while (i < n) {

            // If all characters in
            // subString from index i
            // to j are distinct
            if (j < n &&
                    (cnt[str.charAt(j) - 'a'] == 0)) {

                // Increment count of j-th
                // character
                cnt[str.charAt(j) - 'a']++;

                // Add all subString ending
                // at j and starting at any
                // index between i and j
                // to the answer
                ans += (j - i + 1);

                // Increment 2nd pointer
                j++;
            }

            // If some characters are repeated
            // or j pointer has reached to end
            else {

                // Decrement count of j-th
                // character
                cnt[str.charAt(i) - 'a']--;

                // Increment first pointer
                i++;
            }
        }

        // Return the final
        // count of subStrings
        return ans;
    }

    // Driver Code
    public static void main(String[] args) {
        String str = "abac";

        System.out.print(countSub(str));

    }
}