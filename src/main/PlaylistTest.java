package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlaylistTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();
        boolean run = true;
        int menuInput = 0;

        System.out.println("Welcome to your playlist.");

        try {

            while (run) {

                menu();
                menuInput = scanner.nextInt();

                switch (menuInput) {

                    case 1:
                        System.out.println("Select order of playlist to be displayed:");
                        System.out.println("Enter 1 to sort by DATE ADDED.");
                        System.out.println("Enter 2 to sort ALPHABETICALLY.");
                        int orderInput = scanner.nextInt();
                        if (orderInput == 1) {

                            System.out.println("Enter 1 to display list by date REGULARLY.");
                            System.out.println("Enter 2 to display list by date IN REVERSE.");

                            int orderInputDate = scanner.nextInt();

                            if (orderInputDate == 1) {

                                dataBase.printPlaylist();
                                break;
                            } else if (orderInputDate == 2) {

                                dataBase.printPlaylistReverse();
                                break;
                            } else {

                                System.out.println("Invalid input.\n");
                                break;
                            }
                        } else if (orderInput == 2) {

                            System.out.println("Enter 1 to display list alphabetically by SONG NAME.");
                            System.out.println("Enter 2 to display list alphabetically by ARTIST NAME.");
                            System.out.println("Enter 3 to display list alphabetically by ALBUM NAME.");

                            int orderInputAlph = scanner.nextInt();

                            if (orderInputAlph == 1) {


                                System.out.println("Enter 1 to display list alphabetically by song name REGULARLY.");
                                System.out.println("Enter 2 to display list alphabetically by song name IN REVERSE.");

                                int orderInputName = scanner.nextInt();

                                if (orderInputName == 1) {

                                    dataBase.printPlaylistByName();
                                    break;
                                } else if (orderInputName == 2) {

                                    dataBase.printPlaylistByNameReverse();
                                    break;
                                } else {

                                    System.out.println("Invalid input.\n");
                                    break;
                                }
                            } else
                            if (orderInputAlph == 2) {


                                System.out.println("Enter 1 to display list alphabetically by artist name REGULARLY.");
                                System.out.println("Enter 2 to display list alphabetically by artist name IN REVERSE.");

                                int orderInputArtist = scanner.nextInt();

                                if (orderInputArtist == 1) {

                                    dataBase.printPlaylistByArtist();
                                    break;
                                } else if (orderInputArtist == 2) {

                                    dataBase.printPlaylistByArtistReverse();
                                    break;
                                } else {

                                    System.out.println("Invalid input.\n");
                                    break;
                                }
                            } else if (orderInputAlph == 3) {


                                System.out.println("Enter 1 to display list alphabetically by album name REGULARLY.");
                                System.out.println("Enter 2 to display list alphabetically by album name IN REVERSE.");

                                int orderInput2 = scanner.nextInt();

                                if (orderInput2 == 1) {

                                    dataBase.printPlaylistByAlbum();
                                    break;
                                } else if (orderInput2 == 2) {

                                    dataBase.printPlaylistByAlbumReverse();
                                    break;
                                } else {

                                    System.out.println("Invalid input.\n");
                                    break;
                                }
                            }
                        }
                    case 2:
                        System.out.println("Enter song's NAME.");
                        scanner.nextLine();
                        String songNameAdd = scanner.nextLine();
                        System.out.println("Enter song's ARTIST NAME.");
                        String artistNameAdd = scanner.nextLine();
                        System.out.println("Enter song's ALBUM NAME.");
                        String albumNameAdd = scanner.nextLine();

                        Song newSongAdd = new Song(songNameAdd , artistNameAdd , albumNameAdd);
                        dataBase.add(newSongAdd);
                        break;
                    case 3:
                        System.out.println("Enter song's NAME.");
                        scanner.nextLine();
                        String songNameFind = scanner.nextLine();
                        System.out.println("Enter song's ARTIST NAME.");
                        String artistNameFind = scanner.nextLine();
                        System.out.println("Enter song's ALBUM NAME.");
                        String albumNameFind = scanner.nextLine();

                        Song newSongFind = new Song(songNameFind , artistNameFind , albumNameFind);
                        dataBase.find(newSongFind);

                        break;
                    case 4:

                        System.out.println("Enter song's NAME.");
                        scanner.nextLine();
                        String songNameDelete = scanner.nextLine();
                        System.out.println("Enter song's ARTIST NAME.");
                        String artistNameDelete = scanner.nextLine();
                        System.out.println("Enter song's ALBUM NAME.");
                        String albumNameDelete = scanner.nextLine();

                        Song newSongDelete = new Song(songNameDelete , artistNameDelete , albumNameDelete);

                        if (dataBase.delete(newSongDelete)) {

                            System.out.println("Are you sure you want to delete the following track: ");
                            System.out.println(dataBase.getSongToDelete());
                            System.out.println("Enter 1 for YES.");
                            System.out.println("Enter 2 for NO.");

                            int input = scanner.nextInt();

                            if (input == 1) {
                                dataBase.confirmDelete();
                                System.out.println("\nFollowing tracks were deleted: ");
                                System.out.println(dataBase.getSongToDelete());
                                System.out.println();
                                break;
                            } else if (input == 2) {

                                System.out.println("\nFollowing tracks were NOT deleted: ");
                                System.out.println(dataBase.getSongToDelete());
                                System.out.println();
                                break;
                            }
                        } else
                            break;
                    case 9:
                        run = false;
                        break;
                    default:
                        System.out.println("Invalid input.\n");
                        break;
                }
            }
        } catch (InputMismatchException e) {

            System.out.println("Invalid input.\n");
        }
    }

    public static void menu() {

        // introduction
        System.out.println();
        //options
        System.out.println("Options:");
        System.out.println("Enter 1 to DISPLAY playlist.");
        System.out.println("Enter 2 to ADD a song to playlist.");
        System.out.println("Enter 3 to FIND a song from playlist.");
        System.out.println("Enter 4 to DELETE a song from playlist.");
        System.out.println();
        System.out.println("Enter 9 to EXIT.");
    }
}
