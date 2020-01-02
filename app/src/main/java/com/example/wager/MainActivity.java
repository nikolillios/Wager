package com.example.wager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Competition> competitions= new ArrayList<>();
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recyclerView= findViewById(R.id.my_recycler_view);
        // layoutManager= new LinearLayoutManager(this);
        // recyclerView.setLayoutManager(layoutManager);
        textView= findViewById(R.id.textView2);
        setAdapter();
    }

    private void setAdapter() {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://odds.p.rapidapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OddsService service= retrofit.create(OddsService.class);
        Call<OddsPackage> call= service.getNFLOdds();
        call.enqueue(new Callback<OddsPackage>(){
            @Override
            public void onResponse(Call<OddsPackage> call, Response<OddsPackage> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code:" + response.code());
                    return;
                }
                OddsPackage oddsPackage= response.body();
                for (Competition comp: oddsPackage.getData()) {
                    competitions.add(comp);
                    String content= "";
                    content += "Home Team: " + comp.getHomeTeam() + "\n";
                    content += "League: " + comp.getLeague() + "\n";
                    content += "Opponent: " + comp.getTeams().get(1) + "\n";
                    for (Site site: comp.getSites()) {
                        content += "Site: " + site.getSiteNice() + "\n";
                        content += "Odds: " + site.getOdds().getH2h().get(0) + "\n";
                    }
                    content += "\n\n";
                    textView.append(content);
                }
            }
            @Override
            public void onFailure(Call<OddsPackage> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

}
