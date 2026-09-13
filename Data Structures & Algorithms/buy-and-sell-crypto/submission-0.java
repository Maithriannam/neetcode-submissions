class Solution {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price); // track lowest buy
            maxProfit = Math.max(maxProfit, price - minPrice); // best sell
        }
        return maxProfit;
    }
}