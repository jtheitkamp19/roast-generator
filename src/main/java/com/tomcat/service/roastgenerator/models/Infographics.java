package com.tomcat.service.roastgenerator.models;

import java.util.List;

public class Infographics {
    private int count;
    private List<Roast> roasts;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Roast> getRoasts() {
        return roasts;
    }

    public void setRoasts(List<Roast> roasts) {
        this.roasts = roasts;
    }
}
