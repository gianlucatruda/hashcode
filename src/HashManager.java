import java.util.ArrayList;

public class HashManager {
    public static void main(String[] args) {
        System.out.println("hello world.");

        String INFILE = "me_at_the_zoo.in";
        String OUTFILE = "me_at_the_zoo.out";

        // Create ArrayLists.
        ArrayList<HashCache> caches;
        ArrayList<HashEndpoint> endpoints;
        ArrayList<HashRequest> requests;
        ArrayList<HashVideo> videos;

        // Read in from input file.
        HashInputter inputter = new HashInputter(INFILE);
        //some code to update the arraylists.

        // Optimise caches.
        HashOptimiser optimiser = new HashOptimiser();
        //Some code to call optimiser.

        // Generate output.
        HashOutputter outputter = new HashOutputter(caches, OUTFILE);


    }
}