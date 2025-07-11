// GFG 160 DSA Sheet - Day 7
// Stock Buy and Sell - Multiple Transactions Allowed

public class Day_7 {
    public static int maximumProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;

        for (int i = 1; i < n; i++) {
            // if today's price is higher than yesterday's, we sell today
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    // Sample driver code to test the function
    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        int result = maximumProfit(prices);
        System.out.println("Maximum Profit: " + result);  // Output: 865
    }
}
