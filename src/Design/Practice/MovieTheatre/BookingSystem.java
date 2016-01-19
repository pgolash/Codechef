package Design.Practice.MovieTheatre;

import Design.Synchronization.BlockingQueue;

import java.sql.Time;

/**
 * Created by prashantgolash on 13/01/16.
 */
public class BookingSystem {

    BlockingQueue<Request> bQ;

    public BookingSystem() {

    }

    public Booking bookTicket(Time t, Theatre th) {
        return new Booking(th, t);
    }

    public Booking startBookingSystem() {
        while (true) {
            Request b = bQ.consume();
            if (b.getMovie().getTheatre(b.getTime()).isAvailable()) {
                return bookTicket(b.getTime(), b.getMovie().getTheatre(b.getTime()));
            }
        }
    }

    class Request {
        private Time t;
        private Movie m;

        public Request() {


        }

        public Time getTime() {
            return t;
        }

        public Movie getMovie() {
            return m;
        }
    }
}
