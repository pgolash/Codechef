package LeetCode.Strings;

/**
 * Created by prashant on 8/25/2015.
 */
public class BinarySum {
    public String addBinary(String a, String b) {

        if (a == null && b == null) {
            return null;
        } else if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        } else {

            int aLen = a.length();
            int bLen = b.length();

            int aIndex = aLen - 1;
            int bIndex = bLen - 1;

            StringBuilder bld = new StringBuilder();
            int carry = 0;

            while (aIndex >= 0 && bIndex >= 0) {
                int aInt = a.charAt(aIndex) - 48;
                int bInt = b.charAt(bIndex) - 48;
                int sum = (aInt + bInt + carry);
                carry = sum / 2;
                sum = sum % 2;
                bld.append(sum);
                aIndex--;
                bIndex--;
            }

            while (aIndex >= 0) {
                int aInt = a.charAt(aIndex) - 48;
                int sum = (aInt + carry);
                carry = sum / 2;
                sum = sum % 2;
                bld.append(sum);
                aIndex--;
            }

            while (bIndex >= 0) {
                int bInt = b.charAt(bIndex) - 48;
                int sum = (bInt + carry);
                carry = sum / 2;
                sum = sum % 2;
                bld.append(sum);
                bIndex--;
            }


            if (carry != 0) {
                bld.append(carry);
            }

            int i = 0;
            int mid = bld.length() / 2 - 1;

            while (i <= mid) {
                char temp = bld.charAt(bld.length() - 1 - i);
                bld.setCharAt(bld.length() - 1 - i, bld.charAt(i));
                bld.setCharAt(i, temp);
                i++;
            }

            return bld.toString();
        }
    }

    public static void main(String[] args) {
        StringBuilder blf = new StringBuilder();
        blf.append(0);

        String a = "1";
        String b = "111";

        System.out.println(new BinarySum().addBinary(a, b));

        System.out.println(blf.toString());
    }
}
