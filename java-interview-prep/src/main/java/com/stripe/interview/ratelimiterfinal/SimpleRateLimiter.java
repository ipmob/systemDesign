package com.stripe.interview.ratelimiterfinal;

public class SimpleRateLimiter implements RateLimiter {
    private final RateLimitStrategy strategy;

    public SimpleRateLimiter(RateLimitStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public boolean throttle(Code code) {
        if (strategy.allowRequest()) {
            strategy.registerRequest();
            code.execute();
            return true;
        }
        return false;
    }

    @Override
    public boolean enter() {
        if (strategy.allowRequest()) {
            strategy.registerRequest();
            return true;
        }
        return false;
    }
}
