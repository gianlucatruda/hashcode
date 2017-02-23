import javax.xml.ws.Endpoint;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Brigitte on 2017/02/23.
 */
public class Inputter {
    // Reader for hashcode problem

    String textfile;
    int num_videos;
    int num_endpoints;
    int num_requests;
    int num_caches;
    int cache_capacity;
    int endpointsProcessed = 0;
    int currentCache = 0;

    Video[] videos = new Video[num_videos];
    Cache[] caches = new Cache[num_caches];
    Request[] requests = new Request[num_requests];
    Endpoint[] endpoints = new Endpoint[num_endpoints];

    boolean initialLine = false;
    boolean videoLine = false;
    boolean endpointSegment = false;


    public Inputter(String textfile){
        this.textfile = textfile;

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
            for (int i=0; i<lineArr.length; i++){
                Video video = new Video(i, lineArr[i]);
                videos[i] = video;
            }

            // creates the caches
            for (int i=0; i<num_caches;i++){
                caches[i] = new Cache(cache_capacity);
            }

            // process the endpoint line and then the corresponding cache lines
            for (int i=0; i<num_endpoints; i++){
                line = scanner.nextLine();
                lineArr = line.split(" ");
                int latency = Integer.parseInt(lineArr[0]);
                int numCachesForEndpoint = Integer.parseInt(lineArr[1]);
                Cache[] endpointsCaches = new Cache[numCachesForEndpoint];
                for (int j=0; j<numCachesForEndpoint;j++){
                    line = scanner.nextLine();
                    lineArr = line.split(" ");

                }
                Endpoint ed = new Endpoint();
            }


            /*
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(" ");
                */

                if (!initialLine && !videoLine) {
                    // gets first line in format of "V E R C X"
                    num_videos = Integer.parseInt(lineScanner.next());
                    num_endpoints = Integer.parseInt(lineScanner.next());
                    num_requests = Integer.parseInt(lineScanner.next());
                    num_caches = Integer.parseInt(lineScanner.next());
                    cache_capacity = Integer.parseInt(lineScanner.next());
                    initialLine =  true;

                    //makes empty caches
                    for (int i=0; i<num_caches;i++){
                        caches[i] = new Cache(cache_capacity);
                    }

                } else if (initialLine && !videoLine && !endpointSegment){
                    // gets second line in format of "s1 s2 s3 s4..."
                    // each number represents the size of the video
                    for (int i=0;i<num_videos;i++){
                        Video video = new Video(i, lineScanner.nextInt());
                        videos[i] = video;
                    }
                    videoLine=true;
                }
                else if (initialLine && videoLine && !endpointSegment){
                    // logics to get to endpoint processing
                    if (endpointsProcessed < num_endpoints && currentCache==0){

                    }
                }





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

