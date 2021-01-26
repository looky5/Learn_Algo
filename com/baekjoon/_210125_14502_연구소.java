package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _210125_14502_¿¬±¸¼Ò {

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

	private static void buildUpWall(int wall_cnt, int start_row) {
		if (wall_cnt == 3) {
			answer = Math.max(answer, getSafeArea());
			return;
		}
		for (int i = start_row; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0)
					continue;
				map[i][j] = 1;
				buildUpWall(wall_cnt + 1, i);
				map[i][j] = 0;
			}
		}
	}

	static int[][] dyx = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static Queue<int[]> que = new LinkedList<int[]>();

	private static void activateVirus() {
		que.clear();
		for (int[] p : virus_list) {
			que.add(p);
		}
		int[] now;
		while (!que.isEmpty()) {
			now = que.poll();
			for (int d = 0; d < 4; d++) {
				int ny = now[0] + dyx[d][0];
				int nx = now[1] + dyx[d][1];
				if (!checkArrExpt(ny, nx) || map[ny][nx] != 0)
					continue;
				map[ny][nx] = 3;
				que.add(new int[] { ny, nx });
			}
		}
	}

	private static boolean checkArrExpt(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}

	private static int getSafeArea() {
		int result = 0;
		activateVirus();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					++result;
				else if (map[i][j] == 3)
					map[i][j] = 0;
			}
		}
		return result;
	}
}
