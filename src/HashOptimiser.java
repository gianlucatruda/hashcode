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

		ArrayList<HashVideo> overflow = new ArrayList<>(500); // Videos which can't fit on first pass.

		requests.sort(new HashRequest()); // requests sorted from most to least using custom comparator.

		for(HashRequest r : requests) {
			HashCache nearest = r.getSource().getNearestCache();
			if(nearest.getRemaining() >= r.getVid().getSize()) {
				nearest.addVideo(r.getVid());
			} else {
				overflow.add(r.getVid());
			}
		}

		return caches;
	}

}
