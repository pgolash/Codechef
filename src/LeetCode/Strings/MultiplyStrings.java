package LeetCode.Strings;

/**
 * Created by prashantgolash on 23/01/16.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {

        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[num1.length() + num2.length()];

        //multiply each digit and sum at the corresponding positions
        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();

        //calculate each digit
        for (int i = 0; i < d.length; i++) {
            int mod = d[i] % 10;
            int carry = d[i] / 10;
            if (i + 1 < d.length) {
                d[i + 1] += carry;
            }
            sb.insert(0, mod);
        }

        //remove front 0's
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}

 public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }

        int sIdx = num2.length() - 1;
        int placeTenCnt = 0;
        int[] ans = null;

        while (sIdx >= 0) {
            int[] temp = multiply(num1, num2.charAt(sIdx) - '0', placeTenCnt);
            ans = add(ans, temp);
            sIdx--;
            placeTenCnt++;
        }

        return getString(ans);

    }

    public int[] multiply(String num1, int num2, int placeTenCnt) {
        int length = num1.length() + placeTenCnt + 1;
        int[] ans = new int[length];

        int sIdx = num1.length() - 1;
        int tempIdx = length - 1;
        int sum;
        int carry = 0;

        while (placeTenCnt > 0) {
            ans[tempIdx] = 0;
            tempIdx--;
            placeTenCnt--;
        }

        while (sIdx >= 0) {
            sum = (num1.charAt(sIdx) - '0') * num2 + carry;
            ans[tempIdx] = sum % 10;
            carry = sum / 10;
            sIdx--;
            tempIdx--;
        }

        if (carry >= 1) {
            ans[tempIdx] = carry;
            tempIdx--;
        }

        return Arrays.copyOfRange(ans, tempIdx + 1, ans.length);
    }

    public int[] add(int[] a, int []b) {
        if (a == null && b == null) {
            return null;
        } else if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        } else {
            int aIdx = a.length - 1;
            int bIdx = b.length - 1;
            int sum;
            int carry = 0;

            while (aIdx >= 0 || bIdx >= 0) {
                sum = 0;

                if (aIdx >= 0) {
                    sum += a[aIdx];
                }

                if (bIdx >= 0) {
                    sum += b[bIdx];
                }

                sum += carry;
                b[bIdx] = sum % 10;
                carry = sum / 10;
                aIdx--;
                bIdx--;
            }

            if (carry >= 1) {
                b = Arrays.copyOfRange(b, 0, b.length + 1);
                for (int x = b.length - 1; x >= 1; x--) {
                    b[x] = b[x - 1];
                }
                b[0] = carry;
            }

            return b;
        }
    }

    public String getString(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        } else {
            StringBuffer buf = new StringBuffer();
            int sIdx = 0;

            while (sIdx < num.length && num[sIdx] == 0) {
                sIdx++;
            }

            while (sIdx < num.length) {
                buf.append(num[sIdx]);
                sIdx++;
            }

            if (buf.length() == 0) {
                buf.append('0');
            }

            return buf.toString();

        }
    }
