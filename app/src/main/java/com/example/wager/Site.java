package com.example.wager;

import com.google.gson.annotations.SerializedName;

public class Site {
    @SerializedName("site_key")
    private String siteKey;
    @SerializedName("site_nice")
    private String siteNice;
    @SerializedName("last_update")
    private Integer lastUpdate;
    private Odds odds;

    public String getSiteKey() {
        return siteKey;
    }

    public String getSiteNice() {
        return siteNice;
    }

    public Integer getLastUpdate() {
        return lastUpdate;
    }

    public Odds getOdds() {
        return odds;
    }
}
