package com.stripe.interview.serverstatusanalysis;

public class ServerShutdown {
    public static int countOfflineStatuses(String serverStatuses) {
        int count = 0;
        String[] statuses = serverStatuses.split(" ");
        for (String status : statuses) {
            if (status.equals("1")) {
                count++;
            }
        }
        return count;
    }

    public static int findBestTimeToShutdown(String serverStatuses) {
        int longestSequence = 0;
        int currentSequence = 0;
        boolean inSequence = false;
        String[] statuses = serverStatuses.split(" ");
        for (String status : statuses) {
            if (status.equals("0")) {
                if (inSequence) {
                    currentSequence++;
                } else {
                    inSequence = true;
                    currentSequence = 1;
                }
            } else {
                inSequence = false;
                if (currentSequence > longestSequence) {
                    longestSequence = currentSequence;
                }
            }
        }
        return longestSequence;
    }

    public static void main(String[] args){
        String serverStatuses = "BEGIN 0 0 1 END BEGIN 0 1 END";
        int offlineStatuses = countOfflineStatuses(serverStatuses);
        System.out.println("Number of times the server was offline : " + offlineStatuses);

        int bestTimeToShutdown = findBestTimeToShutdown(serverStatuses);
        System.out.println(bestTimeToShutdown);

    }


}
