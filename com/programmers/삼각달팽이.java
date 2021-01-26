package programmers;

import java.util.Arrays;

public class »ï°¢´ÞÆØÀÌ {

	public static void main(String[] args) {
		int n = 60;
		System.out.println(Arrays.toString(solution(n)));
	}

	static int[] dy = { 1, 0, -1 };
	static int[] dx = { 0, 1, -1 };

	private static int[] solution(int n) {
		int[] answer = new int[(n * n + n) >> 1];
		int[][] pyramid = new int[n][];
		for (int i = 0; i < n; i++) {
			pyramid[i] = new int[i + 1];
		}
		int num = 1;
		int r = -1, c = 0, d = 0;
		for (int k = n; k > 0; k--) {
			for (int i = 0; i < k; i++) {
				r += dy[d];
				c += dx[d];
				pyramid[r][c] = num++;
			}
			d = d == 2 ? 0 : d + 1;
		}

		int idx = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				answer[idx++] = pyramid[i][j];
			}
		}

		return answer;
	}
}
