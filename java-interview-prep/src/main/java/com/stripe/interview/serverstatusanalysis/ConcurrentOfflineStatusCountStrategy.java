package com.stripe.interview.serverstatusanalysis;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class ConcurrentOfflineStatusCountStrategy implements OfflineStatusCountStrategy {
    @Override
    public int countOfflineStatuses(String[] serverStatuses) {
        AtomicInteger count = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();

        // Create and start a separate thread for each status
        for (String status : serverStatuses) {
            Thread thread = new Thread(() -> {
                if (status.equals("1")) {
                    synchronized (ConcurrentOfflineStatusCountStrategy.class) {
                        count.getAndIncrement();
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

        return count.get();
    }
}
