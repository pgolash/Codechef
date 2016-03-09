package Design.Practice.MediaPlaylist;

/**
 * Created by prashantgolash on 21/02/16.
 */
public class Song {
    private Artist associatedArtist;
    private String title;

    public Artist getAssociatedArtist() {
        return associatedArtist;
    }

    public void setAssociatedArtist(Artist associatedArtist) {
        this.associatedArtist = associatedArtist;
    }

    private double popularityIndex;

    public double getPopularityIndex() {
        return popularityIndex;
    }

    public void setPopularityIndex(double popularityIndex) {
        this.popularityIndex = popularityIndex;
    }

    public void play() {
        System.out.println("playing song" + this.toString());
    }
}
