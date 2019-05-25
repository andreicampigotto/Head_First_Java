package usecabeca27;

import java.util.*;
import java.io.*;

public class Jukebox6 {
    ArrayList<Song> songList = new ArrayList<Song>();
    public static void main(String[] args) {
        new Jukebox6().go();
    }
    public void go(){
        getSongs();
        
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
        HashSet <Song> songSet = new HashSet<Song>();
        songSet.addAll(songList);
        System.out.println(songSet);
    }
    
    void getSongs(){
        
    }
    
    void addSong(String lineToParse){
        
    }
}
