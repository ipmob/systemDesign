package StockMarketAnalysis;

import java.util.Arrays;

public class StockMarketAnalysis {
    public static void main(String[] args) {
        double[] prices = {10.5, 11.2, 12.6, 10.0, 9.5, 8.9};
        StockMarketData basicData = new BasicStockMarketData(prices);
        StockMarketData minMaxData = new MinMaxStockMarketData(basicData, 3);

        System.out.println("Original prices: " + Arrays.toString(prices));
        System.out.println("Min prices within range 0-2: " + minMaxData.getMinPriceInRange(0, 2));
        System.out.println("Max prices within range 0-2: " + minMaxData.getMaxPriceInRange(0, 2));
        System.out.println("Min prices within range 1-4: " + minMaxData.getMinPriceInRange(1, 4));
        System.out.println("Max prices within range 1-4: " + minMaxData.getMaxPriceInRange(1, 4));
    }
}
