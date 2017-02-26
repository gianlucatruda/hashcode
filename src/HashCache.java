import java.util.ArrayList;

public class HashCache {
    public int size; // The size of the cache in MB.
    public int ID;
    public ArrayList<HashVideo> videos = new ArrayList<>();
    public int remaining;

    public HashCache(int id, int s) {
        this.ID = id;
        this.size = s;
        this.remaining = this.size;
    }

	public void addVideo(HashVideo v) {
		if(!containsVid(v)) {
			videos.add(v);
			remaining -= v.getSize();
		}
	}

	public int getRemaining() { return remaining; }

    public ArrayList<HashVideo> getVideos() {
        return videos;
    }

	public boolean containsVid(HashVideo v) {
		for (int i = 0; i < videos.size() ; i++) {
			if (videos.get(i).getID() == v.getID())
				return true;
		}
		return false;
	}
}
