package Design.Practice.Elevator;

import Design.Practice.Queue.Queue;

/**
 * Created by prashantgolash on 30/01/16.
 */
public class ElevatorController {
    private Queue<GenericRequest> requestQueue;
    private Cabin cabin;

    //

    public void queueRequest(GenericRequest request) {
        requestQueue.add(request);
    }

    public void serveRequest() {

    }

    public void start() {
        while (true) {

        }
    }

}
