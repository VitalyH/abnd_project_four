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
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                startActivity(nowPlayingIntent);
            }
        });
    //}

    // Songs list category listener
        if (song_list != null) {
        song_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songListIntent = new Intent(MainActivity.this, SongListActivity.class);
                startActivity(songListIntent);
            }
        });
    }

    // Playlists category listener
        if (playlists != null) {
        playlists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playlistsIntent = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(playlistsIntent);
            }
        });
    }

    // Music store category listener
        if (music_store != null) {
        music_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent musicStoreIntent = new Intent(MainActivity.this, MusicStoreActivity.class);
                startActivity(musicStoreIntent);
            }
        });
    }

}

}

