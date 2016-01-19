package LeetCode.Arrays;

/**
 * Created by prashantgolash on 17/01/16.
 */
public class Read4 {
    public int read4(char[] buf) {
        return 4;
    }

    public int read(char[] buf, int n) {
        if(buf==null || n<=0) return 0;
        int i=0;
        char[] temp = new char[4];
        while(n>0) {
            int x = read4(temp);
            int j = 0;
            int k = x;
            while(n>0 && x > 0) {
                buf[i++] = temp[j++];
                --x;
                --n;
            }
            if(k<4) break;
        }
        return i;
    }
}
