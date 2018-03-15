package com.example.android.musicalstructureapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
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
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {


    private boolean isPlaying = true;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        // Scrolling Text (Marque) in Now Playing
        TextView marqueArtistName = this.findViewById(R.id.artist_name);
        marqueArtistName.setSelected(true);


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
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", R.drawable.n_1));
        songs.add(new Song("Pop Corn - Remix Version 87 Special D'J", "M & H Band", R.drawable.n_2));
        songs.add(new Song("Dame", "Fly Project", R.drawable.n_3));
        songs.add(new Song("Catch A Faya - Remaniax Radio Edit", "Dancehall Kings", R.drawable.n_4));
        songs.add(new Song("Mainframe", "Alex", R.drawable.n_5));
        songs.add(new Song("Katchi (Ofenbach vs. Nick Waterhouse)", "Ofenbach, Nick Waterhouse", R.drawable.n_6));
        songs.add(new Song("Brick England", "Jean-Michel Jarre, Pet Shop Boys", R.drawable.n_7));
        songs.add(new Song("Prisencolinensinainciusol", "MINACELENTANO", R.drawable.n_8));
        songs.add(new Song("'Till I Collapse", "Eminem, Nate Dogg", R.drawable.n_9));
        songs.add(new Song("In the Army Now - Radio Mix", "Captain Jack", R.drawable.n_10));
        songs.add(new Song("Katarakta (feat. Mela Koteluk)", "Daniel Bloom, Mela Koteluk", R.drawable.n_11));
        songs.add(new Song("Slice Me Nice - Deep Hammer Remix", "Fancy, Adam van Hammer", R.drawable.n_12));
        songs.add(new Song("Judas", "Lady Gaga", R.drawable.n_13));
        songs.add(new Song("Extreme Ways (Jason Bourne)", "Moby", R.drawable.n_14));
        songs.add(new Song("Moscow Calling", "Gorkiy Park", R.drawable.n_15));
        songs.add(new Song("Mombasa", "2Cellos", R.drawable.n_16));
        songs.add(new Song("Living On My Own", "Freddie Mercury", R.drawable.n_17));
        songs.add(new Song("Space Oddity - 2015 Remastered Version", "David Bowie", R.drawable.n_18));
        songs.add(new Song("Sunday With A Flu", "Yodelice", R.drawable.n_19));
        songs.add(new Song("Mistakes I've Made - Radio Edit", "Eelke Kleijn", R.drawable.n_20));

        // Use SongAdapter.
        SongAdapter adapter = new SongAdapter(this, songs, R.color.category_songs);
        ListView listView = findViewById(R.id.song);
        if (listView != null) {
            listView.setAdapter(adapter);

            // Handle clicks on items in ListView.
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    // Start "playing" by change FAB icon.
                    fab.setImageDrawable(ContextCompat.getDrawable(context, android.R.drawable.ic_media_pause));
                    isPlaying = false;

                }
            });
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
