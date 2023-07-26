package com.stripe.interview.ratelimiterfinal;

public interface RateLimiter {
    boolean throttle(Code code);
    boolean enter();

    interface Code {
        void execute();
    }
}

