package de.schueler.layoutviewsdemo.data;

public final class Topic {
    private final int titleId;
    private final int imageId;
    private final int descriptionId;

    public Topic(int titleId, int imageId, int descriptionId) {
        this.titleId = titleId;
        this.imageId = imageId;
        this.descriptionId = descriptionId;
    }

    public int getTitleId() {
        return titleId;
    }

    public int getImageId() {
        return imageId;
    }

    public int getDescriptionId() {
        return descriptionId;
    }
}
