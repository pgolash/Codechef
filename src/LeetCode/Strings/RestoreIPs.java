package LeetCode.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 17/01/16.
 */
public class RestoreIPs {

    public static void main(String[] args) {
        RestoreIPs o = new RestoreIPs();
        List<String> x = o.restoreIpAddresses("0279245587303");
        for (String s : x) {
            System.out.println(s);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> l = new ArrayList<>();
        List<StringBuilder> x = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return l;
        }
        x.add(new StringBuilder(""));
        restoreIpAddresses(s, x, 1, l);
        return l;
    }

    public void restoreIpAddresses(String s, List<StringBuilder> ipList, int cnt, List<String> finalList) {
        if (cnt == 4) {
            if (validIP(s)) {
                for (StringBuilder bld : ipList) {
                    StringBuilder x = new StringBuilder();
                    x.append(bld.toString());
                    x.append(".");
                    x.append(s);
                    finalList.add(x.toString());
                }
            }
        } else {
            for (int i = 1; i <= 3; i++) {
                List<StringBuilder> fLst = new ArrayList<>();
                if (i < s.length() && validIP(s.substring(0, i))) {
                    for (StringBuilder prevIP : ipList) {
                        StringBuilder y = new StringBuilder(prevIP.toString());
                        if (cnt == 1) {
                            fLst.add(y.append(s.substring(0, i)));
                        } else {
                            fLst.add(y.append("." + s.substring(0, i)));
                        }
                    }
                    restoreIpAddresses(s.substring(i), fLst, cnt + 1, finalList);
                } else {
                    break;
                }
            }
        }
    }

    public boolean validIP(String s) {
        if (s == null || s.length() == 0 || s.length() > 3) {
            return false;
        } else {
            if (s.length() > 1 && s.charAt(0) == '0') {
                return false;
            } else {
                int num = Integer.parseInt(s);
                return num >= 0 && num <= 255;
            }
        }
    }
}
