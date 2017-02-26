public class HashRequest {
    public HashEndpoint source;
    public HashVideo vid;
    public int numRequests;

    public HashRequest(HashEndpoint s, HashVideo v, int req) {
        this.source = s;
        this.vid = v;
        this.numRequests = req;
    }

    public int getNumRequests() {
        return numRequests;
    }

    public HashEndpoint getSource() {
        return source;
    }

    public HashVideo getVid() {
        return vid;
    }

}
