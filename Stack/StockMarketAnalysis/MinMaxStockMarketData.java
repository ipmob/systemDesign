package StockMarketAnalysis;

public class MinMaxStockMarketData extends StockMarketDecorator {
    private final RangeStack<Double> minRangeStack;
    private final RangeStack<Double> maxRangeStack;

    public MinMaxStockMarketData(StockMarketData stockMarketData, int range) {
        super(stockMarketData);
        minRangeStack = new RangeStack<>(range, Double::min);
        maxRangeStack = new RangeStack<>(range, Double::max);

        for (int i = 0; i < stockMarketData.getSize(); i++) {
            double price = stockMarketData.getPriceAtTime(i);
            minRangeStack.push(price);
            maxRangeStack.push(price);
        }
    }
    @Override
    public double getMinPriceInRange(int startTime, int endTime) {
        Pair <Double,Double> minMaxPair = minRangeStack.get(startTime, endTime);
        return Double.parseDouble(minMaxPair.getMin().toString());
    }
    @Override
    public double getMaxPriceInRange(int startTime, int endTime) {

        Pair<Double,Double> minMaxPair =  maxRangeStack.get(startTime, endTime);
        return Double.parseDouble(minMaxPair.getMax().toString());
    }
}
