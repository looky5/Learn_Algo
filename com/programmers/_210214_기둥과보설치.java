package programmers;

import java.util.Arrays;

public class _210214_기둥과보설치 {

	public static void main(String[] args) {
		int n = 5;
//		int[][] build_frame = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 },
//				{ 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } };
		int[][] build_frame = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
				{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } };
		StringBuilder sb = new StringBuilder();
		int[][] answer = solution(n, build_frame);
		int len = answer.length;
		for (int i = 0; i < len; i++) {
			sb.append(Arrays.toString(answer[i])).append('\n');
		}
		System.out.println(sb.toString());
	}

	static boolean[][][] map;
	static int N;

	public static int[][] solution(int n, int[][] build_frame) {
		N = n;
		map = new boolean[n + 3][n + 3][2];
		int answer_size = 0;
		int len = build_frame.length;
		int x, y, frame, job;
		for (int i = 0; i < len; i++) {
			x = build_frame[i][0] + 1;
			y = build_frame[i][1] + 1;
			frame = build_frame[i][2];
			job = build_frame[i][3];
			if (job == 1) {
				if (canInstall(x, y, frame)) {
					map[y][x][frame] = true;
					++answer_size;
				}
			} else {
				map[y][x][frame] = false;
				if (canDismantle()) {
					--answer_size;
				} else {
					map[y][x][frame] = true;
				}
			}
		}

		int[][] answer = new int[answer_size][3];
		int idx = 0;
		for (int j = 1; j <= n + 1; j++) {
			for (int i = 1; i <= n + 1; i++) {
				if (map[i][j][0]) {
					answer[idx++] = new int[] { j - 1, i - 1, 0 };
				}
				if (map[i][j][1]) {
					answer[idx++] = new int[] { j - 1, i - 1, 1 };
				}
			}
		}

		return answer;
	}

	public static boolean canInstall(int x, int y, int frame) {
		if (frame == 0) {
			if (y == 1 || map[y - 1][x][0] || map[y][x - 1][1] || map[y][x][1])
				return true;
		} else {
			if (map[y - 1][x][0] || map[y - 1][x + 1][0] || (map[y][x - 1][1] && map[y][x + 1][1]))
				return true;
		}
		return false;
	}

	public static boolean canDismantle() {
		for (int r = 1; r <= N + 1; r++) {
			for (int c = 1; c <= N + 1; c++) {
				for (int k = 0; k < 2; k++) {
					if (map[r][c][k] && !canInstall(c, r, k))
						return false;
				}
			}
		}
		return true;
	}
}
