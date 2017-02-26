import java.util.ArrayList;

public class HashScorer {
	ArrayList<HashCache> caches;
	ArrayList<HashRequest> requests;
	ArrayList<HashVideo> videos;
	ArrayList<HashEndpoint> endpoints;

	long finalPoints = 0;

	public HashScorer (
		ArrayList<HashCache> cach,
		ArrayList<HashRequest> req,
		ArrayList<HashVideo> vid,
		ArrayList<HashEndpoint> ends) {

		caches = cach;
		requests = req;
		videos = vid;
		endpoints = ends;

		long totalTime = 0;
		long maxTime = 0;
		long savedForReq = 0;
		long points = 0;

		// Max time calculated.
		for (HashRequest r : requests) {
			maxTime += r.getNumRequests() * (r.getSource().dcLatency);
		}

		// Estimated time and points calculated.
		int totalRequests = 0;

		for (HashRequest r : requests) {
			totalRequests += r.getNumRequests();
			int thisLatency = r.getSource().dcLatency;

			ArrayList<HashCache> someCaches = r.getSource().caches;
			for (HashCache c : someCaches) {
				if (c.containsVid(r.getVid())) {
					int someLatency = r.getSource().getCacheLatency(c);
					if (someLatency < thisLatency) {
						thisLatency = someLatency;
					}
				}
			}

			totalTime += thisLatency;
			savedForReq += (r.getSource().dcLatency - thisLatency) * r.getNumRequests();

		}

		points = (savedForReq * 1000) / totalRequests;


		//System.out.println("Optimised Latency : "+totalTime+" ms.");
		System.out.println("Points : " + (points));
		finalPoints = points;

	}

	public long getPoints(){
		return finalPoints;
	}


}
