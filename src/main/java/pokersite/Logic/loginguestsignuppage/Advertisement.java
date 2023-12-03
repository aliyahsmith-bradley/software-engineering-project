package pokersite.Logic.loginguestsignuppage;

public class Advertisement {
    private String adContent;
    private String adLink;

    public Advertisement(String adContent, String adLink) {
        this.adContent = adContent;
        this.adLink = adLink;
    }

    public String getAdContent() {
        return adContent;
    }

    public String getAdLink() {
        return adLink;
    }
}
