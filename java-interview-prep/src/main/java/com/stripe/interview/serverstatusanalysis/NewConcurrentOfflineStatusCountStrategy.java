package com.stripe.interview.serverstatusanalysis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class NewConcurrentOfflineStatusCountStrategy implements OfflineStatusCountStrategy {
    @Override
    public int countOfflineStatuses(String[] serverStatuses) {
        AtomicInteger count = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (String status : serverStatuses) {
            executorService.submit(() -> {
                if (status.equals("1")) {
                    synchronized (ConcurrentOfflineStatusCountStrategy.class) {
                        count.getAndIncrement();
                    }
                }
            });
        }


        executorService.shutdown();
        try{
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        return count.get();
    }
}
