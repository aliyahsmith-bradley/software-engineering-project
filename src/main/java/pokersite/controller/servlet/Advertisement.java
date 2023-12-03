package pokersite.controller.servlet;

public class Advertisement {
    private String content;
    private String link;

    public Advertisement(String content, String link) {
        this.content = content;
        this.link = link;
    }

    public String getContent() {
        return content;
    }

    public String getLink() {
        return link;
    }
}
