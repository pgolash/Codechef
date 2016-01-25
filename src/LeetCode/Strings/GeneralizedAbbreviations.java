package LeetCode.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 19/01/16.
 */
public class GeneralizedAbbreviations {
    public List<String> generateAbbreviations (String Word)  {
        List <String> res = new ArrayList<>();
        dfs (res, "" , 0 , Word);
        return res;
    }

    public  void  dfs (List <String> res, String curr, int start, String s)  {
        res.add (curr + s.substring (start));
        if (start == s.length ())
            return ;

        // Define a new starting position
        int i = 0 ;

        // In addition to the very beginning, before the start position and end position to be separated a
        if (start > 0 ) {
            i = start + 1 ;
        }

        for (; i < s.length(); i++) {
            String prefix = curr + s.substring (start, i);
            // At the beginning of ith character, and then click Replace j letters into numbers.
            for ( int j = 1 ; j <= s.length () - i; j++) {
                dfs (res, prefix + j, i + j, s);
            }
        }
    }

}
