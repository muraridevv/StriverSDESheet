package com.murari.striverheet.dynamicprogramming2;

public class MinimumPathSum {

    public int minPathSumRecursion(int[][] grid) {
        return minPathSumHelper(grid,0, 0);
    }

    private int minPathSumHelper(int[][] grid, int row, int col){
        // Base case: If at bottom right,
        if(row== grid.length-1 && col==grid[0].length-1){
            return grid[row][col];
        }

        //If at bottom, only way to move is to right
        if(row==grid.length-1){
            return  minPathSumHelper(grid, row, col+1) + grid[row][col];
        }

        //If at right, only way to move is bottom
        if(col==grid[0].length-1){
            return minPathSumHelper(grid, row+1, col)+ grid[row][col];
        }

        // Otherwise recursively explore both the path and return the minimum.
        int right= minPathSumHelper(grid, row, col+1);
        int down= minPathSumHelper(grid, row+1, col);

        return grid[row][col]+ Math.min(right, down);
    }

    public int minPathSum(int[][] grid) {
        int row= grid.length;
        int col= grid[0].length;
        int[][] dp= new int[row][col];

        dp[0][0]= grid[0][0];

        for(int i=1; i<row; i++){
            dp[i][0]= dp[i-1][0]+grid[i][0];
        }

        for(int j=1; j<col; j++){
            dp[0][j]= dp[0][j-1]+grid[0][j];
        }

        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                dp[i][j]= grid[i][j]+ Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int minSum = minimumPathSum.minPathSum(grid);
        System.out.println("Minimum path sum: " + minSum);
    }
}
