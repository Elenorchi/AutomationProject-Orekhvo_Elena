package Base.HerokuApp;

public enum HomePageEnum {
    COMTEXT_MENU("Context Menu"),
    DYNAMIC_CONTROLS("Dynamic Controls"),
    FILE_UPLOAD ("File Upload"),
    FRAMES ("Frames");
    String link;

    HomePageEnum(String link) {
        this.link = link;
    }

    public String getLinkText() {
        return link;
    }
}
