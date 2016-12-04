package de.schueler.layoutviewsdemo.data;

public final class Topic {
    private final int titleId;
    private final String imagePath;

    public Topic(int titleId, String imagePath) {
        this.titleId = titleId;
        this.imagePath = imagePath;
    }

    public int getTitleId() {
        return titleId;
    }

    public String getImagePath() {
        return imagePath;
    }
}
