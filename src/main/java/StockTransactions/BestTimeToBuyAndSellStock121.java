package StockTransactions;

/**
 * @author mac Say you have an array for which the ith element is the price of a
 *         given stock on day i.
 * 
 *         If you were only permitted to complete at most one transaction (i.e.,
 *         buy one and sell one share of the stock), design an algorithm to find
 *         the maximum profit.
 * 
 *         Note that you cannot sell a stock before you buy one.
 * 
 *         Example 1:
 * 
 *         Input: [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1)
 *         and sell on day 5 (price = 6), profit = 6-1 = 5. Not 7-1 = 6, as
 *         selling price needs to be larger than buying price. Example 2:
 * 
 *         Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no
 *         transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock121 {
	public int maxProfit(int[] prices) {
		/*
		 * [7,1,5,3,6,4]
		 * 
		 * min 1 profit 4 4 5
		 */
		if (prices == null || prices.length == 0)
			return 0;
		int profit = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > min) {
				profit = Math.max(profit, prices[i] - min);
			} else {
				min = prices[i];
			}
		}
		return profit;
	}
}
