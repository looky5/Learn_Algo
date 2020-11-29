package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1124_BOJ_12100 {

	static int N, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solution(board, 0, 0);
		System.out.println(answer);
	}

	private static void solution(int[][] board, int count, int direction) {
		switch (direction) {
		case 0:
			break;
		case 1: // up
			for (int j = 0; j < N; j++) {
				int tmp = 0;
				int idx = 0;
				for (int i = 0; i < N; i++) {
					if (board[i][j] != 0) {
						int next = board[i][j];
						board[i][j] = 0;
						if (tmp == 0)
							tmp = next;
						else if (tmp == next) {
							board[idx++][j] = tmp << 1;
							tmp = 0;
						} else {
							board[idx++][j] = tmp;
							tmp = next;
						}
					}
				}
				if (tmp != 0) {
					board[idx][j] = tmp;
				}
			}
			break;
		case 2: // right
			for (int i = 0; i < N; i++) {
				int tmp = 0;
				int idx = N - 1;
				for (int j = N - 1; j >= 0; j--) {
					if (board[i][j] != 0) {
						int next = board[i][j];
						board[i][j] = 0;
						if (tmp == 0)
							tmp = next;
						else if (tmp == next) {
							board[i][idx--] = tmp << 1;
							tmp = 0;
						} else {
							board[i][idx--] = tmp;
							tmp = next;
						}
					}
				}
				if (tmp != 0) {
					board[i][idx] = tmp;
				}
			}
			break;
		case 3: // down
			for (int j = 0; j < N; j++) {
				int tmp = 0;
				int idx = N - 1;
				for (int i = N - 1; i >= 0; i--) {
					if (board[i][j] != 0) {
						int next = board[i][j];
						board[i][j] = 0;
						if (tmp == 0)
							tmp = next;
						else if (tmp == next) {
							board[idx--][j] = tmp << 1;
							tmp = 0;
						} else {
							board[idx--][j] = tmp;
							tmp = next;
						}
					}
				}
				if (tmp != 0) {
					board[idx][j] = tmp;
				}
			}
			break;
		case 4: // left
			for (int i = 0; i < N; i++) {
				int tmp = 0;
				int idx = 0;
				for (int j = 0; j < N; j++) {
					if (board[i][j] != 0) {
						int next = board[i][j];
						board[i][j] = 0;
						if (tmp == 0)
							tmp = next;
						else if (tmp == next) {
							board[i][idx++] = tmp << 1;
							tmp = 0;
						} else {
							board[i][idx++] = tmp;
							tmp = next;
						}
					}
				}
				if (tmp != 0) {
					board[i][idx] = tmp;
				}
			}
		}
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
//		System.out.println();
		if (count == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					answer = Math.max(answer, board[i][j]);
				}
			}
			return;
		}
		for (int d = 1; d < 5; d++) {
			solution(copyArr(board), count + 1, d);
		}
	}

	private static int[][] copyArr(int[][] arr) {
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) {
			System.arraycopy(arr[i], 0, result[i], 0, N);
		}
		return result;
	}
}
