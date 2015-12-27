package LeetCode.Geometry;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashantgolash on 26/12/15.
 */
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class MaxPointsOnALine {

    public static void main(String[] args) {
        Point[] p = new Point[3];
        p[0] = new Point(1, 1);
        p[1] = new Point(1, 1);
        p[2] = new Point(1, 1);

        System.out.println(new MaxPointsOnALine().maxPoints(p));
    }

    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;

        HashMap<Double, Integer> result = new HashMap<Double, Integer>();
        int max=0;

        for(int i=0; i<points.length; i++){
            int duplicate = 1;//
            int vertical = 0;
            for(int j=i+1; j<points.length; j++){
                if(points[i].x == points[j].x){
                    if(points[i].y == points[j].y){
                        duplicate++;
                    }else{
                        vertical++;
                    }
                }else{
                    double slope = points[j].y == points[i].y ? 0.0
                            : (1.0 * (points[j].y - points[i].y))
                            / (points[j].x - points[i].x);

                    if(result.get(slope) != null){
                        result.put(slope, result.get(slope) + 1);
                    }else{
                        result.put(slope, 1);
                    }
                }
            }

            for(Integer count: result.values()){
                if(count+duplicate > max){
                    max = count+duplicate;
                }
            }

            max = Math.max(vertical + duplicate, max);
            result.clear();
        }
        return max;
    }
}
