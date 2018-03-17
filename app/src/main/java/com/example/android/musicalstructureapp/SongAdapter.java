package com.example.android.musicalstructureapp;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    private int mColorResourceId;

    // Initialize the ArrayAdapter's internal storage.
    // Resource "0" because it's a custom adapter for more then one TextView.
    public SongAdapter(Activity context, ArrayList<Song> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list.
        Song currentSong = getItem(position);

        // Find in the list_item.xml the song title and set on the TextView.
        TextView songTextView = listItemView.findViewById(R.id.list_view_song_title);
        songTextView.setText(currentSong.getSongTitle());

        // Find in the list_item.xml the artist name and set on the TextView.
        TextView artistTextView = listItemView.findViewById(R.id.list_view_artist);
        artistTextView.setText(currentSong.getArtistName());

        // Find in the list_item.xml the song image and set on the ImageView.
        ImageView imageView = listItemView.findViewById(R.id.list_view_album_cover);
        imageView.setImageResource(currentSong.getSongImage());

        // Find in the list_item.xml the song price and set on the TextView.
        // Check whether or not there is song price field.
        // Change Play icon on €.
        TextView priceTagTextView = listItemView.findViewById(R.id.list_view_price_tag);
        TextView priceTextView = listItemView.findViewById(R.id.list_view_price);
        ImageView list_view_button = listItemView.findViewById(R.id.list_view_button);

        if (currentSong.hasPriceOfSong()) {
            list_view_button.setImageResource(R.drawable.ic_euro_symbol);
            priceTextView.setText(currentSong.getPriceOfSong());
            priceTextView.setVisibility(View.VISIBLE);
            priceTagTextView.setVisibility(View.VISIBLE);
        } else {
            priceTextView.setVisibility(View.GONE);
            priceTagTextView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item.
        // Find the color from resource ID.
        // Set the background color of the text container.
        View textContainer = listItemView.findViewById(R.id.list_view_text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout
        return listItemView;
    }
}