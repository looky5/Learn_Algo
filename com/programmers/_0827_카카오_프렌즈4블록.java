package com.programmers;

import java.util.Arrays;

public class _0827_카카오_프렌즈4블록 {

	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		System.out.println(solution(m, n, board));
	} // end of main

	private static int solution(int m, int n, String[] board) {
		int answer = 0;
		char[][] map = new char[m][n];
		for (int i = 0; i < m; i++) {
			map[i] = board[i].toCharArray();
		}

		while (true) {
			int res = resultAfterOntTime(m, n, map);
			if (res == 0)
				break;
			answer += res;
		}

		return answer;
	}

	private static int resultAfterOntTime(int m, int n, char[][] map) {
		int result = 0;
		boolean[][] check = new boolean[m][n];
		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				char ch = map[i][j];
				if (ch != '-') {
					if (map[i][j + 1] == ch && map[i + 1][j] == ch && map[i + 1][j + 1] == ch) {
						check[i][j] = true;
						check[i + 1][j] = true;
						check[i][j + 1] = true;
						check[i + 1][j + 1] = true;
					}
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (check[i][j]) {
					result++;
					map[i][j] = '-';
				}
			}
		}

		if (result == 0)
			return 0;

		for (int j = 0; j < n; j++) {
			for (int r = 0; r < m; r++) {
				int cnt = 0;
				for (int i = m - 1; i >= 0; i--) {
					if (map[i][j] == '-') {
						cnt++;
					} else {
						if (cnt > 0) {
							char tmp = map[i][j];
							map[i][j] = '-';
							map[i + cnt][j] = tmp;
							cnt = 0;
						}
					}
				}
			}
		}

		for (int i = 0; i < m; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("-------------------------");

		return result;
	}
} // end of class
