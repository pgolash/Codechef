package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashantgolash on 27/12/15.
 */
public class MaxProductOfWordLength {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] dietpepsi = new int[n];
        for(int i=0; i<n; i++){
            dietpepsi[i] = getMask(words[i]);
        }
        int max = 0; int t;
        for(int i=0; i<n; i++){
            t = 0;
            for(int j=i+1; j<n; j++){
                if((dietpepsi[i] & dietpepsi[j]) == 0){
                    t = Math.max(t, words[j].length());
                }
            }
            max = Math.max(max, t*words[i].length());
        }
        return max;
    }
    private int getMask(String s){
        int mask = 0;
        for(char c: s.toCharArray()){
            mask |= 1 << (c - 'a');
        }
        return mask;
    }
}
