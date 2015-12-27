package LeetCode.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 19/12/15.
 */
public class TextJustification {

    public static void main(String[] args) {
        List<String> x = new TextJustification().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);

        for (String s : x) {
            System.out.println(s);
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int sIdx = 0;

        while (sIdx < words.length) {
            int tW = getMaxPossibleWords(words, sIdx, maxWidth);
            String y = getFinalString(words, sIdx, sIdx + tW - 1, maxWidth);
            ans.add(y);
            sIdx += tW;
        }

        return ans;
    }

    String getFinalString(String[] words, int sIdx, int eIdx, int maxW ) {
        StringBuilder bld = new StringBuilder();

        if (sIdx == eIdx) {
            bld.append(words[sIdx]);

            for (int i = 0; i < maxW - words[sIdx].length(); i++) {
                bld.append(" ");
            }

        } else if (eIdx == words.length - 1) {

            for (int i = sIdx; i <= eIdx; i++) {
                bld.append(words[i]);
                if (i < eIdx) {
                    bld.append(" ");
                }
            }

            int remainingLen = maxW - bld.length();

            for (int i = 0; i < remainingLen; i++) {
                bld.append(" ");
            }

        } else {
            int tLength = 0;

            for (int id = sIdx; id <= eIdx; id++) {
                tLength += words[id].length();
            }

            int[] space = getSpaces(eIdx - sIdx, maxW - tLength);
            int idx = 0;

            for (int i = sIdx; i <= eIdx; i++) {
                bld.append(words[i]);

                if (i < eIdx) {

                    for (int cnt = 1; cnt <= space[idx]; cnt++) {
                        bld.append(" ");
                    }

                    idx++;
                }
            }
        }
        return bld.toString();
    }

    public int[] getSpaces(int slots, int remainingSpace) {
        int[] space = new int[slots];
        int remainder = remainingSpace % slots;
        int val = remainingSpace / slots;

        for(int i = 0; i < slots; i++) {
            space[i] =  val;
        }

        for (int i = 0; i < remainder; i++) {
            space[i] += 1;
        }

        return space;
    }



    public int getMaxPossibleWords(String[] words, int sIdx, int maxWidth) {
        int tLen = 0;
        int saveIdx = sIdx;

        while (sIdx < words.length && (tLen + words[sIdx].length()) <= maxWidth) {
            tLen += words[sIdx].length();
            tLen++;
            sIdx++;
        }

        return sIdx - saveIdx;
    }
}
