package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14499_주사위굴리기 {

	static int N, M, x, y, K;
	static int[][] map;
	static int[][] diceMap = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
	static int[][] dyx = { {}, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		char[] roll = br.readLine().toCharArray();
		int rollIdx = 0;
		int tmp = 0;

		while (rollIdx < roll.length) {
			int dir = roll[rollIdx] - '0';
			int ny = y + dyx[dir][0];
			int nx = x + dyx[dir][1];
			if (!isWithInArea(ny, nx)) {
				rollIdx += 2;				
				continue;
			}
			y = ny;
			x = nx;
			switch(dir) {
			case 1:
				tmp = diceMap[1][3];
				for(int i = 3; i > 0; i--) {
					diceMap[1][i] = diceMap[1][i - 1];
				}
				diceMap[1][0] = tmp;
				diceMap[0][1] = diceMap[1][1];
				diceMap[0][3] = diceMap[1][3];
				break;
			case 2:
				tmp = diceMap[1][0];
				for(int i = 0; i < 3; i++) {
					diceMap[1][i] = diceMap[1][i + 1];
				}
				diceMap[1][3] = tmp;
				diceMap[0][1] = diceMap[1][1];
				diceMap[0][3] = diceMap[1][3];
				break;
			case 3:
				tmp = diceMap[0][0];
				for(int i = 0; i < 3; i++) {
					diceMap[0][i] = diceMap[0][i + 1];
				}
				diceMap[0][3] = tmp;
				diceMap[1][1] = diceMap[0][1];
				diceMap[1][3] = diceMap[0][3];
				break;
			case 4:
				tmp = diceMap[0][3];
				for(int i = 3; i > 0; i--) {
					diceMap[0][i] = diceMap[0][i - 1];
				}
				diceMap[0][0] = tmp;
				diceMap[1][1] = diceMap[0][1];
				diceMap[1][3] = diceMap[0][3];
			}
			if (map[y][x] == 0) {
				map[y][x] = diceMap[0][3];
			} else {
				diceMap[0][3] = map[y][x];
				diceMap[1][3] = map[y][x];
				map[y][x] = 0;
			}
			sb.append(diceMap[0][1]).append('\n');
			rollIdx += 2;
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static boolean isWithInArea(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}
}
