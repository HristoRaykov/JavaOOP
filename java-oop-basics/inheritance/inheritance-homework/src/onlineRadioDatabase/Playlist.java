package onlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songs;

    public Playlist() {
        this.songs = new ArrayList<>();
    }

    public void setSongs(Song song) {
        this.songs.add(song);
    }

    public int getSongsCount(){
        return songs.size();
    }

    public String calculateLength(){
        int sum = 0;

        for (Song song : songs) {
            String[] songArgs = song.getLength().split(":");
            int mins = Integer.parseInt(songArgs[0]);
            int seconds = Integer.parseInt(songArgs[1]);

            sum += mins * 60 + seconds;
        }

        int hours = sum / 60 / 60;
        int minutes = (sum / 60) - (hours * 60);
        int seconds = sum % 60;

        return String.format("Playlist length: %dh %dm %ds", hours, minutes, seconds);
    }
}
