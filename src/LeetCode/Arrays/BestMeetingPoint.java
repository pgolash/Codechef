package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prashantgolash on 21/01/16.
 */
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Integer> listOfX = new ArrayList<Integer>();
        List<Integer> listOfY = new ArrayList<Integer>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    //System.out.println(i)
                    listOfX.add(i);
                    listOfY.add(j);
                }
            }
        }
        int numOfPeople = listOfX.size();

        Integer[] ax = new Integer[numOfPeople];
        Integer[] ay = new Integer[numOfPeople];

        listOfX.toArray(ax);
        listOfY.toArray(ay);

        Arrays.sort(ax);
        Arrays.sort(ay);

        int mid = ax.length/2;
        int medianOfX = ax[mid];
        int medianOfY = ay[mid];

        int distance = 0;
        for(int x:ax){
            distance += Math.abs(x - medianOfX);
        }
        for(int y:ay){
            distance += Math.abs(y - medianOfY);
        }
        return distance;
    }
}
