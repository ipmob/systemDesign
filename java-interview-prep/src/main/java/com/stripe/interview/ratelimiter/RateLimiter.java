package com.stripe.interview.ratelimiter;

public interface RateLimiter {
    /**
     * Rate limits the code passed inside as an argument.
     *
     * @param code representation of the piece of code that needs to be rate limited.
     * @return true if executed, false otherwise.
     */
    boolean throttle(Code code);
    /**
     * When the piece of code that needs to be rate limited cannot be represented as a contiguous
     * code, then entry() should be used before we start executing the code. This brings the code inside the rate
     * limiting boundaries.
     *
     * @return true if the code will execute and false if rate limited.
     * <p
     */
    boolean enter();
    /**
     * Interface to represent a contiguous piece of code that needs to be rate limited.
     */
    interface Code {
        /**
         * Calling this function should execute the code that is delegated to this interface.
         */
        void invoke();
    }
}
