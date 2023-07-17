package com.stripe.interview.ratelimiter1;


public class RateLimiterExample {
    public static void main(String[] args) {
        RateLimiter limiter = new BurstySmoothRateLimiter(1, 10);
        Thread[] group = new Thread[6];
        Runnable r = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (limiter.acquire()) {
                    System.out.println("Values:- " + Thread.currentThread().getName() + ": " + i);
                }
            }
        };


        for (int i = 0; i < 6; i++) {
            group[i] = new Thread(r);
            group[i].start();
        }
    }
}

