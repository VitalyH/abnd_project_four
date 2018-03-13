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
     * Title of album.
     */
    private String mAlbumTitle;

    /**
     * Price of song.
     */
    private int mPriceOfSong;

    /**
     * Price field check.
     */
    private static final int NO_PRICE_PROVIDED = -1;

    /**
     * Create a new Song object for Song List activity.
     *
     * @param songTitle  is the title of the song.
     * @param artistName is the name of the artist.
     * @param albumTitle is the title of the album.
     */
    public Song(String songTitle, String artistName, String albumTitle) {
        mSongTitle = songTitle;
        mArtistName = artistName;
        mAlbumTitle = albumTitle;
    }

    /**
     * Create a new Song object for Music Store activity.
     *
     * @param priceOfSong is the price of the song.
     * @param songTitle  is the title of the song.
     * @param artistName is the name of the artist.
     * @param albumTitle is the title of the album.
     */

    public Song(int priceOfSong, String songTitle, String artistName, String albumTitle) {
        mPriceOfSong = priceOfSong;
        mSongTitle = songTitle;
        mArtistName = artistName;
        mAlbumTitle = albumTitle;
            }

    /**
     * Get the song title.
     */
    public String getmSongTitle() {
        return mSongTitle;
    }

    /**
     * Get the artist name.
     */
    public String getmArtistName() {
        return mArtistName;
    }

    /**
     * Get the album title.
     */

    public String getmAlbumTitle() {
        return mAlbumTitle;
    }

    /**
     * Get the song price.
     */

    public int getPriceOfSong() {
        return mPriceOfSong;
    }

    /**
     * Returns whether or not there is song price field.
     */
    public boolean hasPriceOfSong() {
        return mPriceOfSong != NO_PRICE_PROVIDED;
    }
}