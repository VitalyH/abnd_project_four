package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        // Floating button Now Playing logic.
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(SongListActivity.this, NowPlayingActivity.class);
                startActivity(nowPlayingIntent);
            }
        });

        // Create an ArrayList of words.
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", R.drawable.n_1));

        // Use SongAdapter.
        SongAdapter adapter = new SongAdapter(this, songs, R.color.category_songs);
        ListView listView = findViewById(R.id.song);
        if (listView != null) {
            listView.setAdapter(adapter);
        }
    }
}
