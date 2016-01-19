package LeetCode.Strings;

/**
 * Created by prashantgolash on 12/01/16.
 */
public class RemoveDuplicatesCharacters {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesCharacters().removeDuplicateLetters("bcabc"));
    }

    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        } else {
            int[] count = new int[26];

            for (Character c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder bld = new StringBuilder(s);

            int sIdx = 0;

            while (sIdx < s.length()) {
                while (sIdx + 1 < s.length() && count[s.charAt(sIdx) - 'a'] > 1 && s.charAt(sIdx) > s.charAt(sIdx + 1)) {
                    count[s.charAt(sIdx) - 'a']--;
                    bld.setCharAt(sIdx,' ');
                    sIdx++;
                }

                if (sIdx == s.length() - 1 && count[s.charAt(sIdx) - 'a'] > 1) {
                    bld.setCharAt(sIdx, ' ');
                }

                sIdx++;
            }

            sIdx = 0;
            int eIdx = 0;

            while (eIdx < s.length()) {
                if (bld.charAt(eIdx) != ' ') {
                    bld.setCharAt(sIdx, bld.charAt(eIdx));
                    sIdx++;
                }
                eIdx++;
            }

            return bld.substring(0, sIdx);
        }
    }
}
