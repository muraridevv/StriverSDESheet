package com.murari.striverheet.recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

  private void solveNQueensHelper(List<List<String>> resultSet, char[][] board, int col) {}

  public List<List<String>> solveNQueens(Integer n) {
    List<List<String>> resultSet = new ArrayList<>();
    char[][] board = new char[n][n];
    // fill board with empty cells
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '.';
      }
    }

    // calll helper method to solve NQueen
    solveNQueensHelper(resultSet, board, 0);
    return resultSet;
  }

  // Main method to test the NQueens class
  public static void main(String[] args) {
    NQueen nQueens = new NQueen();
    int n = 4; // Change this value to test for different N
    List<List<String>> result = nQueens.solveNQueens(n);
    for (List<String> solution : result) {
      System.out.println("Solution:");
      for (String row : solution) {
        System.out.println(row);
      }
      System.out.println();
    }
  }
}
