package StockMarketAnalysis;

public interface StockMarketData {
    double getPriceAtTime(int time);
     int getSize();

    double getMaxPriceInRange(int start, int end);
    double getMinPriceInRange(int start, int end);
}
