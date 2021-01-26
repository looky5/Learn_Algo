package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3190_¹ì {

	private static class Point {
		int y;
		int x;
		int dir;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
			this.dir = 1;
		}

		public Point(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}

	}

	static int N, K, L;
	static int[][] map;
	static int[][] change;
	static Queue<Point> que = new LinkedList<>();
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
		int changeIdx = 0;
		que.clear();
		map[1][1] = 1;
		que.add(new Point(1, 1));

		while (!que.isEmpty()) {
//			printMap();
//			System.out.println();
			++time;
			int queSize = que.size();
			boolean ateApple = false;
			Point pre = null;
			for (int i = 0; i < queSize; i++) {
				Point now = que.poll();
				map[now.y][now.x] = 0;
				if (pre == null) { // ¸Ó¸®
					pre = new Point(now.y, now.x);
					int ny = now.y + dyx[now.dir][0];
					int nx = now.x + dyx[now.dir][1];
					if (!checkWithinArea(ny, nx) || map[ny][nx] == 1) {
						return time;
					}
					if (map[ny][nx] == 9) {
						ateApple = true;
					}
					if (changeIdx < L && change[changeIdx][0] == time) {
						now.dir = changedir[now.dir][change[changeIdx][1]];
						++changeIdx;
					}
					map[ny][nx] = 1;
					que.add(new Point(ny, nx, now.dir));
				} else {
					swapPoint(pre, now);
					map[now.y][now.x] = 1;
					que.add(now);
				}
			}
			if(ateApple) {
				map[pre.y][pre.x]= 1;
				que.add(new Point(pre.y, pre.x));
			}
		}

		return time;
	}

	private static void swapPoint(Point p1, Point p2) {
		int tmpY = p1.y;
		int tmpX = p1.x;
		p1.y = p2.y;
		p1.x = p2.x;
		p2.y = tmpY;
		p2.x = tmpX;
	}

	private static boolean checkWithinArea(int y, int x) {
		return y > 0 && y <= N && x > 0 && x <= N;
	}
	
//	private static void printMap() {
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println(); 
//		}
//	}
}
