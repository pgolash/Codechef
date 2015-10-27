package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 10/25/15.
 */
public class IntegerToRoman {
    public static void main(String[] args) {

    }

    public String intToRoman(int num) {
        char[] powTen = {'M','C','X','I'};
        char[] powFive = {'D','L','V'};
        List<String> x = new ArrayList<>();

        int cnt = 0;

        while (num != 0) {
            int digit = num % 10;
            StringBuilder bld = new StringBuilder();

            switch(digit) {
                case 1:
                case 2:
                case 3:
                    char c = powTen[powTen.length - cnt - 1];
                    for (int i = 1; i <= digit; i++) {
                        bld.append(c);
                    }
                    x.add(bld.toString());
                    break;
                case 4:
                    char c1 = powTen[powTen.length - cnt - 1];
                    char c2 = powFive[powFive.length - cnt - 1];
                    bld.append(c1);
                    bld.append(c2);
                    x.add(bld.toString());
                    break;
                case 5:
                    char c3 = powFive[powFive.length - cnt - 1];
                    bld.append(c3);
                    x.add(bld.toString());
                    break;
                case 6:
                case 7:
                case 8:
                    char c4 = powFive[powFive.length - cnt - 1];
                    char c5 = powTen[powTen.length - cnt - 1];
                    bld.append(c4);
                    for (int i = 1; i <= (digit - 5); i++) {
                        bld.append(c5);
                    }
                    x.add(bld.toString());
                    break;
                case 9:
                    char c6 = powTen[powTen.length - cnt - 1];
                    char c7 = powTen[powTen.length - cnt - 2];
                    bld.append(c6);
                    bld.append(c7);
                    x.add(bld.toString());
            }
            num /= 10;
            cnt++;
        }

        int middle = x.size() / 2;
        for (int idx = 0; idx <= middle - 1; idx++) {
            String temp = x.get(idx);
            x.set(idx, x.get(x.size() - 1 - idx));
            x.set(x.size() - 1 - idx, temp);
        }

        StringBuilder b = new StringBuilder();
        for (String s : x) {
            b.append(s);
        }

        return b.toString();
    }
}
