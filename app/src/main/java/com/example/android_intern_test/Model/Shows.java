package com.example.android_intern_test.Model;

import java.sql.Timestamp;
import java.util.List;

public class Shows {
    private int id;
    private String url;
    private String name;
    private int season;
    private String airdate;
    private String airtime;
    private Timestamp airstamp;
    private int runtime;
    private List<String> image;
    private String summary;
    private List<List<String>> _links;

    public Shows(String summary){
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public int getSeason() {
        return season;
    }

    public String getAirdate() {
        return airdate;
    }

    public String getAirtime() {
        return airtime;
    }

    public Timestamp getAirstamp() {
        return airstamp;
    }

    public int getRuntime() {
        return runtime;
    }

    public List<String> getImage() {
        return image;
    }

    public String getSummary() {
        return summary;
    }

    public List<List<String>> get_links() {
        return _links;
    }
}
