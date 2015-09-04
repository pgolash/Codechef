package LeetCode.Strings;

/**
 * Created by prashantgolash on 9/4/15.
 */
public class ShortestPalindrome {

    public static void main(String[] args) {
        ShortestPalindrome sp = new ShortestPalindrome();
        System.out.println(sp.shortestPalindrome("aacecaaa"));
        System.out.println(sp.shortestPalindrome("abcd"));
    }



    public String shortestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return s;
        } else {

            int sIdx = 0;
            int eIdx = s.length() - 1;
            int saveIndex = -1;

            boolean isDone = false;
            StringBuilder bldr = new StringBuilder();

            while (!isDone) {
                saveIndex = eIdx;
                sIdx = 0;

                while (sIdx <= eIdx && s.charAt(sIdx) == s.charAt(eIdx)) {
                    sIdx++;
                    eIdx--;
                }

                if (sIdx >= eIdx) {
                    isDone = true;
                }

                eIdx = saveIndex - 1;
            }

            eIdx = s.length() - 1;

            while (eIdx > saveIndex) {
                bldr.append(s.charAt(eIdx));
                eIdx--;
            }

            bldr.append(s);

            return bldr.toString();
        }
    }
}
