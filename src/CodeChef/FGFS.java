package CodeChef; /**
 * Created by prashantgolash on 6/9/15.
 */
import java.util.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

class FGFS
{
    private static int si[],fi[],pi[];
    public static int length;

    public static void main(String[] args)
            throws Exception
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);

        StringBuilder res = new StringBuilder();

        int Z = in.nextInt();

        while(Z-->0)
        {
            int N = in.nextInt();
            int K = in.nextInt();

            si=new int[N];
            fi=new int[N];
            pi=new int[N];

            for(int i=0;i<N;i++)
            {
                si[i] = in.nextInt();
                fi[i] = in.nextInt();
                pi[i] = in.nextInt();
            }

            sort();

            HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
            int count=0;

            for(int i=0;i<N;i++)
            {
                if(hm.containsKey(pi[i]))
                {
                    int max=hm.get(pi[i]);
                    if(si[i]>=max)
                    {
                        hm.remove(pi[i]);
                        hm.put(pi[i],fi[i]);
                        count++;
                    }
                }
                else
                {
                    hm.put(pi[i],fi[i]);
                    count++;
                }
            }
            res.append(count+"\n");
        }

        System.out.print(res);
    }


    public static void sort() {

        if (fi.length == 0) {
            return;
        }
        length = fi.length;
        quickSort(0, length - 1);
    }

    private static void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        int pivot = fi[lowerIndex+(higherIndex-lowerIndex)/2];
        while (i <= j) {

            while (fi[i] < pivot) {
                i++;
            }
            while (fi[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }

    private static void exchangeNumbers(int i, int j) {
        int temp1 = fi[i];
        fi[i] = fi[j];
        fi[j] = temp1;

        temp1 = si[i];
        si[i] = si[j];
        si[j] = temp1;

        temp1 = pi[i];
        pi[i] = pi[j];
        pi[j] = temp1;

    }



}


class FastReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public FastReader(InputStream stream) {
        this.stream = stream;
    }

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return isWhitespace(c);
    }

    public String next() {
        return readString();
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }

    public Long readLong() {
        return Long.parseLong(readString());
    }

    public Double readDouble() {
        return Double.parseDouble(readString());
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void println(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }
}