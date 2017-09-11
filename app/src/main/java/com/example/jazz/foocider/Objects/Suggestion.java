package com.example.jazz.foocider.Objects;

import android.net.Uri;

/**
 * Created by jazz on 12/9/17.
 */

public class Suggestion {

    private String name;
    private Uri img = null;
    private int visted = 0;
    private double preference = 0.0;

    public Suggestion() {
    }

    public Suggestion(String name, Uri img, int visted, double preference) {
        this.name = name;
        this.img = img;
        this.visted = visted;
        this.preference = preference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getImg() {
        return img;
    }

    public void setImg(Uri img) {
        this.img = img;
    }

    public int getVisted() {
        return visted;
    }

    public void setVisted(int visted) {
        this.visted = visted;
    }

    public double getPreference() {
        return preference;
    }

    public void setPreference(double preference) {
        this.preference = preference;
    }
}
