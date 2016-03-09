package LeetCode.Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by prashantgolash on 12/01/16.
 */
public class RemoveDuplicatesCharacters {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesCharacters().removeDuplicateLetters("bcabc"));
    }

    public String removeDuplicateLetters(String s) {

        Set foundSet = new HashSet<Character>();

        for (char ch : s.toCharArray())

            foundSet.add(ch);

        return helper(foundSet, new StringBuffer(s));

    }

    private String helper(Set foundSet, StringBuffer buf) {

        if (buf.length() == 0)
            return "";

        Set set = new HashSet<Character>();

        int i = buf.length() - 1;

        for (; i >= 0; i--) {
            set.add(buf.charAt(i));
            if (set.size() == foundSet.size())
                break;
        }

        // find the min char from 0 to i; inclusive

        char ch = buf.charAt(0);
        int index = 0;
        for (int j = 1; j <= i; j++)
            if (buf.charAt(j) < ch) {
                ch = buf.charAt(j);
                index = j;
            }

        // delete from foundSet
        foundSet.remove(ch);
        // delete all characters before j

        buf.delete(0, index + 1);
        while (buf.indexOf("" + ch) >= 0) {
            buf.deleteCharAt(buf.indexOf("" + ch));

        }

        return "" + ch + helper(foundSet, buf);
    }
}