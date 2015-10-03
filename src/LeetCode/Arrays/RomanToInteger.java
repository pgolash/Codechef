package LeetCode.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashantgolash on 10/3/15.
 */
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MCMXCVI"));

    }

    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int prevVal = Integer.MAX_VALUE;
        int num = 0;

        for (char c : s.toCharArray()) {
            int val = m.get(c);
            num += val;
            if (val > prevVal) {
                num -= 2* prevVal;
                prevVal = Integer.MAX_VALUE;
            } else {
                prevVal = val;
            }
        }


        return num;

    }
}
