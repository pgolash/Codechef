package LeetCode.Arrays;

/**
 * Created by prashantgolash on 26/01/16.
 */
public class Read4II {
    private char[] buffer = new char[4];
    int offset = 0, bufsize = 0;
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int readBytes = 0;
        boolean eof = false;
        while (!eof && readBytes < n) {
            int sz = (bufsize > 0) ? bufsize : read4(buffer);
            if (bufsize == 0 && sz < 4) eof = true;
            int bytes = Math.min(n - readBytes, sz);
            System.arraycopy(buffer /* src */, offset /* srcPos */, buf /* dest */,
                    readBytes /* destPos */, bytes /* length */);
            offset = (offset + bytes) % 4;
            bufsize = sz - bytes;
            readBytes += bytes;
        }
        return readBytes;
    }

    public int read4(char[] buf) {
        return 1;
    }
}
