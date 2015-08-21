package CodeChef;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

/**
 * Created by pgolash on 6/5/2015.
 */
public class RandomNumberGenerator {

    // T>= 1 && T<=30
    // 0 <= N <= 10^5
    // 1 <= K <= 10^9
    // 0 ≤ si < fi ≤ 10^9
    // 1 ≤ pi ≤ K

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public static void main(String[] args) throws Exception{

        File file = new File("Input.txt");
        // creates the file
        file.createNewFile();
        // creates a FileWriter Object
        FileWriter writer = new FileWriter(file);

        writer.write("80" + "\n");
        for (int i = 1; i <= 60; i++ ) {
            int N = randInt(0, 100000);
            int K = randInt(1, 1000000000);

            writer.write(N + " " + K + "\n");

            for (int j = 1; j <= N; j++) {
                int fT = randInt(0, 1000000000);
                int sT = randInt(0, fT - 1);
                int compartment = randInt(1, K);
                writer.write(sT + " " + fT + " " + compartment + "\n");
            }
        }
        writer.flush();
        writer.close();
    }
}
