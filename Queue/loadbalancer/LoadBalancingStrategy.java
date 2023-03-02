package loadbalancer;

import java.util.List;

public interface LoadBalancingStrategy {
    Server nextServer (List<Server> servers);
}
