package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class DataBase {

    private LinkedList<Song> list;
    private int numSongs = 0;
    private RecordArray nameArray, artistArray, albumArray;
    private ArrayList<Song> nameMatch, artistMatch, albumMatch, songsToDelete;
    private Song songToDelete;

    public DataBase() {

        try {

            File infile = new File("playlist.txt");
            Scanner fileRead = new Scanner(infile);
            list = new LinkedList<>();

            while (fileRead.hasNextLine()) {

                String[] songsArr = (fileRead.nextLine()).split("\\\\");
                String name = songsArr[0];
                String artist = songsArr[1];
                String album = songsArr[2];

                Song song = new Song(name, artist, album);
                list.add(song);

                numSongs++;
            }

            reset();

            fileRead.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found.");
        }
    }

    public void reset() {

        nameArray = new RecordArray(list.size());
        artistArray = new RecordArray(list.size());
        albumArray = new RecordArray(list.size());

        for (int i = 0; i < list.size(); i++) {

            SongRecord songRecord1 = new SongRecord(list.get(i).getName(), i);
            SongRecord songRecord2 = new SongRecord(list.get(i).getArtist(), i);
            SongRecord songRecord3 = new SongRecord(list.get(i).getAlbum(), i);
            nameArray.insert(songRecord1);
            artistArray.insert(songRecord2);
            albumArray.insert(songRecord3);
        }
    }

    public int getNumSongs() {
        return numSongs;
    }

    public RecordArray getNameArray() {
        return nameArray;
    }

    public RecordArray getArtistArray() {
        return artistArray;
    }

    public RecordArray getAlbumArray() {
        return albumArray;
    }

    public LinkedList<Song> getList() {
        return list;
    }

    public ArrayList<Song> getNameMatch() {
        return nameMatch;
    }

    public ArrayList<Song> getArtistMatch() {
        return artistMatch;
    }

    public ArrayList<Song> getAlbumMatch() {
        return albumMatch;
    }

    public Song getSongToDelete() {
        return songToDelete;
    }

    public void printPlaylist() {

        for (Song i : list)
            System.out.println(i.toString());
    }

    public void printPlaylistReverse() {

        for (int i = list.size() - 1; i >= 0; i--)
            System.out.println(list.get(i).toString());
    }

    public void printPlaylistByName() {

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(nameArray.getRec(i).getLocation()));
    }

    public void printPlaylistByArtist() {

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(artistArray.getRec(i).getLocation()));
    }

    public void printPlaylistByAlbum() {

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(albumArray.getRec(i).getLocation()));
    }

    public void printPlaylistByNameReverse() {

        for (int i = list.size() - 1; i >= 0; i--)
            System.out.println(list.get(nameArray.getRec(i).getLocation()));
    }

    public void printPlaylistByArtistReverse() {

        for (int i = list.size() - 1; i >= 0; i--)
            System.out.println(list.get(artistArray.getRec(i).getLocation()));
    }

    public void printPlaylistByAlbumReverse() {

        for (int i = list.size() - 1; i >= 0; i--)
            System.out.println(list.get(albumArray.getRec(i).getLocation()));
    }

    public void add(Song newSong) {

        list.add(newSong);
        reset();

        System.out.println("The following track: ");
        System.out.println(newSong.toString());
        System.out.println("has been added to your playlist.");
    }

    public void find(Song newSong) {

        nameMatch = new ArrayList<>();
        artistMatch = new ArrayList<>();
        albumMatch = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            if (newSong.getName().compareToIgnoreCase(list.get(i).getName()) == 0)
                nameMatch.add(list.get(i));

            if (newSong.getArtist().compareToIgnoreCase(list.get(i).getArtist()) == 0)
                artistMatch.add(list.get(i));

            if (newSong.getAlbum().compareToIgnoreCase(list.get(i).getAlbum()) == 0)
                albumMatch.add(list.get(i));
        }

        if (!nameMatch.isEmpty()) {

            System.out.println("\nThe following songs have the name \"" + newSong.getName() + "\"\n");
            for (Song song : nameMatch)
                System.out.println(song.toString());
        }

        if (!artistMatch.isEmpty()) {

            System.out.println("\nThe following songs have the artist name \"" + newSong.getArtist() + "\"\n");
            for (Song song : artistMatch)
                System.out.println(song.toString());
        }

        if (!albumMatch.isEmpty()) {

            System.out.println("\nThe following songs are in the album \"" + newSong.getAlbum() + "\"\n");
            for (Song song : albumMatch)
                System.out.println(song.toString());
        }

        if (nameMatch.isEmpty() && artistMatch.isEmpty() && albumMatch.isEmpty()) {

            System.out.println("\nNo song matched the following criteria: ");
            System.out.println(newSong.toString());
            System.out.println();
        }
    }

    public boolean delete(Song newSong) {

        boolean retValue = false;

        for (Song song : list) {

            if (newSong.getName().compareToIgnoreCase(song.getName()) == 0 &&
                    newSong.getArtist().compareToIgnoreCase(song.getArtist()) == 0 &&
                    newSong.getAlbum().compareToIgnoreCase(song.getAlbum()) == 0) {

                songToDelete = song;
                retValue = true;
            }
        }

        if (!retValue) {

            System.out.println("\nNo song matched the following criteria: ");
            System.out.println(newSong.toString());
            System.out.println();
        }

        return retValue;


//        songsToDelete = new ArrayList<>();
//
//        find(newSong);
//
//        if (nameMatch.isEmpty() && albumMatch.isEmpty() && artistMatch.isEmpty())
//            return;
//        else {
//
//            if (!nameMatch.isEmpty())
//                songsToDelete.addAll(nameMatch);
//
//            if (!artistMatch.isEmpty()) {
//
//                for (int x = 0 ; x < songsToDelete.size() ; x++) {
//
//                    for (int i = 0 ; i < artistMatch.size() ; i++) {
//
//                        if (!songsToDelete.get(x).equals(artistMatch.get(i)))
//                            songsToDelete.add(artistMatch.get(i));
//                    }
//                }
//            }
//
//            if (!artistMatch.isEmpty()) {
//
//                for (int x = 0 ; x < songsToDelete.size() ; x++) {
//
//                    for (int i = 0 ; i < albumMatch.size() ; i++) {
//
//                        if (!songsToDelete.get(x).equals(albumMatch.get(i)))
//                            songsToDelete.add(albumMatch.get(i));
//                    }
//                }
//            }
//
//            System.out.println("\nWould you like to delete any of these songs?\n");

                /* commented-out code caused an OutOfMemoryError*/
    }

    public void confirmDelete() {

        for (Song song : list) {

            if (songToDelete.getName().compareToIgnoreCase(song.getName()) == 0 &&
                    songToDelete.getArtist().compareToIgnoreCase(song.getArtist()) == 0 &&
                    songToDelete.getAlbum().compareToIgnoreCase(song.getAlbum()) == 0) {

                list.remove(song);
            }
        }

        reset();
    }
}

