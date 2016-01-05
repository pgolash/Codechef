package GeeksForGeeks.Arrays;

/**
 * Created by prashantgolash on 03/01/16.
 */
public class Sort012 {
    enum DutchColors {
        RED, WHITE, BLUE
    }

    private static void dutchNationalFlagSort(DutchColors[] items) {
        int lo = 0, mid = 0, hi = items.length - 1;

        while (mid <= hi) {
            switch (items[mid]) {
                case RED:
                    swap(items, lo++, mid++);
                    break;
                case WHITE:
                    mid++;
                    break;
                case BLUE:
                    swap(items, mid, hi--);
                    break;
            }
        }
    }

    private static void swap(DutchColors[] arr, int a, int b) {
        DutchColors tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
