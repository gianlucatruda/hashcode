import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class HashOutputter {
    public ArrayList<HashCache> caches;

    public HashOutputter(ArrayList<HashCache> c, String filename) throws IOException {
        this.caches = c;

        String outText = "";
        outText += Integer.toString(caches.size()-1) + "\n";
        for(int i = 0; i< caches.size(); i++) {
            outText += Integer.toString(i);
            ArrayList<HashVideo> vids = caches.get(i).getVideos();
            for(int j = 0; j<vids.size(); j++) {
                outText += " " + Integer.toString(vids.get(j).getID());
            }
            outText += "\n";
        }

        FileWriter fw = new FileWriter(filename, true);
        try (PrintWriter pw = new PrintWriter(fw)) {
            pw.println(outText);
        }
    }

}
