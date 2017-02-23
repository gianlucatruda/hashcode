public class Endpoint {
    public int dcLatency; // The latency to the datacenter.

    public Endpoint(int dcLat) {
        this.dcLatency = dcLat;
    }

    public int getDcLatency() {
        return dcLatency;
    }
}