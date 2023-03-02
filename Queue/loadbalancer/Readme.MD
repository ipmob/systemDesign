## High level OOD of load balancer system


### Classes:

- `LoadBalancer` : The main class that handles load balancing. It has a list of servers and implements the load balancing algorithm. It also listens for server load updates and adjusts the load balancing strategy accordingly.
- `Server` : Represents a single server in the load balancer system. It has a unique identifier, an IP address, and a current load.
- `LoadBalancingAlgorithm` : An abstract class that defines the load balancing algorithm. It has a single method that returns the next server to handle a request. Different load balancing algorithms can be implemented by creating subclasses of this class.
- `RoundRobinAlgorithm` : A subclass of LoadBalancingAlgorithm that implements the round-robin load balancing algorithm.
- `WeightedRoundRobinAlgorithm` : A subclass of LoadBalancingAlgorithm that implements the weighted round-robin load balancing algorithm.
- `LoadUpdateListener`: An interface that defines the method to be called when a server load update is received. This interface is implemented by the LoadBalancer class and used by the Server class to notify the load balancer of its current load.


### Responsibilities:

1. The LoadBalancer class is responsible for maintaining a list of servers, implementing the load balancing algorithm, and listening for server load updates.
2. The Server class is responsible for maintaining its own load and notifying the load balancer when its load changes.
3. The LoadBalancingAlgorithm classes are responsible for implementing the different load balancing algorithms.
4. The LoadUpdateListener interface is responsible for defining the method to be called when a server load update is received.


### Interactions:

- When a request comes in, the LoadBalancer class uses its chosen load balancing algorithm to select the next server to handle the request.
- When a server's load changes, it notifies the LoadBalancer class by calling the load update method.
- The LoadBalancer class adjusts its load balancing strategy based on the server load updates it receives.



Overall, this OOD provides a flexible and extensible design for a load balancer system. Different load balancing algorithms can be implemented by creating new subclasses of LoadBalancingAlgorithm, and new server types can be added by creating new subclasses of Server. The LoadBalancer class acts as the central coordinator, listening for server load updates and selecting the next server to handle each request.