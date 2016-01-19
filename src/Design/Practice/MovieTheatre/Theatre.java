package Design.Practice.MovieTheatre;

import java.sql.Time;
import java.util.Map;

/**
 * Created by prashantgolash on 13/01/16.
 */
public class Theatre {
    private int capacity;
    private int occupiedCapacity;
    private Map<Time, Movie> movieMap;

    public Theatre(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return occupiedCapacity < capacity;
    }

    public Movie getMovie(Time t) {
        return null;
    }
}
