package Design.Practice.MediaPlaylist;

import java.util.List;

/**
 * Created by prashantgolash on 21/02/16.
 */
public interface SelectionStrategy {
    public void order(List<Song> songs);
}
