package com.example.android.musicalstructureapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {

    private boolean isPlaying = false;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        // Scrolling Text (Marque) in Now Playing
        TextView marque = this.findViewById(R.id.artist_name);
        marque.setSelected(true);


        // Initialize floating action button.
        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Play/Pause state logic.
                if (isPlaying) {
                    fab.setImageDrawable(ContextCompat.getDrawable(context, android.R.drawable.ic_media_pause));
                    isPlaying = false;
                } else {
                    fab.setImageDrawable(ContextCompat.getDrawable(context, android.R.drawable.ic_media_play));
                    isPlaying = true;
                }

                //Intent nowPlayingIntent = new Intent(SongListActivity.this, NowPlayingActivity.class);
                //startActivity(nowPlayingIntent);
            }
        });

        // Create an ArrayList of songs.
        // Hardcode them. In real app they wouldn't be there anyway (SQLite, ext. source, etc.)
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "€5", R.drawable.n_1));

        // Use SongAdapter.
        SongAdapter adapter = new SongAdapter(this, songs, R.color.category_songs);
        ListView listView = findViewById(R.id.song);
        if (listView != null) {
            listView.setAdapter(adapter);
        }

        // Top menu
        // Find the View's that show the categories
        TextView song_list = findViewById(R.id.song_list);
        TextView playlists = findViewById(R.id.playlists);
        TextView music_store = findViewById(R.id.music_store);


        // Songs list category listener
      //  if (song_list != null) {
            song_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent songListIntent = new Intent(SongListActivity.this, SongListActivity.class);
                    startActivity(songListIntent);
                }
            });
        //}

        // Playlists category listener
        if (playlists != null) {
            playlists.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent playlistsIntent = new Intent(SongListActivity.this, PlaylistActivity.class);
                    startActivity(playlistsIntent);
                }
            });
        }

        // Music store category listener
        if (music_store != null) {
            music_store.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent musicStoreIntent = new Intent(SongListActivity.this, MusicStoreActivity.class);
                    startActivity(musicStoreIntent);
                }
            });
        }

    }
}
