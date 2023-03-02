package loadbalancer;

import java.util.ArrayList;
import java.util.List;

public class WightedLoadBalancer extends LoadBalancer{
    public WightedLoadBalancer(LoadBalancingStrategy strategy){
        super(strategy);
    }

    @Override
    protected List<Server> getServers() {
        List<Server> servers = new ArrayList<>();
        servers.add(new Server(1, 5,4));
        servers.add(new Server(2, 2, 3));
        servers.add(new Server(3, 3,0));
        return servers;
    }
}
