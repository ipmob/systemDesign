package loadbalancer;

import java.util.List;

class ServerMonitor {
    private final List<Server> servers;

    public ServerMonitor(List<Server> servers) {
        this.servers = servers;
    }

    public void startMonitoring() {
        Thread monitoringThread = new Thread(() -> {
            while (true) {
                for (Server server : servers) {
                    server.handleRequest();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        monitoringThread.start();
    }
}



