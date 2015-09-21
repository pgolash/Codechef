package LeetCode.Arrays;

import java.util.Arrays;

/**
 * Created by prashantgolash on 9/20/15.
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = new char[][] { ".87654321".toCharArray(),
                                        "2........".toCharArray(),
                                        "3........".toCharArray(),
                                        "4........".toCharArray(),
                                        "5........".toCharArray(),
                                        "6........".toCharArray(),
                                        "7........".toCharArray(),
                                        "8........".toCharArray(),
                                        "9........".toCharArray()};
        new ValidSudoku().isValidSudoku(board);
    }

    public boolean isValidSudoku(char[][] board) {

        if (board == null || board.length == 0) {
            return false;
        } else {

            boolean[] flags = new boolean[10];
            int rowLength = board.length;
            int colLength = board[0].length;
            boolean valid = true;

            for (int i = 0; i < rowLength; i++) {
                valid = true;
                Arrays.fill(flags, false);
                for (int j = 0; j < colLength; j++) {
                    if (board[i][j] >= '1' && board[i][j] <= '9') {
                        int targetNumber = board[i][j] - '0';
                        if (!flags[targetNumber]) {
                            flags[targetNumber] = true;
                        } else {
                            valid = false;
                            break;
                        }
                    } else if (board[i][j] != '.') {
                        valid = false;
                        break;
                    }
                }

                if (!valid) {
                    break;
                }
            }

            if (valid) {

                // now check col
                for (int j = 0; j < colLength; j++) {
                    valid = true;
                    Arrays.fill(flags, false);
                    for (int i = 0; i < rowLength; i++) {
                        if (board[i][j] >= '1' && board[i][j] <= '9') {
                            int targetNumber = board[i][j] - '0';
                            if (!flags[targetNumber]) {
                                flags[targetNumber] = true;
                            } else {
                                valid = false;
                                break;
                            }
                        } else if (board[i][j] != '.') {
                            valid = false;
                            break;
                        }
                    }

                    if (!valid) {
                        break;
                    }
                }
            }


            if (valid) {
                for (int i = 0; i <= rowLength - (rowLength) / 3; i += 3) {
                    int currI = i;
                    for (int j = 0; j <= colLength - (colLength) / 3; j += 3) {
                        valid = true;
                        Arrays.fill(flags, false);
                        int currJ = j;

                        for (int tempI = currI; tempI < currI + 3; tempI++) {
                            for (int tempJ = currJ; tempJ < currJ + 3; tempJ++) {
                                if (board[tempI][tempJ] >= '1' && board[tempI][tempJ] <= '9') {
                                    int targetNumber = board[tempI][tempJ] - '0';
                                    if (!flags[targetNumber]) {
                                        flags[targetNumber] = true;
                                    } else {
                                        valid = false;
                                        break;
                                    }
                                } else if (board[tempI][tempJ] != '.') {
                                    valid = false;
                                    break;
                                }
                            }

                            if (!valid) {
                                break;
                            }
                        }
                        if (!valid) {
                            break;
                        }
                    }
                    if (!valid) {
                        break;
                    }
                }
            }

            return valid;
        }
    }
}