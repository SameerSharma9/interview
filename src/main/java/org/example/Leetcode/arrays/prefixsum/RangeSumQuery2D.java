package org.example.Leetcode.arrays.prefixsum;

// https://leetcode.com/problems/range-sum-query-2d-immutable/description/?envType=problem-list-v2&envId=prefix-sum

public class RangeSumQuery2D {
    private int[][] pfsum;

    public RangeSumQuery2D(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        pfsum = new int[n][m];

        // Precompute prefix sums
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int top = (i > 0) ? pfsum[i - 1][j] : 0; // Sum of elements above
                int left = (j > 0) ? pfsum[i][j - 1] : 0; // Sum of elements to the left
                int corner = (i > 0 && j > 0) ? pfsum[i - 1][j - 1] : 0; // Overlapping area to be subtracted

                pfsum[i][j] = matrix[i][j] + top + left - corner; // Calculate prefix sum
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Total sum from (0,0) to (row2,col2)
        int total = pfsum[row2][col2];

        // Subtract the area above the submatrix
        int top = (row1 > 0) ? pfsum[row1 - 1][col2] : 0;

        // Subtract the area to the left of the submatrix
        int left = (col1 > 0) ? pfsum[row2][col1 - 1] : 0;

        // Add back the overlapping area that was subtracted twice
        int corner = (row1 > 0 && col1 > 0) ? pfsum[row1 - 1][col1 - 1] : 0;

        return total - top - left + corner;
    }
}