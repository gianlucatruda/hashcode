import javax.xml.ws.Endpoint;

public class Request {
    public Endpoint source;
    public Video vid;
    public int numRequests;

    public Request(Endpoint s, Video v, int req) {
        this.source = s;
        this.vid = v;
        this.numRequests = req;
    }

    public int getNumRequests() {
        return numRequests;
    }

    public Endpoint getSource() {
        return source;
    }

    public Video getVid() {
        return vid;
    }
}