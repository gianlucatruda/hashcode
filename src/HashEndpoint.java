import java.util.ArrayList;

public class HashEndpoint {
    public int dcLatency; // The latency to the datacenter.
    public ArrayList<HashCache> caches = new ArrayList<>();
    public ArrayList<Integer> cacheLatencies = new ArrayList<Integer>();

    public HashEndpoint(int dcLat, ArrayList<HashCache> cacheServers, ArrayList<Integer> cLat) {
        this.dcLatency = dcLat;
        for (HashCache c : cacheServers) {
            caches.add(c);
        }
        for (Integer l : cLat) {
            cacheLatencies.add(l);
        }
    }

    public int getDcLatency() {
        return dcLatency;
    }

	public int getCacheLatency(HashCache cache) {
		for(HashCache c : caches) {
			if(c.ID == cache.ID) {
				return cacheLatencies.get(caches.indexOf(c));
			}
		}
		return 100000000;
	}

	public HashCache getNearestCache() {
		int minLatency = dcLatency;
		HashCache nearCache = new HashCache(-1, -1);
		for(HashCache c : caches) {
			if(getCacheLatency(c) < minLatency){
				minLatency = getCacheLatency(c);
				nearCache = c;
			}
		}

		return nearCache;
	}
}
