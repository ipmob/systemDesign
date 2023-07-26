package com.stripe.interview.ratelimiter;

public class Main {
    public static void main(String[] args) {
        RateLimiter rateLimiter = new SimpleRateLimiter(5); // 100 TPS

        // Execute multiple requests and check if they are allowed or rate-limited
        testRequest(rateLimiter, "192.168.0.1"); // Allowed
        testRequest(rateLimiter, "192.168.0.1"); // Allowed
        testRequest(rateLimiter, "192.168.0.1"); // Allowed

        testRequest(rateLimiter, "192.168.0.2"); // Allowed
        testRequest(rateLimiter, "192.168.0.2"); // Allowed

        testRequest(rateLimiter, "192.168.0.3"); // Allowed
        testRequest(rateLimiter, "192.168.0.3"); // Allowed
        testRequest(rateLimiter, "192.168.0.3"); // Allowed
        testRequest(rateLimiter, "192.168.0.3"); // Allowed
        testRequest(rateLimiter, "192.168.0.3"); // Allowed

        testRequest(rateLimiter, "192.168.0.3"); // Rate-limited

        testRequest(rateLimiter, "192.168.0.4"); // Allowed
        testRequest(rateLimiter, "192.168.0.4"); // Allowed
        // ... continue testing with more requests

    }

    private static void testRequest(RateLimiter rateLimiter, String ipAddress) {
        boolean allowed = rateLimiter.enter();
        System.out.println("IP: " + ipAddress + " | Request Allowed: " + allowed);
    }
}

