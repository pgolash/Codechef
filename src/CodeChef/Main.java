package CodeChef; /**
 * Created by pgolash on 6/5/2015.
 */
import java.io.*;
import java.util.*;

class Interval implements Comparable<Interval> {
    int low;
    int high;

    Interval(int low, int high) {
        this.low = low;
        this.high = high;
    }

    @Override
    public int compareTo(Interval l) {
        if (this.high < l.high) {
            return -1;
        } else {
            return 1;
        }
    }
}

public class Main {

    static final PrintStream ps = new PrintStream(System.out);
    static Map<Integer, List<Interval>> timeIntervals = new HashMap<Integer, List<Interval>>();


    public static void main(String[] args) throws Exception {

        int N = 0, K = 0, sT = 0, eT = 0, compartment = 0;
        try {

            InputStream is;
            if (args.length > 0 && args[0].equals("Test")) {
                is = new BufferedInputStream(new FileInputStream(new java.io.File(args[1])));
            } else {
                is = System.in;
            }

            //InputReader s = new InputReader(System.in);
            //CodeChef.OutputWriter w = new CodeChef.OutputWriter(System.out);

            Parser s = new Parser(is);



            int T = s.nextInt();
            for (int i = 1; i <= T; i++) {
                int cnt = 0;


                N = s.nextInt();
                K = s.nextInt();

                // Processing for all the guests
                for (int j = 1; j <= N; j++) {

                    sT = s.nextInt();
                    eT = s.nextInt();

                    compartment = s.nextInt();

                    if (timeIntervals.get(compartment) == null) {
                        timeIntervals.put(compartment, new ArrayList<Interval>());
                    }

                    timeIntervals.get(compartment).add(new Interval(sT, eT));
                }

                // Find maximum guests that can be accommodated
                for (List<Interval> l : timeIntervals.values()) {
                    List<Interval> newL = new ArrayList<Interval>(l);
                    Collections.sort(newL);

                    if (newL.size() > 0) {
                        cnt++;
                        Interval l1 = newL.get(0);

                        for (int m = 1; m < newL.size(); m++) {
                            Interval l2 = newL.get(m);
                            if (l2.low >= l1.high) {
                                cnt++;
                                l1 = l2;
                            }
                        }
                    }
                }

                ps.println(cnt);
                timeIntervals.clear();
            }
        }
        catch(Exception e) {

            System.out.println("Exception caught");
            System.out.println("Inputs are");
            System.out.println(e.toString());

            System.out.println("N = " +N);
            System.out.println("K = " +K);
            System.out.println("sT = " +sT);
            System.out.println("eT = " +eT);
            System.out.println("compartment = " + compartment);

            ps.println(0);
        }
        //w.close();
    }

    //FAST IO
    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }

            if (curChar >= numChars) {
                curChar = 0;

                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
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

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, readInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, readInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));

            return res * sgn;

        }

        public boolean isSpaceChar(int c) {

            if (filter != null) {
                return filter.isSpaceChar(c);
            }

            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    private static class OutputWriter {

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

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

    static class Parser {
        final private int BufferSize = 65536,Init=0;
        private BufferedInputStream bis;
        private byte read;
        private int BufferPointer,BufferEnd;
        private byte[] buffer = new byte[BufferSize];

        Parser(InputStream in) throws Exception{
            bis = new BufferedInputStream(in);
            BufferPointer = 0;
            BufferEnd = bis.read(buffer, Init, BufferSize);
        }

        public int nextInt() throws Exception{
            int num = 0;
            read = readNext();
            while(read <=' ')read = readNext();
            boolean neg = read == '-';
            if(neg)read = readNext();
            do{
                num = num * 10 + (read - '0');
                read = readNext();
            }while(read > ' ');
            if(neg)return -num;
            return num;
        }

        private byte readNext() throws Exception{
            if(BufferPointer == BufferEnd)fillBuffer();
            return buffer[BufferPointer++];
        }

        private void fillBuffer() throws Exception {
            BufferPointer = Init;
            BufferEnd = bis.read(buffer, Init, BufferSize);
            if(BufferEnd==-1)buffer[0]=-1;
        }
    }
}