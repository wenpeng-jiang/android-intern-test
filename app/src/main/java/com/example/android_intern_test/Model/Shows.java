package com.example.android_intern_test.Model;

import java.sql.Timestamp;
import java.util.List;

public class Shows {
    private int id;
    private String url;
    private String name;
    private int season;
    private int number;
    private String airdate;
    private String airtime;
    private Timestamp airstamp;
    private int runtime;
    private Image image;
    private String summary;
    private Links _links;

    public Shows(int id, String url, String name, int season, int number, String airdate, String airtime, Timestamp airstamp, int runtime, Image image, String summary, Links _links) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.season = season;
        this.number = number;
        this.airdate = airdate;
        this.airtime = airtime;
        this.airstamp = airstamp;
        this.runtime = runtime;
        this.image = image;
        this.summary = summary;
        this._links = _links;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public void setAirdate(String airdate) {
        this.airdate = airdate;
    }

    public void setAirtime(String airtime) {
        this.airtime = airtime;
    }

    public void setAirstamp(Timestamp airstamp) {
        this.airstamp = airstamp;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void set_links(Links _links) {
        this._links = _links;
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

    public Image getImage() {
        return image;
    }

    public String getSummary() {
        return summary;
    }

    public Links get_links() {
        return _links;
    }
}
