package Codeforces.Div342;

import java.util.List;

/**
 * Created by prashantgolash on 11/03/16.
 */
public class WarOfCorporations {

//    public static void main(String[] args) {
//        List<Integer> indexList = new ArrayList<>();
//        Scanner s = new Scanner(System.in);
//        String mainString = s.next();
//        String subString = s.next();
//
//        int answerCount = 0;
//        int currReach = -1;
//
//        populate(indexList, mainString, subString);
//
//        for (int i = 0; i < indexList.size(); i++) {
//            if (indexList.get(i) <= currReach) {
//                continue;
//            } else {
//                currReach = indexList.get(i) + subString.length() - 1;
//                answerCount++;
//            }
//        }
//
//        System.out.println(answerCount);
//    }

    public static void populate(List<Integer> lst, String mainString, String subString) {
        for (int i = 0; i <= mainString.length() - subString.length(); i++) {
            if (mainString.substring(i, i + subString.length()).equals(subString)) {
                lst.add(i);
            }
        }
    }
}