package LeetCode.Arrays;

/**
 * Created by prashantgolash on 24/01/16.
 */
public class AdditiveNumber {

    public static void main(String[] args) {
        System.out.println(new AdditiveNumber().isAdditiveNumber("199100199"));
    }

    public  boolean  isAdditiveNumber (String num) {
        // Position of the two numbers before enumeration, because the first two numbers determine whether num Additive
        for ( int  i =  0 ; i < num.length (); i ++) {
            String first = num.substring(0 , i +  1 );
            for ( int  j = i + 1 ; j < num.length () - i -  1 ; j ++) {
                String second = num.substring (i +  1 , j +  1 );
                if (valid(j + 1, num, first, second)) {
                    return true;
                }
            }
        }
        return  false ;
    }

    private  boolean  valid (int  start, String num, String first, String second) {
        if (start == num.length()) {
            return true;
        }

        long  f = Long.parseLong (first);
        long  s = Long.parseLong (second);

        if ((!Long.toString(f).equals (first)) || (!Long.toString(s).equals (second))) {
            return false;
        }

        long  sum = f + s;
        String sumS = Long.toString (sum);
        if (start + sumS.length () > num.length()) {
            return false;
        }

        String third = num.substring (start, start + sumS.length());
        long  t = Long.parseLong (third);
        if ((!Long.toString(t).equals(third)) || t != sum) {
            return false;
        }
        return  valid (start + sumS.length(), num, second, third);
    }
}
