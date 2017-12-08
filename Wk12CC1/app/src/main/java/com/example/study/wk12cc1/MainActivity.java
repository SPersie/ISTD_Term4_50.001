package com.example.study.wk12cc1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity  {

    AnimeJsonData[] animeJsonData;
    private RecyclerView animeList;
    private AnimeAdapter mAnimeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 3 - read the saved json file and parse it (see the TODOs below)
        parseJson();


        //TODO 4.9 get a reference to the recycler view widget
        animeList = (RecyclerView) findViewById(R.id.anime_list);
        //TODO 4.10 create an instance of LinearLayoutManager and
        //          assign it to the recycler view object
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        animeList.setLayoutManager(linearLayoutManager);

        //TODO 4.11 create an instance of the Adapter and
        //          assign it to the recycler view object
        mAnimeAdapter = new AnimeAdapter(this,animeJsonData);
        animeList.setAdapter(mAnimeAdapter);



    }

    //TODO 3.1 Create an inner class matching the keys of the JSON array
    public class AnimeJsonData{

        String name;
        String anime;
        String file;
        //complete the rest

    }

    private String readTxt(int resource){

        InputStream inputStream = getResources().openRawResource(resource);

        //TODO 3.2 Complete readTxt to take in a resource ID of a file,
        //          read it and return it as a single string
        String out = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line;

            while ((line = reader.readLine()) != null) {
                out += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;



    }

    void parseJson(){

        Gson gson = new Gson();
        //TODO 3.3 Invoke readTxt
        String myJsonData = readTxt(R.raw.pictures);
        //TODO 3.4 parse the JSON file
        Log.i("Linwei",myJsonData);
        animeJsonData = gson.fromJson(myJsonData,AnimeJsonData[].class);



    }
}