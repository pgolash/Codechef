package GeeksForGeeks.String;

/**
 * Created by prashantgolash on 12/01/16.
 */
public class ExcelStringToInteger {

    public static void main(String[] args) {
        ExcelStringToInteger ex = new ExcelStringToInteger();
        System.out.println(ex.getInteger("AA"));
        System.out.println(ex.getInteger("AAA"));
        System.out.println(ex.getString(25));
        System.out.println(ex.getString(26));
        System.out.println(ex.getString(52));
    }

    public Integer getInteger(String num) {
        int i = num.length() - 1;
        int x = 0;
        char c = num.charAt(i);
        x = (c - 'A');
        int mul = 26;
        i--;

        while (i >= 0) {
            c = num.charAt(i);
            x += mul * (c - 'A' + 1);
            mul *= 26;
            i--;
        }
        return x;
    }

    public String getString(Integer num) {
        StringBuilder bld = new StringBuilder("");
        while (num >= 0) {
            char d = (char) ('A' + num % 26);
            StringBuilder bld1 = new StringBuilder(d + "" + bld);
            bld = bld1;
            num = num / 26 - 1;
        }
        return bld.toString();
    }
}