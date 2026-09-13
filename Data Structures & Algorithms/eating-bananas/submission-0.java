class Solution {
    // Function to calculate total hours if Koko eats at speed = hourly
    private int calculateTotalHours(int[] piles, int hourly) {
        int totalH = 0;
        for (int pile : piles) {
            // ceil(pile / hourly) = (pile + hourly - 1) / hourly
            totalH += (pile + hourly - 1) / hourly;
        }
        return totalH;
    }

    // Function to find maximum pile
    private int findMax(int[] piles) {
        int maxi = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxi = Math.max(maxi, pile);
        }
        return maxi;
    }

    // Main function to find minimum eating speed
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);

        while (low <= high) {
            int mid = low + (high - low) / 2; // avoid overflow
            int totalH = calculateTotalHours(piles, mid);

            if (totalH <= h) {
                high = mid - 1; // try smaller speed
            } else {
                low = mid + 1;  // need bigger speed
            }
        }
        return low; // minimum valid speed
    }

}