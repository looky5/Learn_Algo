package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _2580 {

	private static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static boolean flag;
	static int count;
	static int[][] board;
	static ArrayList<Point> al;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		board = new int[9][9];
		al = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) {
					al.add(new Point(i, j));
				}
			}
		}
		flag = false;
		count = al.size();
		int idx = 0;
		Point p = al.get(idx);

		for (int val = 1; val <= 9; val++) {
			if (flag)
				return;
			if (isPossible(p.y, p.x, val)) {
				board[p.y][p.x] = val;
				sudoku(idx + 1);
				board[p.y][p.x] = 0;
			}
		}
	}

	private static void sudoku(int idx) {
		if (idx == count) {
			flag = true;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]).append(' ');
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.append('\n');
			}
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
			return;
		}
		Point p = al.get(idx);

		for (int val = 1; val <= 9; val++) {
			if (flag)
				return;
			if (isPossible(p.y, p.x, val)) {
				board[p.y][p.x] = val;
				sudoku(idx + 1);
				board[p.y][p.x] = 0;
			}
		}
	}

	private static boolean isPossible(int y, int x, int val) {
		for (int i = 0; i < 9; i++) {
			if (board[i][x] == val)
				return false;
			if (board[y][i] == val)
				return false;
		}

		int row = (y / 3) * 3;
		int col = (x / 3) * 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[row + i][col + j] == val)
					return false;
			}
		}
		return true;
	}
}
