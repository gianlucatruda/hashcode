public class HashVideo {
    public int size; //Size of video in MB.
    public int ID; // The ID of the video.

    public HashVideo(int id, int s) { // s is the size passed in at construction.
        this.ID = id;
        this.size = s;
    }

    public int getSize() {
        return size;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}