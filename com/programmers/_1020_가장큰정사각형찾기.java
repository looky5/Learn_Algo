package com.programmers;
public class _1020_가장큰정사각형찾기 {
    public static void main(String[] args) {
//        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
//        int[][] board = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        int[][] board = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
//        int[][] board = {{1, 1, 1, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 1, 1, 1}};
//        int[][] board = {{0, 0, 1, 1}, {1, 1, 1, 1}};
        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int answer = 0;
        int rowSize = board.length;
        int colSize = board[0].length;
        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {
                if(board[i][j] == 1) {
                    board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }
        for(int i = 0; i < rowSize; i++) {
            answer = Math.max(answer, board[i][0]);
        }
        for(int j = 0; j < colSize; j++) {
            answer = Math.max(answer, board[0][j]);
        }

        return answer * answer;
    }
}
