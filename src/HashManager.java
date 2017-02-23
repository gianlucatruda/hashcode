import java.io.IOException;
import java.util.ArrayList;

public class HashManager {
    public static void main(String[] args) throws IOException {
        System.out.println("Processing...");

        String INFILE = "data/me_at_the_zoo.in";
        String OUTFILE = "data/me_at_the_zoo.out";

        // Create ArrayLists.
        ArrayList<HashCache> caches;
        ArrayList<HashEndpoint> endpoints;
        ArrayList<HashRequest> requests;
        ArrayList<HashVideo> videos;

        // Read in from input file.

        HashInputter inputter = new HashInputter(INFILE);
        caches = inputter.caches;
        endpoints = inputter.endpoints;
        requests = inputter.requests;
        videos = inputter.videos;

        // Optimise caches.
        HashOptimiser optimiser = new HashOptimiser(caches, requests, videos, endpoints);
        //Some code to call optimiser.

        // Generate output.
        HashOutputter outputter = new HashOutputter(caches, OUTFILE);

        System.out.println("Complete!");


    }
}