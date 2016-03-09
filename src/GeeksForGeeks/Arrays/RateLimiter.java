package GeeksForGeeks.Arrays;

/**
 * Created by prashantgolash on 27/01/16.
 */
public class RateLimiter {
    //rate = 5.0;
    // unit: messages per = 8.0;
    // unit: seconds allowance = rate;
    // unit: messages last_check = now();
    // floating-point, e.g. usec accuracy. Unit: seconds when (message_received):
    // current = now();
    // time_passed = current - last_check;
    // last_check = current;
    // allowance += time_passed * (rate / per);
    // if (allowance > rate):
    //  allowance = rate;
    // throttle if (allowance < 1.0):
    // discard_message();
    // else: forward_message();
    // allowance -= 1.0;
}
