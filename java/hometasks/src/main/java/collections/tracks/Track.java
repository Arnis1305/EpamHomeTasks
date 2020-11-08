package collections.tracks;

import collections.models.MusicStyles;

public class Track {
    private long trackId;
    private String trackName;
    private double trackDuration;
    private MusicStyles trackStyle;

    public Track(long trackId, String trackName, double trackDuration, MusicStyles trackStyle) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackDuration = trackDuration;
        this.trackStyle = trackStyle;
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public double getTrackDuration() {
        return trackDuration;
    }

    public void setTrackDuration(float trackDuration) {
        this.trackDuration = trackDuration;
    }

    public MusicStyles getTrackStyle() {
        return trackStyle;
    }

    public void setTrackStyle(MusicStyles trackStyle) {
        this.trackStyle = trackStyle;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", trackDuration=" + trackDuration +
                ", trackStyle=" + trackStyle +
                '}';
    }
}