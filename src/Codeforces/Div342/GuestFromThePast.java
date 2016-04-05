package Codeforces.Div342;

import java.util.Scanner;

/**
 * Created by prashantgolash on 13/03/16.
 */
public class GuestFromThePast {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long a = s.nextLong();
        long b = s.nextLong();
        long c = s.nextLong();
        long ans;

        if (a >= b) {
            if (n < b) {
                ans = 0;
            } else {
                ans = ((n - b) / (b - c)) + 1;
            }
        } else {
            if (b - c > a) {
                ans = n / a;
            } else {
                // two cases to consider here
                if (n < b) {
                    ans = n / a;
                } else {
                    ans = ((n - b) / (b - c)) + 1 + (n - ((n - b) / (b - c)) * (b - c) - b + c) / a;
                }
            }
        }
        System.out.println(ans);
    }
}