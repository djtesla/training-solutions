package methoverloading.pub;

import java.util.List;

public class ListOfGoodPubs {

    private List<Pub> pubs;

    public ListOfGoodPubs(List<Pub> pubs) {

        if (pubs == null || pubs.size() == 0) {
            throw new IllegalArgumentException("Pub list is empty!");
        }

        this.pubs = pubs;
    }

    public Pub findTheBest() {

        Pub pubBest = null;

        for (Pub pub : pubs) {
            if (pubBest == null || pub.isEarlier(pubBest)) {
                pubBest = pub;
            }
        }
        return pubBest;
    }

}
