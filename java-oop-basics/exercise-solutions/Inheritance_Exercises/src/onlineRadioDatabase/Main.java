package onlineRadioDatabase;

import onlineRadioDatabase.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Playlist playlist = new Playlist();

        String line = reader.readLine();
        while (n-- > 0){
            String[] input = line.split(";");
            String artist = input[0];
            String songName = input[1];
            String songLength = input[2];

            try {
                Song song = new Song(artist, songName, songLength);
                playlist.setSongs(song);
                System.out.println("Song added.");

            }catch (InvalidSongException ex){
                System.out.println(ex.getMessage());
            }
            line = reader.readLine();
        }

        System.out.println("Songs added: " + playlist.getSongsCount());
        System.out.println(playlist.calculateLength());
    }
}
