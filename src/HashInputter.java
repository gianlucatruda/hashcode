import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HashInputter {
    // Reader for hashcode problem

    String textfile;
    int num_videos;
    int num_endpoints;
    int num_requests;
    int num_caches;
    int cache_capacity;
    int endpointsProcessed = 0;
    int currentCache = 0;
    boolean isComplete = false;
	int totalLines = 0;
	int currentLine;

    ArrayList<HashVideo> videos = new ArrayList<>(num_videos);
    ArrayList<HashCache> caches = new ArrayList<>(num_caches);
    ArrayList<HashRequest> requests = new ArrayList<>(num_requests);
    ArrayList<HashEndpoint> endpoints = new ArrayList<>(num_endpoints);

    public HashInputter(String textfile){
        this.textfile = textfile;

		// Code to count lines and log progress.
		try {
			Scanner scanner = new Scanner(new File(textfile));
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				totalLines++;
			}
			System.out.println("File of "+totalLines+" lines.");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

        try {
            // scanner for the whole textfile
            Scanner scanner = new Scanner(new File(textfile));

            // process the first line in format of "V E R C X"
			String line = scanner.nextLine();

            String[] lineArr = line.split(" ");
            num_videos = Integer.parseInt(lineArr[0]);
            num_endpoints = Integer.parseInt(lineArr[1]);
            num_requests = Integer.parseInt(lineArr[2]);
            num_caches = Integer.parseInt(lineArr[3]);
            cache_capacity = Integer.parseInt(lineArr[4]);

            // process the second line in format of "s1 s2 s3 s4..."
            // each number represents the size of the video
            line = scanner.nextLine();
            lineArr = line.split(" ");
			System.out.println("Processing "+num_videos+" videos.");
			for (int i=0; i<lineArr.length; i++){
                HashVideo video = new HashVideo(i, Integer.valueOf(lineArr[i]));
                videos.add(video);
            }

            // creates the caches
			System.out.println("Processing "+num_caches+" caches.");
            for (int i=0; i<num_caches;i++){
                caches.add(new HashCache(i, cache_capacity));
            }
            // process the endpoint line and then the corresponding cache lines
			System.out.println("Processing "+num_endpoints+" endpoints.");
            for (int i=0; i<num_endpoints; i++){
                line = scanner.nextLine();
                lineArr = line.split(" ");
                int latency = Integer.valueOf(lineArr[0]);
                int numCachesForEndpoint = Integer.parseInt(lineArr[1]);
                ArrayList endpointsCaches = new ArrayList(numCachesForEndpoint);
                ArrayList latencies = new ArrayList(numCachesForEndpoint);
                for (int j=0; j<numCachesForEndpoint;j++){
                    line = scanner.nextLine();
                    lineArr = line.split(" ");
                    endpointsCaches.add(caches.get(Integer.valueOf(lineArr[0])));
                    latencies.add(Integer.valueOf(lineArr[1]));
                }
                HashEndpoint ed = new HashEndpoint(latency,endpointsCaches,latencies);
                endpoints.add(ed);
            }

            // process the requests with format "Rv Re Rn"
			System.out.println("Processing "+num_requests+" requests.");
            for (int i=0; i<num_requests; i++){
                line = scanner.nextLine();
                lineArr = line.split(" ");
                int vidnum = Integer.valueOf(lineArr[0]);
                int endnum = Integer.valueOf(lineArr[1]);
                int numberofrequests = Integer.valueOf(lineArr[2]);
                HashRequest re = new HashRequest(endpoints.get(endnum),videos.get(vidnum),numberofrequests);
                requests.add(re);
            }

            isComplete = true;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}

