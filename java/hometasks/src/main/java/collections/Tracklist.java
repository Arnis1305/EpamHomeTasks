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
        playlist.forEach(System.out::println);
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
        tracklistToCopy.forEach(System.out::println);
    }

    public void getTracksTotalDuration(ArrayList<Track> tracklist) {
        tracklist.forEach(track -> durationOfPlaylist += track.getTrackDuration());
        System.out.println("\nTracklist duration: " + durationOfPlaylist);
    }

    public void sortTracksByStyle(ArrayList<Track> tracklist) {
        tracklist.sort((o1, o2) -> o1.getTrackStyle().compareTo(o2.getTrackStyle()));
        System.out.println("\nYor tracklist sorted by genre: ");
        tracklist.forEach(System.out::println);
    }

    public void getTracksByRangeOfDuration (ArrayList<Track> tracklist) {
        System.out.println("\nPlease enter the tracks duration from A to B: ");
        System.out.println("Please enter A: " );
        double fromDuration = scanner.nextDouble();
        System.out.println("Please enter B: ");
        double toDuration = scanner.nextDouble();
        for (Track track : tracklist) {
            if (track.getTrackDuration() >= fromDuration && track.getTrackDuration() <= toDuration) {
                System.out.println(track);
            }
        }
    }
}