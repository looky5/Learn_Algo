package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3190_¹ìv2 {

	private static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	static int N, K, L;
	static int[][] map;
	static int[][] change;
	static final int[][] dyx = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static final int[][] changedir = { { 3, 1 }, { 0, 2 }, { 1, 3 }, { 2, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 9;
		}
		L = Integer.parseInt(br.readLine());
		change = new int[L][2];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			change[i][0] = Integer.parseInt(st.nextToken());
			change[i][1] = st.nextToken().charAt(0) == 'L' ? 0 : 1;
		}
		System.out.println(playGame());
		br.close();
	}

	private static int playGame() {
		int time = 0;
		int h_dir = 1;
		int t_dir = 1;
		int changeIdx = 0;
		Queue<int[]> que = new LinkedList<>();
		map[1][1] = 1;
		Point head = new Point(1, 1);
		Point tail = new Point(1, 1);

		while (true) {
//			printMap();
//			System.out.println();
			++time;
			int ny = head.y + dyx[h_dir][0];
			int nx = head.x + dyx[h_dir][1];
			if (isGameOver(ny, nx))
				break;
			if (map[ny][nx] == 0) {
				if (!que.isEmpty()) {
					int[] quePoint = que.peek();
					if (tail.y == quePoint[0] && tail.x == quePoint[1]) {
						t_dir = quePoint[2];
						que.poll();
					}
				}
				map[tail.y][tail.x] = 0;
				tail.y += dyx[t_dir][0];
				tail.x += dyx[t_dir][1];
			}
			map[ny][nx] = 1;
			head.y = ny;
			head.x = nx;
			if (changeIdx < L) {
				if (change[changeIdx][0] == time) {
					h_dir = changedir[h_dir][change[changeIdx++][1]];
					que.add(new int[] { head.y, head.x, h_dir });
				}
			}
		}

		return time;
	}

	private static boolean isGameOver(int y, int x) {
		return y < 1 || y > N || x < 1 || x > N || map[y][x] == 1;
	}

//	private static void printMap() {
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
}
