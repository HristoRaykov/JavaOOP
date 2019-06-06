package onlineRadioDatabase;

import onlineRadioDatabase.exceptions.*;

public class Song {
    private String artistName;
    private String songName;
    private String length;

    public Song(String artistName, String songName, String length) throws InvalidArtistNameException, InvalidSongNameException, InvalidSongLengthException {
       this.setArtistName(artistName);
       this.setSongName(songName);
       this.setLength(length);
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) throws InvalidArtistNameException {
        if(artistName.length() > 3 && artistName.length() < 20) {
            this.artistName = artistName;
        }else {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) throws InvalidSongNameException {
        if(songName.length() > 3 && songName.length() < 20) {
            this.songName = songName;
        }else {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) throws InvalidSongLengthException {
        int seconds;
        int minutes;
        try {
             seconds = Integer.parseInt(length.split(":")[1]);
             minutes = Integer.parseInt(length.split(":")[0]);
        }catch (Exception ex){
            throw new InvalidSongLengthException("Invalid song length.");
        }

        if(minutes < 0 || minutes > 14){
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        if(seconds < 0 || seconds > 59){
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.length = length;
    }
}
