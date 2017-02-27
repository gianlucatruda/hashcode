import java.util.ArrayList;

public class HashOptimiser {
	ArrayList<HashCache> caches;
	ArrayList<HashRequest> requests;
	ArrayList<HashVideo> videos;
	ArrayList<HashEndpoint> endpoints;

    public HashOptimiser (
		ArrayList<HashCache> cach,
		ArrayList<HashRequest> req,
		ArrayList<HashVideo> vid,
		ArrayList<HashEndpoint> ends) {

		caches = cach;
		requests = req;
		videos = vid;
		endpoints = ends;

    }

	public ArrayList<HashCache> run() {
		ArrayList<HashVideo> orphans = new ArrayList<>();
		requests.sort(new HashRequest()); // requests sorted from most to least using custom comparator.

		int hardLimit = (int) Math.floor(1000000000/(2*requests.size()*caches.size()));
		for(HashRequest r : requests) { // Loops through every request (bundle).
			int limit = r.getSource().caches.size();
			if(limit > hardLimit) {limit = hardLimit;}
			for (int i = 0; i < limit; i++) { // Loops through every cache.
				HashCache nearest = r.getSource().getCachesByProximity().get(i); // Gets the next nearest cache.
				if(nearest.getRemaining() >= r.getVid().getSize()) { // If not full, adds the video to the cache.
					nearest.addVideo(r.getVid());
					break;
				} if(i == (limit - 1)) {
					orphans.add(r.getVid()); // If no space in the fastest x caches, add to orphans list.
				}
			}
		}

		for(HashVideo v : orphans) {
			for(HashCache c : caches) {
				if(c.getRemaining() >= v.getSize()) {
					c.addVideo(v);
					break;
				}
			}
		}

		System.out.println("Orphans : "+orphans.size());



		return caches;
	}

}
