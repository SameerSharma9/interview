package org.example.Leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {

    private boolean validateBox(char[][] board) {
        for(int i=0; i < 9; i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j = i*3 ; j < i*3 + 3; j++) {              //0 0 0 1 1 1 2 2 2 0 0 0 1 1 1 2 2 2 0 0 0 1 1 1 2 2 2
                for( int k = i*3 ; k < i*3 + 3; k++) { //0 1 2 0 1 2 0 1 2 3 4 5 3 4 5 3 4 5 6 7 8 6 7 8 6 7 8
                    char tem = board[j][k];
                    System.out.println("row: "+((i*3)+j)+" col: "+((i*3)+k));
                    if(tem != '.' && set.contains(tem)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {

        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        new ValidSudoku().validateBox(board);
    }
}
