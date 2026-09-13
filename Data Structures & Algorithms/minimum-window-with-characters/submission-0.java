public class Solution {
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        // Count characters in t
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        // Sliding window variables
        Map<Character, Integer> window = new HashMap<>();
        int have = 0;                     // how many characters meet requirement
        int need = tCount.size();          // total unique characters we need
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Check if this character meets the required count
            if (tCount.containsKey(c) && window.get(c).intValue() == tCount.get(c).intValue()) {
                have++;
            }

            // Shrink window from left if valid
            while (have == need) {
                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (tCount.containsKey(leftChar) && window.get(leftChar) < tCount.get(leftChar)) {
                    have--;
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));  // Output: "BANC"
    }
}
