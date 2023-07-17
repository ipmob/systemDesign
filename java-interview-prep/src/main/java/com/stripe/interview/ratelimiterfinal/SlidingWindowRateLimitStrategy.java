package com.stripe.interview.ratelimiterfinal;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowRateLimitStrategy implements RateLimitStrategy {
    private final int capacity;
    private final Queue<Long> timestamps;

    public SlidingWindowRateLimitStrategy(int capacity) {
        this.capacity = capacity;
        this.timestamps = new LinkedList<>();
    }

    @Override
    public boolean allowRequest() {
        long currentTimestamp = System.currentTimeMillis();
        cleanupOldRequests(currentTimestamp);
        return timestamps.size() < capacity;
    }

    @Override
    public void registerRequest() {
        long currentTimestamp = System.currentTimeMillis();
        cleanupOldRequests(currentTimestamp);
        timestamps.add(currentTimestamp);
    }

    @Override
    public void reset() {
        timestamps.clear();
    }

    private void cleanupOldRequests(long currentTimestamp) {
        while (!timestamps.isEmpty() && timestamps.peek() <= currentTimestamp - 1000) {
            timestamps.poll();
        }
    }
}
