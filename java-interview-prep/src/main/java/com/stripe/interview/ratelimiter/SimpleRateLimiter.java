package com.stripe.interview.ratelimiter;

import java.util.concurrent.TimeUnit;
public class SimpleRateLimiter implements RateLimiter {
    private final Object lock = new Object();
    private final Object boundaryLock = new Object();

    private final long TPS;
    private final long NANO_PER_SEC = TimeUnit.SECONDS.toNanos(1);

    private long lastExecutionNanos = 0L;
    private long nextSecondBoundary = 0L;
    private int counter = 0;

    public SimpleRateLimiter(long tps) {
        this.TPS = tps;
    }

    private void invoke(Code code) {
        if (code != null) {
            code.invoke();
        }
    }

    @Override
    public boolean throttle(Code code) {
        if (TPS <= 0) {
            return false;
        }

        synchronized (lock) {
            if (lastExecutionNanos == 0L) {
                counter++;
                lastExecutionNanos = System.nanoTime();
                nextSecondBoundary = lastExecutionNanos + NANO_PER_SEC;
                invoke(code);
                return true;
            } else {
                long now = System.nanoTime();
                if (now <= nextSecondBoundary) {
                    if (counter < TPS) {
                        lastExecutionNanos = now;
                        counter++;
                        invoke(code);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    counter = 0;
                    lastExecutionNanos = 0L;
                    nextSecondBoundary = 0L;
                    return throttle(code);
                }
            }
        }
    }

    @Override
    public boolean enter() {
        if (TPS == 0L) {
            return false;
        }

        synchronized (boundaryLock) {
            if (lastExecutionNanos == 0L) {
                lastExecutionNanos = System.nanoTime();
                counter++;
                nextSecondBoundary = lastExecutionNanos + NANO_PER_SEC;
                return true;
            } else {
                long now = System.nanoTime();
                if (now <= nextSecondBoundary) {
                    if (counter < TPS) {
                        lastExecutionNanos = now;
                        counter++;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    counter = 0;
                    lastExecutionNanos = 0L;
                    nextSecondBoundary = 0L;
                    return enter();
                }
            }
        }
    }
}
