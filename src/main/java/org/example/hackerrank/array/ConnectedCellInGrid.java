package org.example.hackerrank.array;

import java.util.List;

public class ConnectedCellInGrid {


    static int maxi = 0;
    public static int connectedCell(List<List<Integer>> matrix) {

        for(int i = 0; i < matrix.size(); i++) {
            for(int j = 0; j < matrix.get(i).size(); j++) {
                if(matrix.get(i).get(j) == 1) {
                    ConnectedCellInGrid.dfs(matrix, i, j, 1);
                }
            }
        }
        return maxi;
    }

    static void dfs(List<List<Integer>> matrix, int i, int j, int connected) {

        if(i<0 || j<0 || i>=matrix.size() || j >= matrix.get(i).size()
                || matrix.get(i).get(j) == 0) {return;}
        matrix.get(i).set(j,0);
        connected++;
        maxi = Math.max(maxi, connected);
        dfs(matrix, i+1,j,connected);
        dfs(matrix, i-1,j,connected);
        dfs(matrix, i+1,j+1,connected);
        dfs(matrix, i-1,j+1,connected);
        dfs(matrix, i+1,j-1,connected);
        dfs(matrix, i-1,j-1,connected);
        dfs(matrix, i,j+1,connected);
        dfs(matrix, i,j-1,connected);
        matrix.get(i).set(j,1);
    }
}
