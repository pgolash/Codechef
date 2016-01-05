package GeeksForGeeks.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 31/12/15.
 */
public class CanIWin {
    Boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger <= 0 || desiredTotal <= 0) {
            return false;
        }

        List<Integer> pool = new ArrayList<>();
        for (int i = 1; i <= maxChoosableInteger; i++) {
            pool.add(i);
        }

        return canIWinHelper(pool, desiredTotal);
    }

    private boolean canIWinHelper(List<Integer> pool, int desiredTotal) {
        if (pool.get(pool.size() - 1) >= desiredTotal) {
            return true;
        }

        for (int i = 0; i < pool.size(); i++) {
            int removed = pool.remove(i);

            boolean win = !canIWinHelper(pool, desiredTotal - removed);

            pool.add(i, removed);

            if (win) {
                return true;
            }
        }

        return false;
    }
}
