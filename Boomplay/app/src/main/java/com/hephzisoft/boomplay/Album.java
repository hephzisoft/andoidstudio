package com.hephzisoft.boomplay;

public class Album {

    private int album_image;
    private String album_name;

    public Album(int album_image, String album_name) {
        this.album_image = album_image;
        this.album_name = album_name;
    }

    public int getAlbum_image() {
        return album_image;
    }

    public void setAlbum_image(int album_image) {
        this.album_image = album_image;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }
}
