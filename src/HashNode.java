import java.util.Comparator;

public class HashNode implements Comparator<HashNode> {
	public int latency;
	public int cacheID;

	public HashNode(int lat, int id) {
		this.latency = lat;
		this.cacheID = id;

	}

	public HashNode() {

	}

	public int getLatency() {
		return latency;
	}

	public int getCacheID() {
		return cacheID;
	}

	@Override
	public int compare(HashNode o1, HashNode o2) {
		return o1.getLatency() - o2.getLatency();
	}
}
