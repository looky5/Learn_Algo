package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _210125_14502_¿¬±¸¼Òv2 {

	static int N, M, answer;
	static int[][] map;
	static ArrayList<int[]> virus_list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		answer = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		virus_list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus_list.add(new int[] { i, j });
				}
			}
		}

		buildUpWall(0, 0);
		System.out.println(answer);
	}

	static int[][] dyx = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	private static boolean checkMap(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}

	private static void dfs(int y, int x) {
		for (int d = 0; d < 4; d++) {
			int ny = y + dyx[d][0];
			int nx = x + dyx[d][1];
			if (!checkMap(ny, nx) || map[ny][nx] != 0)
				continue;
			map[ny][nx] = 3;
			dfs(ny, nx);
		}
	}

	private static int getSafeArea() {
		for (int[] p : virus_list) {
			dfs(p[0], p[1]);
		}
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					++result;
				} else if (map[i][j] == 3) {
					map[i][j] = 0;
				}
			}
		}
		return result;
	}

	private static void buildUpWall(int count, int start_row) {
		if (count == 3) {
			answer = Math.max(answer, getSafeArea());
			return;
		}
		for (int i = start_row; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					buildUpWall(count + 1, i);
					map[i][j] = 0;
				}
			}
		}
	}
}
