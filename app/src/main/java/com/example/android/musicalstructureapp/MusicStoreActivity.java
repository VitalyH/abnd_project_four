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
import android.widget.Toast;

import java.util.ArrayList;

public class MusicStoreActivity extends AppCompatActivity implements View.OnClickListener {

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
                fab.setImageDrawable(ContextCompat.getDrawable(MusicStoreActivity.this, android.R.drawable.ic_media_play));
            } else {
                fab.setImageDrawable(ContextCompat.getDrawable(MusicStoreActivity.this, android.R.drawable.ic_media_pause));
            }
        }

        // Find "buttons" and set heir onClickListener to "this".
        TextView song_list = findViewById(R.id.song_list);
        song_list.setOnClickListener(this);
        TextView playlist = findViewById(R.id.playlists);
        playlist.setOnClickListener(this);

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
                    fab.setImageDrawable(ContextCompat.getDrawable(MusicStoreActivity.this, android.R.drawable.ic_media_pause));
                    isPlaying = false;
                } else {
                    fab.setImageDrawable(ContextCompat.getDrawable(MusicStoreActivity.this, android.R.drawable.ic_media_play));
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
                fab.setImageDrawable(ContextCompat.getDrawable(MusicStoreActivity.this, android.R.drawable.ic_media_play));
            } else {
                fab.setImageDrawable(ContextCompat.getDrawable(MusicStoreActivity.this, android.R.drawable.ic_media_pause));
            }
        }

        // Create an ArrayList of songs.
        // Hardcode them. In real app they wouldn't be there anyway (SQLite, ext. source, etc.)
        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Mistakes I've Made - Radio Edit", "Eelke Kleijn", "1.21", R.drawable.n_20));
        songs.add(new Song("Sunday With A Flu", "Yodelice", "0.99", R.drawable.n_19));
        songs.add(new Song("Space Oddity - 2015 Remastered Version", "David Bowie", "FREE", R.drawable.n_18));
        songs.add(new Song("Living On My Own", "Freddie Mercury", "1.11", R.drawable.n_17));
        songs.add(new Song("Mombasa", "2Cellos", "0.75", R.drawable.n_16));
        songs.add(new Song("Moscow Calling", "Gorkiy Park", "9.99", R.drawable.n_15));
        songs.add(new Song("Extreme Ways (Jason Bourne)", "Moby", "1.21", R.drawable.n_14));
        songs.add(new Song("Judas", "Lady Gaga", "6.66", R.drawable.n_13));
        songs.add(new Song("Slice Me Nice - Deep Hammer Remix", "Fancy, Adam van Hammer", "1.49", R.drawable.n_12));
        songs.add(new Song("Katarakta (feat. Mela Koteluk)", "Daniel Bloom, Mela Koteluk", "1.21", R.drawable.n_11));
        songs.add(new Song("In the Army Now - Radio Mix", "Captain Jack", "2.21", R.drawable.n_10));
        songs.add(new Song("'Till I Collapse", "Eminem, Nate Dogg", "0.01", R.drawable.n_9));
        songs.add(new Song("Prisencolinensinainciusol", "MINACELENTANO", "FREE", R.drawable.n_8));
        songs.add(new Song("Brick England", "Jean-Michel Jarre, Pet Shop Boys", "5.41", R.drawable.n_7));
        songs.add(new Song("Katchi (Ofenbach vs. Nick Waterhouse)", "Ofenbach, Nick Waterhouse", "1.21", R.drawable.n_6));
        songs.add(new Song("Mainframe", "Alex", "2.21", R.drawable.n_5));
        songs.add(new Song("Catch A Faya - Remaniax Radio Edit", "Dancehall Kings", "0.97", R.drawable.n_4));
        songs.add(new Song("Dame", "Fly Project", "1.21", R.drawable.n_3));
        songs.add(new Song("Pop Corn - Remix Version 87 Special D'J", "M & H Band", "2.21", R.drawable.n_2));
        songs.add(new Song("When Doves Cry - Original Mix", "YNOT, Cosmo Klein", "0.50", R.drawable.n_1));

        // Use SongAdapter.
        SongAdapter adapter = new SongAdapter(this, songs, R.color.category_store);
        ListView listView = findViewById(R.id.song);
        if (listView != null) {
            listView.setAdapter(adapter);

            // Handle clicks on items in ListView.
            // Just show Toast for now.
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Toast.makeText(MusicStoreActivity.this, "Opening external Music Store...", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    // Top Menu
    @Override
    public void onClick(View view) {
        // Get info from the Player for saving between activities.
        TextView nowPlaying = findViewById(R.id.now_playing);
        nowPlayingStorage = nowPlaying.getText().toString();
        // Switch for top menu "buttons".
        switch (view.getId()) {
            case R.id.song_list:
                // Initialize intent.
                Intent songListIntent = new Intent(MusicStoreActivity.this, SongListActivity.class);
                // Transfer state of the Player between activities.
                songListIntent.putExtra("INFO", nowPlayingStorage);
                songListIntent.putExtra("BUTTON", isPlaying);
                // Start intent.
                startActivity(songListIntent);
                break;
            case R.id.playlists:
                Intent playlistIntent = new Intent(MusicStoreActivity.this, PlaylistActivity.class);
                playlistIntent.putExtra("INFO", nowPlayingStorage);
                playlistIntent.putExtra("BUTTON", isPlaying);
                startActivity(playlistIntent);
                break;
        }
    }
}