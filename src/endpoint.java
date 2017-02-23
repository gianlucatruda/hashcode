import java.util.ArrayList;

public class Endpoint {
    public int dcLatency; // The latency to the datacenter.
    public ArrayList caches;
    public ArrayList cacheLatencies;

    public Endpoint(int dcLat, ArrayList cacheServers, ArrayList cLat) {
        this.dcLatency = dcLat;
        for (Object c : cacheServers) {
            caches.add(c);
        }
        for (Object l : cLat) {
            cacheLatencies.add(l);
        }
    }

    public int getDcLatency() {
        return dcLatency;
    }
}