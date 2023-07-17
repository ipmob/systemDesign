package com.stripe.interview.serverstatusanalysis;

public interface OfflineStatusCountStrategy {
    int countOfflineStatuses(String[] serverStatuses);
}
