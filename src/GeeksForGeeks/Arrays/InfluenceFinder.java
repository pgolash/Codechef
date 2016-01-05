package GeeksForGeeks.Arrays;

/**
 * Created by prashantgolash on 02/01/16.
 */
public class InfluenceFinder {
    int getInfluencer(int[][] M) {
        int cand=0;

        for(int i = 1; i < M.length; i++) {
            if(M[cand][i] == 1 || M[i][cand] == 0) {
                cand = i;
            }
        }

        for(int j=0; j < M.length; j++) {
            if(j==cand) continue;
            if(M[cand][j] == 1 || M[j][cand] == 0) return -1;
        }

        return cand;
    }
}
