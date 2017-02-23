import java.util.ArrayList;

public class HashOptimiser {

    public HashOptimiser(   ArrayList<HashCache> cach,
                            ArrayList<HashRequest> req,
                            ArrayList<HashVideo> vid,
                            ArrayList<HashEndpoint> ends
                        ){
        int currentCache = 0;
        int total =0;
        for (int i=0; i<req.size();i++){
            total += req.get(i).getNumRequests();
        }
        int average = total/req.size();

        for (int i=0; i<req.size();i++){
            if (req.get(i).getNumRequests()>average){
                if ((cach.get(currentCache).size - cach.get(currentCache).fullness) > req.get(i).getVid().getSize() ){
                    cach.get(currentCache)
                }
            }
        }


    }

}
