package com.stripe.interview.ratelimiterfinal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // Create the rate limiter with a specific rate limit strategy
        RateLimitStrategy strategy = new SlidingWindowRateLimitStrategy(10);
        RateLimiter rateLimiter = new SimpleRateLimiter(strategy);

        // Create an executor service with a fixed thread pool size
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit multiple requests as tasks to the executor
        for (int i = 0; i < 50; i++) {
            executor.submit(() -> {
                boolean requestAllowed = rateLimiter.throttle(() -> {
                    System.out.println("API request executed by thread: " + Thread.currentThread().getName());
                });

                if (requestAllowed) {
                    System.out.println("Request allowed");
                } else {
                    System.out.println("Request rate-limited");
                }
            });

            try {
                Thread.sleep(100); // Sleep for 100 milliseconds between task submissions
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Shutdown the executor service to terminate the thread
        executor.shutdown();

    }
}
