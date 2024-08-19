class Solution {
    public int maxProfit(int[] prices) {
        // Best Time to Buy and Sell Stock I m ek transaction kr sakte the
        // // Best Time to Buy and Sell Stock II m unlimited transaction kr sakte the
        // // Best Time to Buy and Sell Stock III m atmost 2 transaction kr sakte the

        // teeno ques m max profit hi return krna hai

        if (prices == null || prices.length == 0) {
            return 0;
        }

        // Initialize variables to store profits
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for (int price : prices) {
            // Max profit after first buy
            firstBuy = Math.max(firstBuy, -price);
            // Max profit after first sell
            firstSell = Math.max(firstSell, firstBuy + price);
            // Max profit after second buy
            secondBuy = Math.max(secondBuy, firstSell - price);
            // Max profit after second sell
            secondSell = Math.max(secondSell, secondBuy + price);
        }

        // Second sell gives the maximum profit possible
        return secondSell;
    }
}