package com.stripe.interview.ratelimiterfinal;

public interface RateLimitStrategy {
    boolean allowRequest();

    void registerRequest();

    void reset();
}
