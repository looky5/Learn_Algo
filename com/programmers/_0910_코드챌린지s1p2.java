package com.programmers;

import java.util.Arrays;

public class _0910_코드챌린지s1p2 {

	public static void main(String[] args) {
		int n = 6;
		System.out.println(Arrays.toString(solution(n)));
	}

	static int[] dy = { 1, 0, -1 };
	static int[] dx = { 0, 1, -1 };

	public static int[] solution(int n) {
		int[] answer = new int[(n + 1) * n / 2];
		int[][] triangle = new int[n][];
		for (int i = 0; i < n; i++) {
			triangle[i] = new int[i + 1];
		}
		int num = 1;
		int dir = 0;
		int[] idx = new int[2];
		idx[0] = -1;
		for (int cnt = n; cnt >= 1; cnt--) {
			for (int i = 0; i < cnt; i++) {
				idx[0] = idx[0] + dy[dir];
				idx[1] = idx[1] + dx[dir];
				triangle[idx[0]][idx[1]] = num++;
			}
			dir = dir + 1 == 3 ? 0 : dir + 1;
		}
		
		int loc = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < triangle[i].length; j++) {
				answer[loc++] = triangle[i][j];
			}
		}

		return answer;
	}
}
