package com.stripe.interview.serverstatusanalysis;

import junit.framework.TestCase;
import org.junit.Test;

public class ServerStatusAnalyzerTest extends TestCase {
    private final String serverStatuses = "BEGIN 0 0 1 END BEGIN 0 1 END";

    @Test
    public void testSequencialOfflineStatusCount(){
        OfflineStatusCountStrategy strategy = new SequentialStatusCountStrategy();
        ServerStatusAnalyzer analyzer = new ServerStatusAnalyzer(strategy);
        int offlineStatuses = analyzer.countOfflineStatuses(serverStatuses);
        assertEquals(2,offlineStatuses);

    }

    @Test
    public void testFindBestTimeTOShutdown(){
        OfflineStatusCountStrategy strategy = new NewConcurrentOfflineStatusCountStrategy();
        ServerStatusAnalyzer analyzer = new ServerStatusAnalyzer(strategy);
        int bestTimeToShutdown =  analyzer.findBestTimeToShutdown(serverStatuses);
        assertEquals(2, bestTimeToShutdown);
    }

}