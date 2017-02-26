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

		for (int i = 0; i < videos.size() ; i++) {
			HashVideo thisVid = videos.get(i);
			for (int j = 0; j < caches.size(); j++) {
				HashCache thisCache = caches.get(j);
				if(thisCache.getRemaining() >= thisVid.getSize()) {
					thisCache.addVideo(thisVid);
				}
			}
		}

		return caches;
	}

}
