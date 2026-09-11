class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int buy = - prices[0];
        int sell = 0;
    
        for(int i=1; i<prices.length; i++)
        {
            int buyOld = buy;
            int sellOld = sell;

            buy = Math.max(buyOld, sellOld - prices[i]);

            sell = Math.max(sellOld, buyOld + prices[i] - fee);
        }

        return sell;
    }
}