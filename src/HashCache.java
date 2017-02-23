import java.util.ArrayList;

public class HashCache {
    public int size; // The size of the cache in MB.
    public ArrayList<HashVideo> videos = new ArrayList<>();

    public HashCache(ArrayList<HashVideo> vids) {
        //endpoints = new ArrayList(5000);
        videos = new ArrayList<HashVideo>(5000);
        for (HashVideo v : vids) {
            videos.add(v);
        }
    }

    public ArrayList<HashVideo> getVideos() {
        return videos;
    }
}