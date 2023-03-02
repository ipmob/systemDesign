package loadbalancer;

import java.util.List;

public abstract class LoadBalancer {
    protected LoadBalancingStrategy strategy;

    public LoadBalancer(LoadBalancingStrategy strategy) {
        this.strategy = strategy;
    }


    public void distributedRequest(){
        List <Server> servers = getServers();
        Server server = strategy.nextServer(servers);
        server.handleRequest();
    }

    protected abstract List<Server> getServers();
}
