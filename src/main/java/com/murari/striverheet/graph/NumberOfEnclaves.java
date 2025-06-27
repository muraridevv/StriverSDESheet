package com.murari.striverheet.graph;

import java.util.Arrays;

public class NumberOfEnclaves {

    public int numEnclaves(int[][] grid) {
        int result = 0;
        int row= grid.length;
        int col= grid[0].length;
        for(int i=0; i<row;i++){
            if(grid[i][0]==1) dfs(grid,i,0);
            if(grid[i][col-1]==1) dfs(grid,i,col-1);
        }

        for(int j=0; j<col;j++){
            if(grid[0][j]==1) dfs(grid,0,j);
            if(grid[row-1][j]==1) dfs(grid,row-1,j);
        }

        // Count total 1s present in matrix
        for (int[] ints : grid) {
            for (int j = 0; j < col; j++) {
                if (ints[j] == 1)
                    result++;
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int i, int j){
        if(i<0 || i>= grid.length || j<0 || j>= grid[0].length || grid[i][j]!=1) return;

        grid[i][j]=0;

        dfs(grid, i-1, j);  //up
        dfs(grid, i+1, j);  //down
        dfs(grid, i, j-1);  //left
        dfs(grid, i, j+1);  //right
    }

    // Utility to print the board
    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NumberOfEnclaves solver = new NumberOfEnclaves();

//        int[][] board1 = {
//                {0,0,0,0},
//                {1,0,1,0},
//                {0,1,1,0},
//                {0,0,0,0}
//        };
//
//        System.out.println("Before:");
//        printBoard(board1);
//
//        solver.numEnclaves(board1);
//
//        System.out.println("After:");
//        printBoard(board1);

        int[][] board2 = {
                {0,1,1,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,0}
        };

        System.out.println("Before:");
        printBoard(board2);

        solver.numEnclaves(board2);

        System.out.println("After:");
        printBoard(board2);
    }
}
