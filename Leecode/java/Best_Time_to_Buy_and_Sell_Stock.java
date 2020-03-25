class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPriice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPriice) {
                minPriice = prices[i];
                continue;
            }
            if (maxProfit < prices[i] - minPriice) {
                maxProfit = prices[i] - minPriice;
            }

        }

        return maxProfit;
    }
}