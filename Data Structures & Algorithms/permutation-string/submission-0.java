class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        // Step 1: fill s1 frequency and initial window in s2
        for (int i = 0; i < n; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        // Step 2: check first window
        if (Arrays.equals(map1, map2)) return true;

        // Step 3: slide the window
        for (int j = n; j < m; j++) {
            // add rightmost character
            map2[s2.charAt(j) - 'a']++;
            // remove leftmost character
            map2[s2.charAt(j - n) - 'a']--;

            if (Arrays.equals(map1, map2)) return true;
        }

        return false;
    }
}
