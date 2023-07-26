package com.stripe.interview.serverstatusanalysis;

class ServerStatusAnalyzer {
    private final OfflineStatusCountStrategy offlineStatusCountStrategy;

    public ServerStatusAnalyzer(OfflineStatusCountStrategy offlineStatusCountStrategy) {
        this.offlineStatusCountStrategy = offlineStatusCountStrategy;
    }

    public int countOfflineStatuses(String serverStatuses) {
        String[] statuses = serverStatuses.split(" ");
        return offlineStatusCountStrategy.countOfflineStatuses(statuses);
    }

    /**
     * T
     * @param serverStatuses
     * @return
     */
    public int findBestTimeToShutdown(String serverStatuses) {
        String[] statuses = serverStatuses.split(" ");
        int longestSequence = 0;
        int currentSequence = 0;

        for (String status : statuses) {
            if (status.equals("0")) {
                currentSequence++;
                longestSequence = Math.max(longestSequence, currentSequence);
            } else {
                currentSequence = 0;
            }
        }

        return longestSequence;
    }

    public static void main(String[] args) {
        String serverStatuses = "BEGIN 0 0 1 END BEGIN 0 1 END";

        OfflineStatusCountStrategy sequentialStrategy = new SequentialStatusCountStrategy();
        ServerStatusAnalyzer sequentialAnalyzer = new ServerStatusAnalyzer(sequentialStrategy);
        int sequentialOfflineStatuses = sequentialAnalyzer.countOfflineStatuses(serverStatuses);
        System.out.println("Number of times the server was offline (Sequential): " + sequentialOfflineStatuses);

        OfflineStatusCountStrategy concurrentStrategy = new ConcurrentOfflineStatusCountStrategy();
        ServerStatusAnalyzer concurrentAnalyzer = new ServerStatusAnalyzer(concurrentStrategy);
        int concurrentOfflineStatuses = concurrentAnalyzer.countOfflineStatuses(serverStatuses);
        System.out.println("Number of times the server was offline (Concurrent): " + concurrentOfflineStatuses);

        OfflineStatusCountStrategy newConcurrentStrategy = new NewConcurrentOfflineStatusCountStrategy();
        ServerStatusAnalyzer newConcurrentAnalyzer =  new ServerStatusAnalyzer(newConcurrentStrategy);
        int newConcurrentOfflineStatus = newConcurrentAnalyzer.countOfflineStatuses(serverStatuses);
        System.out.println("Number of times the server was offline (New Concurrent): " + newConcurrentOfflineStatus);


        int bestTimeToShutdown = concurrentAnalyzer.findBestTimeToShutdown(serverStatuses);
        System.out.println("Best time to take the server offline: " + bestTimeToShutdown);
    }
}

