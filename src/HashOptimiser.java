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
		requests.sort(new HashRequest()); // requests sorted from most to least using custom comparator.

		for(HashRequest r : requests) { // Loops through every request (bundle).
			for (int i = 0; i < r.getSource().caches.size(); i++) { // Loops through every cache.
				HashCache nearest = r.getSource().getCachesByProximity().get(i); // Gets the next nearest cache.
				if(nearest.getRemaining() >= r.getVid().getSize()) { // If not full, adds the video to the cache.
					nearest.addVideo(r.getVid());
					break;
				}
			}
		}

		return caches;
	}

}
