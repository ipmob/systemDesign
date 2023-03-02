package loadbalancer;

import java.util.List;

public class RoundRobinLoadBalancingStrategy implements LoadBalancingStrategy {
    private int currentIndex = 0;

    @Override
    public Server nextServer(List<Server> servers) {
        Server server = servers.get(currentIndex);
        currentIndex = (currentIndex + 1) % servers.size();
        return server;
    }
}
