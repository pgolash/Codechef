package Design.Practice.MovieTheatre;

import java.sql.Time;

/**
 * Created by prashantgolash on 14/01/16.
 */
public class Booking {
    private Theatre th;
    private Time t;

    public Booking(Theatre th, Time t) {
        this.th = th;
        this.t = t;
    }

    public Booking() {

    }

}
