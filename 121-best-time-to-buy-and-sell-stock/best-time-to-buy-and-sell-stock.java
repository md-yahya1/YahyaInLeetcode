class Solution {
    public int maxProfit(int[] prices) {
        
        int minBuy = prices[0];
        int maxSell = 0;

        for(int i=1; i<prices.length; i++)
        {
            minBuy = Math.min(minBuy, prices[i]);
            int profit = prices[i] - minBuy;

            maxSell =  Math.max(profit, maxSell);
        }

        return maxSell;
    }
}