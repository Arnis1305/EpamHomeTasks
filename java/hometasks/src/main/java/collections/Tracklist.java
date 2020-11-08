package collections;

import collections.tracks.Track;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Tracklist {
    private double durationOfPlaylist = 0.0;
    Scanner scanner = new Scanner(System.in);

    public void getTracklist(ArrayList<Track> playlist) {
        System.out.println("Full track list: ");
        for (Track tracks : playlist) {
            System.out.println(tracks);
        }
    }

    public void copyElementsOfTracklist (ArrayList<Track> fullPlaylist, ArrayList<Track> tracklistToCopy) {
        System.out.println("\nEnter the amount of tracks you want to add to your tracklist: ");
        int arraySize = scanner.nextInt();
        System.out.println("Enter the ID of the tracks you want to add: ");
        for (int i = 0; i < arraySize; i++) {
            int trackId = scanner.nextInt();
            Track tracks = fullPlaylist.get(trackId);
            tracklistToCopy.add(tracks);
        }
        System.out.println("Your tracklist: ");
        for (Track tracks : tracklistToCopy) {
            System.out.println(tracks);
        }
    }

    public void getTracksTotalDuration(ArrayList<Track> tracklist) {
        for (int i = 0; i < tracklist.size() ; i++) {
            durationOfPlaylist += tracklist.get(i).getTrackDuration();
        }
        System.out.println("\nTracklist duration: " + durationOfPlaylist);
    }

    public void sortTracksByStyle(ArrayList<Track> tracklist) {
        Collections.sort(tracklist, new Comparator<Track>() {
            @Override
            public int compare(Track o1, Track o2) {
                return o1.getTrackStyle().compareTo(o2.getTrackStyle());
            }
        });
        System.out.println("\nYor tracklist sorted by genre: ");
        for (Track traks : tracklist) {
            System.out.println(traks);
        }
    }

    public void getTracksByRangeOfDuration (ArrayList<Track> tracklist) {
        System.out.println("\nPlease enter the tracks duration from A to B: ");
        System.out.println("Please enter A: " );
        Double fromDuration = scanner.nextDouble();
        System.out.println("Please enter B: ");
        Double toDuration = scanner.nextDouble();
        for (int i = 0; i < tracklist.size(); i++) {
            if (tracklist.get(i).getTrackDuration() >= fromDuration && tracklist.get(i).getTrackDuration() <= toDuration) {
                System.out.println(tracklist.get(i));
            }
        }
    }
}