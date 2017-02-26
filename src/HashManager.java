import java.io.IOException;
import java.util.ArrayList;

public class HashManager {
    public static void main(String[] args) throws IOException {

		String[] FILENAMES = {"kittens", "me_at_the_zoo", "trending_today", "videos_worth_spreading"};

		for (int i = 0; i<FILENAMES.length; i++) {

			String FILENAME = FILENAMES[i];

			String INFILE = "data/"+FILENAME+".in";
			String OUTFILE = "data/"+FILENAME+".out";

			// Create ArrayLists.
			ArrayList<HashCache> caches;
			ArrayList<HashEndpoint> endpoints;
			ArrayList<HashRequest> requests;
			ArrayList<HashVideo> videos;

			System.out.println("Reading from file '"+FILENAME+"'...");

			// Read in from input file.

			HashInputter inputter = new HashInputter(INFILE);
			caches = inputter.caches;
			endpoints = inputter.endpoints;
			requests = inputter.requests;
			videos = inputter.videos;

			System.out.println("File read in.");

			// Optimise caches.
			HashOptimiser optimiser = new HashOptimiser(caches, requests, videos, endpoints);
			caches = optimiser.run();

			System.out.println("Optimisation complete.");

			// Generate output.
			HashOutputter outputter = new HashOutputter(caches, OUTFILE);

			System.out.println("DONE!\n");

		}


    }
}
