package collections.containers;

import collections.Tracklist;
import collections.models.MusicStyles;
import collections.tracks.Track;

import java.util.ArrayList;

public class MusicDisk {
    ArrayList<Track> fullTracklist = new ArrayList<>();
    ArrayList<Track> copiedTracklist = new ArrayList<>();
    Tracklist tracklist = new Tracklist();

    public MusicDisk() {
        fullTracklist.add(new Track(0, "Kanye West - Can't Tell Me Nothing", 4.31, MusicStyles.HIPHOP));
        fullTracklist.add(new Track(1, "AC/DC - Back In Black", 4.15, MusicStyles.ROCK));
        fullTracklist.add(new Track(2, "A$AP ROCKY - RAF", 4.14, MusicStyles.HIPHOP));
        fullTracklist.add(new Track(3, "AC/DC - Hells Bells", 5.12, MusicStyles.ROCK));
        fullTracklist.add(new Track(4, "Hans Zimmer - Time", 5.45, MusicStyles.CLASSIC));
        fullTracklist.add(new Track(5, "Billie Eilish - My Strange Addiction", 2.59, MusicStyles.POP));
        fullTracklist.add(new Track(6, "Billie Eilish - Xanny", 4.03, MusicStyles.POP));
        fullTracklist.add(new Track(7, "NF - When I Grow Up", 3.16, MusicStyles.HIPHOP));
        fullTracklist.add(new Track(8, "Philipp Glass - Escape", 3.51, MusicStyles.CLASSIC));

        tracklist.getTracklist(fullTracklist);
        tracklist.copyElementsOfTracklist(fullTracklist, copiedTracklist);
        tracklist.getTracksTotalDuration(copiedTracklist);
        tracklist.sortTracksByStyle(copiedTracklist);
        tracklist.getTracksByRangeOfDuration(copiedTracklist);
    }
}