package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashantgolash on 11/01/16.
 */
public class StringToWord {

    Map<Integer, String> hundreds = new HashMap<>();
    Map<Integer, String> vals = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new StringToWord().numberToWords(10000000));

    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        } else {
            hundreds.put(2, "Hundred");
            hundreds.put(3, "Thousand");
            hundreds.put(6, "Million");
            hundreds.put(9, "Billion");

            vals.put(1, "One");
            vals.put(2, "Two");
            vals.put(3, "Three");
            vals.put(4, "Four");
            vals.put(5, "Five");
            vals.put(6, "Six");
            vals.put(7, "Seven");
            vals.put(8, "Eight");
            vals.put(9, "Nine");

            vals.put(10, "Ten");
            vals.put(11, "Eleven");
            vals.put(12, "Twelve");
            vals.put(13, "Thirteen");
            vals.put(14, "Fourteen");
            vals.put(15, "Fifteen");
            vals.put(16, "Sixteen");
            vals.put(17, "Seventeen");
            vals.put(18, "Eighteen");
            vals.put(19, "Nineteen");

            vals.put(20, "Twenty");
            vals.put(30, "Thirty");
            vals.put(40, "Forty");
            vals.put(50, "Fifty");
            vals.put(60, "Sixty");
            vals.put(70, "Seventy");
            vals.put(80, "Eighty");
            vals.put(90, "Ninety");

            return numToWordsHelper(num);
        }
    }

    public String numToWordsHelper(int num) {
        if (num == 0) {
            return "";
        } else if (vals.containsKey(num)) {
            return vals.get(num);
        } else {
            int powTen = (int) Math.log10(num);

            if (powTen >= 9) {
                powTen = 9;
            } else if (powTen >= 3 && powTen <= 5) {
                powTen = 3;
            } else if (powTen >= 6 && powTen <= 8) {
                powTen = 6;
            }

            if (powTen == 1) {
                StringBuilder bld = new StringBuilder();
                bld.append(vals.get((num / 10) * 10));
                bld.append(" " + vals.get(num % 10));
                return bld.toString().trim();
            } else {
                StringBuilder bld = new StringBuilder();
                StringBuilder hund = new StringBuilder();

                hund.append(hundreds.get(powTen));

                int mulTen = (int) Math.pow(10, powTen);
                String recursiveAns = numToWordsHelper(num / mulTen);

                bld.append(" " + recursiveAns);
                bld.append(" " + hund);
                bld.append(" " + numToWordsHelper(num - ((num / mulTen) * mulTen)));

                return bld.toString().trim();
            }
        }
    }
}
