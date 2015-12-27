package LeetCode.Strings;

import java.util.*;

/**
 * Created by prashantgolash on 19/12/15.
 */
public class LetterCombinations {
    public static void main(String[] args) {
        List<String> x = new LetterCombinations().letterCombinations("278");
        System.out.println(x);
    }

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, String> m = new HashMap<>();

        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "jkl");
        m.put('6', "mno");
        m.put('7', "pqrs");
        m.put('8', "tuv");
        m.put('9', "wxyz");

        int totalCnt = 1;
        int[] count = new int[digits.length()];
        Arrays.fill(count, 0);

        for (int i = 0; i < digits.length(); i++) {
            totalCnt *= m.get(digits.charAt(i)).length();
        }

        int cnt = 1;
        List<String> ans = new ArrayList<>();
        while (cnt <= totalCnt) {
            ans.add(getString(m, digits, count));
            incrementCount(m, digits, count);
            cnt++;
        }

        return ans;
    }

    public String getString(Map<Character, String> m, String digits, int[] count) {
        StringBuilder bld = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            bld.append(m.get(digits.charAt(i)).charAt(count[i]));
        }
        return bld.toString();
    }

    public void incrementCount(Map<Character, String> m, String digits, int[] count) {
        boolean reset = true;
        for (int i = count.length - 1; i >= 0; i--) {
            if (reset) {
                count[i] = (count[i] + 1) % (m.get(digits.charAt(i)).length());
                if (!(count[i] == 0)) {
                    reset = false;
                }
            } else {
                break;
            }
        }
    }
}
