package loadbalancer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class WeightedRoundRobinLoadBalancingStrategy implements LoadBalancingStrategy {
    @Override
    public Server nextServer(List<Server> servers) {
        List<Integer> weights = new ArrayList<>();
        for (Server server : servers) {
            weights.add(server.getWeight());
        }
        int totalWeight = weights.stream().mapToInt(Integer::intValue).sum();
        int randomWeight = ThreadLocalRandom.current().nextInt(0, totalWeight);
        AtomicInteger cumulativeWeight = new AtomicInteger(0);
        return servers.stream().filter(server -> {
                    cumulativeWeight.addAndGet(server.getWeight());
                    return randomWeight < cumulativeWeight.get();
                })
                .findFirst()
                .orElse(servers.get(servers.size() - 1));
    }
}
