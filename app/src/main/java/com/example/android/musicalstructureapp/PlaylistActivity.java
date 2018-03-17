package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    // Variables for saving state of the Player.
    private boolean isPlaying = true;
    private String nowPlayingStorage;

    @Override
    public void onSaveInstanceState(final Bundle bundle) {

        // Save state of the Player.
        TextView nowPlaying = findViewById(R.id.now_playing);
        String currentSong = nowPlaying.getText().toString();
        bundle.putString("nowPlaying", currentSong); // Song and artist name
        bundle.putBoolean("playButton", isPlaying); // State of the Play/Pause button
        super.onSaveInstanceState(bundle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Restore song and artist name in Player after screen rotation.
        if (savedInstanceState != null) {
            String currentSong = savedInstanceState.getString("nowPlaying");
            TextView nowPlaying = findViewById(R.id.now_playing);
            nowPlaying.setText(currentSong);
            // Restore state of Play/Pause Button after screen rotation.
            isPlaying = savedInstanceState.getBoolean("playButton");
            final FloatingActionButton fab = findViewById(R.id.fab);
            if (isPlaying) {
                fab.setImageDrawable(ContextCompat.getDrawable(PlaylistActivity.this, android.R.drawable.ic_media_play));
            } else {
                fab.setImageDrawable(ContextCompat.getDrawable(PlaylistActivity.this, android.R.drawable.ic_media_pause));
            }
        }

        // Scrolling Text (Marque) in Now Playing
        TextView marqueArtistName = this.findViewById(R.id.now_playing);
        marqueArtistName.setSelected(true);

        // Initialize floating action button.
        // Setup listener.
        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Play/Pause state logic.
                if (isPlaying) {
                    fab.setImageDrawable(ContextCompat.getDrawable(PlaylistActivity.this, android.R.drawable.ic_media_pause));
                    isPlaying = false;
                } else {
                    fab.setImageDrawable(ContextCompat.getDrawable(PlaylistActivity.this, android.R.drawable.ic_media_play));
                    isPlaying = true;
                }
            }
        });

        // Restore Player state after we come from other activities.
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // Receive state of Now Playing - info and button.
            String restoredNowPlaying = extras.getString("INFO");
            isPlaying = extras.getBoolean("BUTTON");
            // Restore Now Playing info
            TextView nowPlaying = findViewById(R.id.now_playing);
            nowPlaying.setText(restoredNowPlaying);
            // Restore state of Play button
            if (isPlaying) {
                fab.setImageDrawable(ContextCompat.getDrawable(PlaylistActivity.this, android.R.drawable.ic_media_play));
            } else {
                fab.setImageDrawable(ContextCompat.getDrawable(PlaylistActivity.this, android.R.drawable.ic_media_pause));
            }
        }

        // Create an ArrayList of songs.
        // Hardcode them. In real app they wouldn't be there anyway (SQLite, ext. source, etc.)
        // Song title and artist name here kinda a first song in the playlist. They begin "playing".
        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Ultimate 80s Hits", "25","When Doves Cry - Original Mix", "YNOT, Cosmo Klein"));
        songs.add(new Song("Classic", "13","Pop Corn - Remix Version 87 Special D'J", "M & H Band"));
        songs.add(new Song("Liked From Radio", "19","Dame", "Fly Project"));
        songs.add(new Song("Shazaam tracks", "55","Catch A Faya - Remaniax Radio Edit", "Dancehall Kings"));
        songs.add(new Song("Close Up", "16","Mainframe", "Alex"));
        songs.add(new Song("Teen party", "13","Katchi (Ofenbach vs. Nick Waterhouse)", "Ofenbach, Nick Waterhouse"));
        songs.add(new Song("Timeless Classis", "66","Brick England", "Jean-Michel Jarre, Pet Shop Boys"));
        songs.add(new Song("I Love Italia", "24","Prisencolinensinainciusol", "MINACELENTANO"));
        songs.add(new Song("Rap The Best", "1","'Till I Collapse", "Eminem, Nate Dogg"));
        songs.add(new Song("Workout Mix", "55","In the Army Now - Radio Mix", "Captain Jack"));
        songs.add(new Song("Misc", "198","Katarakta (feat. Mela Koteluk)", "Daniel Bloom, Mela Koteluk"));

        // Use SongAdapter.
        PlaylistAdapter adapter = new PlaylistAdapter(this, songs, R.color.category_playlists);
        ListView listView = findViewById(R.id.song);
        if (listView != null) {
            listView.setAdapter(adapter);

            // Handle clicks on items in ListView.
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    // Start "playing" by change FAB icon.
                    fab.setImageDrawable(ContextCompat.getDrawable(PlaylistActivity.this, android.R.drawable.ic_media_pause));
                    isPlaying = false;
                    // Get the Song object at the given position the user clicked on.
                    Song song = songs.get(position);
                    // Set song to Now Playing.
                    TextView nowPlaying = findViewById(R.id.now_playing);
                    nowPlaying.setText(song.toString());

                }
            });

            // Top menu
            // Find the View's that show the categories.
            TextView song_list = findViewById(R.id.song_list);
            TextView music_store = findViewById(R.id.music_store);

            //Songs list category listener
            // and container for transfer
            // Player state between activities.
            song_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Get info from the Player.
                    TextView nowPlaying = findViewById(R.id.now_playing);
                    nowPlayingStorage = nowPlaying.getText().toString();
                    // Initialize intent.
                    Intent songListIntent = new Intent(PlaylistActivity.this, SongListActivity.class);
                    // Transfer state of the Player between activities.
                    songListIntent.putExtra("INFO", nowPlayingStorage);
                    songListIntent.putExtra("BUTTON", isPlaying);
                    // Start intent.
                    startActivity(songListIntent);
                }
            });

            // Music store category listener
            // and container for transfer
            // Player state between activities.
            music_store.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Get info from the Player.
                    TextView nowPlaying = findViewById(R.id.now_playing);
                    nowPlayingStorage = nowPlaying.getText().toString();
                    // Initialize intent.
                    Intent musicStoreIntent = new Intent(PlaylistActivity.this, MusicStoreActivity.class);
                    // Transfer state of the Player between activities.
                    musicStoreIntent.putExtra("INFO", nowPlayingStorage);
                    musicStoreIntent.putExtra("BUTTON", isPlaying);
                    // Start intent.
                    startActivity(musicStoreIntent);
                }
            });
        }
    }
}


