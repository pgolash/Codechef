package LeetCode.Strings;

/**
 * Created by prashantgolash on 22/01/16.
 */
public class FlipGameII {

    public boolean canWin(String charArray) {
        return canWin(charArray.toCharArray());
    }

    public boolean canWin(char[] charArray) {
        if (charArray == null || charArray.length == 0 || noConsecutivePlus(charArray)) {
            return false;
        } else {
            boolean win = false;
            for (int i = 0; i < charArray.length - 1; i++) {
                if (charArray[i] == '+' && charArray[i + 1] == '+') {
                    charArray[i] = '-';
                    charArray[i + 1] = '-';

                    if (!canWin(charArray)) {
                        win = true;
                    }

                    charArray[i] = '+';
                    charArray[i + 1] = '+';

                    if (win) {
                        break;
                    }
                }
            }
            return win;
        }
    }

    public boolean noConsecutivePlus(char[] charArray) {
        boolean flag = true;
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == '+' && charArray[i + 1] == '+') {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new FlipGameII().canWin("++++"));
    }
}