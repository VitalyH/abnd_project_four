package com.example.android.musicalstructureapp;

/**
 * Song contains information about songs.
 */

public class Song {

    /**
     * Song title.
     */
    private String mSongTitle;

    /**
     * Artist Name.
     */
    private String mArtistName;

    /**
     * Image of song.
     */
    private int mSongImage;

    /**
     * Price of song.
     */
    private String mPriceOfSong = NO_PRICE_PROVIDED;

    /**
     * Price field check.
     */
    private static final String NO_PRICE_PROVIDED = "null";

    /**
     * Create a new Song object for Song List activity.
     *
     * @param songTitle  is the title of the song.
     * @param artistName is the name of the artist.
     * @param songImage  is the image of the album.
     */
    public Song(String songTitle, String artistName, int songImage) {
        mSongTitle = songTitle;
        mArtistName = artistName;
        mSongImage = songImage;
    }

    /**
     * Create a new Song object for Music Store activity.
     *
     * @param priceOfSong is the price of the song.
     * @param songTitle   is the title of the song.
     * @param artistName  is the name of the artist.
     * @param songImage   is the image of the album.
     */

    public Song(String songTitle, String artistName, String priceOfSong, int songImage) {
        mSongTitle = songTitle;
        mArtistName = artistName;
        mPriceOfSong = priceOfSong;
        mSongImage = songImage;
    }

    /**
     * Get the song title.
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Get the artist name.
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the album image.
     */

    public int getSongImage() {
        return mSongImage;
    }

    /**
     * Get the song price.
     */

    public String getPriceOfSong() {
        return mPriceOfSong;
    }

    /**
     * Returns whether or not there is song price field.
     */
    public boolean hasPriceOfSong() {
        //return mPriceOfSong != NO_PRICE_PROVIDED;
        return !mPriceOfSong.equals(NO_PRICE_PROVIDED);
    }

    @Override
    public String toString() {
        return mSongTitle + " — " + mArtistName;
    }
}