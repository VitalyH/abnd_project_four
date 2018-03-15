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
    // Resource "0" because it's a custom adapter for more the one TextView.
    public SongAdapter(Activity context, ArrayList<Song> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;

      //  TextView marqueSongTitle = this.findViewById(R.id.song_title);
       // TextView marqueArtist = this.findViewById(R.id.artist);
       // marqueSongTitle.setSelected(true);
       // marqueArtist.setSelected(true);
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
        TextView songTextView = listItemView.findViewById(R.id.song_title);
        songTextView.setText(currentSong.getSongTitle());
        // Scrolling Text (Marque)
        songTextView.setSelected(true);

        // Find in the list_item.xml the artist name and set on the TextView.
        TextView artistTextView = listItemView.findViewById(R.id.artist);
        artistTextView.setText(currentSong.getArtistName());
        // Scrolling Text (Marque)
        artistTextView.setSelected(true);

        // Find in the list_item.xml the song image and set on the ImageView.
        ImageView imageView = listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentSong.getSongImage());

        // Find in the list_item.xml the song price and set on the TextView.
        // Check whether or not there is song price field.
      //  TextView priceTextView = listItemView.findViewById(R.id.price);
       // if (currentSong.hasPriceOfSong()) {
       //     priceTextView.setText(currentSong.getPriceOfSong());
       //     priceTextView.setVisibility(View.VISIBLE);
       // } else {
       //     priceTextView.setVisibility(View.GONE);
       // }

        // Set the theme color for the list item.
        // Find the color from resource ID.
        // Set the background color of the text container.
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);



        // Return the whole list item layout
        return listItemView;
    }
}
