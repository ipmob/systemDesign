package com.stripe.interview.ratelimiterfinal;

public class FixedWindowRateLimitStrategy implements RateLimitStrategy {
    private final int capacity;
    private int count;

    public FixedWindowRateLimitStrategy(int capacity) {
        this.capacity = capacity;
        this.count = 0;
    }

    @Override
    public boolean allowRequest() {
        return count < capacity;
    }

    @Override
    public void registerRequest() {
        count++;
    }

    @Override
    public void reset() {
        count = 0;
    }
}
