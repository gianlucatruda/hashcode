import java.util.Comparator;

public class HashRequest implements Comparator<HashRequest> {
    public HashEndpoint source;
    public HashVideo vid;
    public int numRequests;

    public HashRequest(HashEndpoint s, HashVideo v, int req) {
        this.source = s;
        this.vid = v;
        this.numRequests = req;
    }

	public HashRequest() {

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

	@Override
	public int compare(HashRequest o1, HashRequest o2) { // Compares based on number of requests.
		return o2.getNumRequests() - o1.getNumRequests();
	}
}
