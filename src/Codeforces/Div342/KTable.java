package Codeforces.Div342;

import java.util.Scanner;

/**
 * Created by prashantgolash on 12/03/16.
 */
public class KTable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n  = s.nextInt();
        int k = s.nextInt();
        int total = 0;
        int[][] answerMatrix = new int[n + 1][n + 1];

        int subtract = n - k;
        int nextSubtract = n - k + 1;
        int firstNum = n * n - subtract;
        int count = n;

        while (count >= 1) {

            // set row number count
            int save = firstNum;
            answerMatrix[count][k] = firstNum;

            for (int i = k + 1; i <= n; i++) {
                answerMatrix[count][i] = ++firstNum;
            }

            firstNum = save;
            total += firstNum;
            firstNum -= nextSubtract;
            count--;
        }

        // fill smallest n * n - n * k numbers
        int currNum = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k - 1; j++) {
                answerMatrix[i][j] = currNum;
                currNum++;
            }
        }

        System.out.println(total);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(answerMatrix[i][j]);
                if (j != n) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }
    }
}
