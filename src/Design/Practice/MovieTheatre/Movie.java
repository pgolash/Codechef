package Design.Practice.MovieTheatre;

import java.sql.Time;
import java.util.Map;

/**
 * Created by prashantgolash on 13/01/16.
 */
public class Movie {
    private Map<Time, Theatre> tList;

    public Movie() {

    }

    public Theatre getTheatre(Time t) {
        return tList.get(t);
    }
}
