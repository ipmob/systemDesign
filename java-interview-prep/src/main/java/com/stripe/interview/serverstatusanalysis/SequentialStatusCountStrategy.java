package com.stripe.interview.serverstatusanalysis;

public class SequentialStatusCountStrategy implements OfflineStatusCountStrategy{
    @Override
    public int countOfflineStatuses(String[] serverStatuses) {
        int count = 0;
        for (String status : serverStatuses) {
            if (status.equals("1")) {
                count++;
            }
        }
        return count;
    }
}
