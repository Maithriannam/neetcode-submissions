class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean aMatch = false, bMatch = false, cMatch = false;

        for (int[] t : triplets) {
            // Skip invalid triplets (any number bigger than target)
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }

            // Check if any position matches the target
            if (t[0] == target[0]) aMatch = true;
            if (t[1] == target[1]) bMatch = true;
            if (t[2] == target[2]) cMatch = true;
        }

        // If all 3 positions matched somewhere, we can form target
        return aMatch && bMatch && cMatch;
    }
}
