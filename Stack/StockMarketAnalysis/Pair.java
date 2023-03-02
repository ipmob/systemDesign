package StockMarketAnalysis;

public class Pair<T, U> {
    private final T min;
    private final U max;

    public Pair(T min, U max) {
        this.min = min;
        this.max = max;
    }

    public T getMin() {
        return min;
    }

    public U getMax() {
        return max;
    }
}

