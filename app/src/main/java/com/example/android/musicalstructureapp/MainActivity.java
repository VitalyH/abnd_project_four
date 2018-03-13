package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    // Find the View's that show the categories
    TextView now_playing = findViewById(R.id.now_playing);
    TextView song_list = findViewById(R.id.song_list);
    TextView playlists = findViewById(R.id.playlists);
    TextView music_store = findViewById(R.id.music_store);

    // Now Playing category listener
        //if (now_playing != null) {
        now_playing.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                startActivity(numbersIntent);
            }
        });
    //}

    // Songs list category listener
        if (song_list != null) {
        song_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familyIntent = new Intent(MainActivity.this, SongListActivity.class);
                startActivity(familyIntent);
            }
        });
    }

    // Playlists category listener
        if (playlists != null) {
        playlists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorsIntent = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(colorsIntent);
            }
        });
    }

    // Music store category listener
        if (music_store != null) {
        music_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent(MainActivity.this, MusicStoreActivity.class);
                startActivity(phrasesIntent);
            }
        });
    }

}

}

