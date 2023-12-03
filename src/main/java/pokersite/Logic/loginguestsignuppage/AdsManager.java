package pokersite.Logic.loginguestsignuppage;

import java.util.ArrayList;
import java.util.List;

public class AdsManager {
    private static List<Advertisement> ads = new ArrayList<>();

    static {
        // Add sample ads
        ads.add(new Advertisement("Ad 1 Content", "images/New_game.png"));
        ads.add(new Advertisement("Ad 2 Content", "images/Christmas_ad.png"));
        // Add more ads
    }

    public static List<Advertisement> getAds() {
        return ads;
    }

    public static List<Advertisement> getGetAds() { return ads;}

}
