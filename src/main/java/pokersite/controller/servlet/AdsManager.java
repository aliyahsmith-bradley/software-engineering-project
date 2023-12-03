package pokersite.controller.servlet;

// AdsManager.java
import java.util.ArrayList;
import java.util.List;

public class AdsManager {
    private static List<Advertisement> ads = new ArrayList<>();

    static {
        // Add sample ads
        ads.add(new Advertisement("Ad 1 Content", "images/New_game.png"));
        ads.add(new Advertisement("Ad 2 Content", "images/Christmas_ad.png"));

    }

    public static List<Advertisement> getAds() {
        return ads;
    }
}

