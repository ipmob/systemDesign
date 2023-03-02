package StockMarketAnalysis;

public class BasicStockMarketData implements  StockMarketData {
    private final double[] prices;

    public BasicStockMarketData(double[] prices) {
        this.prices = prices;
    }

    @Override
    public double getPriceAtTime(int time) {
        return prices[time];
    }
    @Override
    public int getSize(){
        return prices.length;
    }

    @Override
    public double getMaxPriceInRange(int start, int end) {
        return 0;
    }

    @Override
    public double getMinPriceInRange(int start, int end) {
        return 0;
    }
}
