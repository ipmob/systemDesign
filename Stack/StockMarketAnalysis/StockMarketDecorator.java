package StockMarketAnalysis;

public abstract class StockMarketDecorator implements StockMarketData {
    protected StockMarketData stockMarketData;
    public StockMarketDecorator(StockMarketData stockMarketData) {
        this.stockMarketData = stockMarketData;
    }

    @Override
    public double getPriceAtTime(int time){
        return stockMarketData.getPriceAtTime(time);
    }

    @Override
    public int getSize(){
        return stockMarketData.getSize();
    }
}
