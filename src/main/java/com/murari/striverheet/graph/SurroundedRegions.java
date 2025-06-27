package com.murari.striverheet.graph;

import java.util.Arrays;

public class SurroundedRegions {

  public void solve(char[][] board) {
    int m = board.length;
    int n = board[0].length;

    // Step1: Check for the edge char 'O'
    for (int i = 0; i < m; i++) {
      if (board[i][0] == 'O') dfs(board, i, 0);
      if (board[i][n - 1] == 'O') dfs(board, i, n - 1);
    }

    for (int j = 0; j < board[0].length; j++) {
      if (board[0][j] == 'O') dfs(board, 0, j);
      if (board[m - 1][j] == 'O') dfs(board, m - 1, j);
    }

    // Step2: Flip 'O' to 'X' and '#' to 'O'
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'O') board[i][j] = 'X';
        else if (board[i][j] == '#') board[i][j] = 'O';
      }
    }
  }

  private void dfs(char[][] board, int i, int j) {
    int row = board.length;
    int col = board[0].length;

    if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O') return;

    board[i][j] = '#';

    dfs(board, i - 1, j); // up
    dfs(board, i + 1, j); // down
    dfs(board, i, j - 1); // left
    dfs(board, i, j + 1); // right
  }

  // Utility to print the board
  public static void printBoard(char[][] board) {
    for (char[] row : board) {
      System.out.println(Arrays.toString(row));
    }
    System.out.println();
  }

  public static void main(String[] args) {
    SurroundedRegions solver = new SurroundedRegions();

    char[][] board = {
      {'X', 'X', 'X', 'X'},
      {'X', 'O', 'O', 'X'},
      {'X', 'X', 'O', 'X'},
      {'X', 'O', 'X', 'X'}
    };

    System.out.println("Before:");
    printBoard(board);

    solver.solve(board);

    System.out.println("After:");
    printBoard(board);
  }
}
