import java.util.ArrayList;

public class Cache {
    public int size; // The size of the cache in MB.
    public ArrayList endpoints;
    public ArrayList videos;

    public Cache(ArrayList eps, ArrayList vids) {
        endpoints = new ArrayList(5000);
        videos = new ArrayList(5000);
        for (Object v : vids) {
            videos.add(v);
        }
        for (Object e : eps) {
            endpoints.add(e);
        }

    }
}