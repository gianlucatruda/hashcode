import java.util.ArrayList;

public class HashCache {
    public int size; // The size of the cache in MB.
    public int ID;
    public ArrayList<HashVideo> videos = new ArrayList<>();

    public HashCache(int id, ArrayList<HashVideo> vids) {
        this.ID = id;
        videos = new ArrayList<HashVideo>(5000);
        for (HashVideo v : vids) {
            videos.add(v);
        }
    }

    public ArrayList<HashVideo> getVideos() {
        return videos;
    }
}