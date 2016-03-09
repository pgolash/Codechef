package Design.Practice.MediaPlaylist;

import java.util.List;

/**
 * Created by prashantgolash on 21/02/16.
 */
public class PlayList {
    private SelectionStrategy strategy;
    private List<Song> songs;

    public void setStrategy(SelectionStrategy strategy) {
        this.strategy = strategy;
    }

    public void playSong() {
        strategy.order(songs);

        for (Song s : songs) {
            s.play();
        }
    }
}
