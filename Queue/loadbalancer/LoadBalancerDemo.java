package loadbalancer;

public class LoadBalancerDemo {
    public static void main(String[] args) {
        LoadBalancer loadBalancer = new WightedLoadBalancer(new WeightedRoundRobinLoadBalancingStrategy());
        ServerMonitor serverMonitor = new ServerMonitor(loadBalancer.getServers());
        serverMonitor.startMonitoring();

        for (int i = 0; i < 10; i++) {
            loadBalancer.distributedRequest();
        }
    }
}
