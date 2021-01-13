package main;

public class Song {

    private String name;
    private String artist;
    private String album;
    private Song prevSong;
    private Song nextSong;

    public Song(String name, String artist, String album) {
        this.name = name;
        this.artist = artist;
        this.album = album;

    }

    public String toString() {

        return name + " | " + artist + " | " + album;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public Song getPrevSong() {
        return prevSong;
    }

    public Song getNextSong() {
        return nextSong;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public void setPrevSong(Song prevSong) {
        this.prevSong = prevSong;
    }
}
