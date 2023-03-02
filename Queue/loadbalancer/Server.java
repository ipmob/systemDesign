package loadbalancer;

public class Server {
    private int id;
    private int weight;
    private int load;

    public Server(int id, int weight, int load) {
        this.id = id;
        this.weight = weight;
        this.load = load;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public int getLoad() {
        return load;
    }

    public void handleRequest() {
        load++;
        System.out.println("Server " + id + " handling request. Current load: " + load);
    }
}
