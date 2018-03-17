package com.example.android.musicalstructureapp;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaylistAdapter extends ArrayAdapter<Song> {

    private int mColorResourceId;

    // Initialize the ArrayAdapter's internal storage.
    // Resource "0" because it's a custom adapter for more then one TextView.
    public PlaylistAdapter(Activity context, ArrayList<Song> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view.
        View playlistItemView = convertView;
        if (playlistItemView == null) {
            playlistItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.playlist_item, parent, false);
        }

        // Get the object located at this position in the list.
        Song currentSong = getItem(position);

        // Find in the playlist_item.xml the playlist title and set on the TextView.
        TextView playlistTextView = playlistItemView.findViewById(R.id.playlist_view_playlist_title);
        playlistTextView.setText(currentSong.getPlaylistTitle());

        // Find in the playlist_item.xml the number of songs and set on the TextView.
        TextView songsNumberTextView = playlistItemView.findViewById(R.id.playlist_view_number);
        songsNumberTextView.setText(currentSong.getSongsNumber());

        // Set the theme color for the list item.
        // Find the color from resource ID.
        // Set the background color of the text container.
        View textContainer = playlistItemView.findViewById(R.id.playlist_view_text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout.
        return playlistItemView;
    }
}