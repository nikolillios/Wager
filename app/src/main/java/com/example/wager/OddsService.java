package com.example.wager;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface OddsService {

    @Headers({
            "x-rapidapi-host: odds.p.rapidapi.com",
            "x-rapidapi-key: b67bb69b21msh70b34d8ba95e957p167261jsn5faa5e149910"
    })
    @GET("/v1/odds?sport=americanfootball_nfl&region=us&mkt=h2h")
    Call<OddsPackage> getNFLOdds();
}