package com.example.wager;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Competition {
    @SerializedName("sport_key")
    private String sportKey;
    @SerializedName("sport_nice")
    private String league;
    private ArrayList<String> teams;
    @SerializedName("commence_time")
    private Integer commenceTime;
    @SerializedName("home_team")
    private String homeTeam;
    private List<Site> sites;
    @SerializedName("sites_count")
    private Integer sitesCount;

    public String getSportKey() {
        return sportKey;
    }

    public String getLeague() {
        return league;
    }

    public ArrayList<String> getTeams() {
        return teams;
    }

    public Integer getCommenceTime() {
        return commenceTime;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public List<Site> getSites() {
        return sites;
    }

    public Integer getSitesCount() {
        return sitesCount;
    }
}
