package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11112_¼¿·ÎÆÇÁö {

	private static class Point {
		int y;
		int x;
		int color;

		public Point(int y, int x, int color) {
			super();
			this.y = y;
			this.x = x;
			this.color = color;
		}

	}

	static final int[][] dyx = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static final String[] answer = {"YY", "YN", "NY", "NN"};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static int[][] map = new int[2001][2001];
	static boolean[][] check = new boolean[2001][2001];
	static int a, b, c, d, p, q, r;
	static boolean[] trigger = new boolean[2];
	static Queue<Point> que = new LinkedList<Point>();

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			trigger[0] = false;
			trigger[1] = false;
			initMap();
			inputData();
			drawRed();
			drawBlue();
		} // end of case
		
		br.close();
	} // end of main

	private static void drawRed() {
		que.clear();
		que.add(new Point(p, q, 1));

		while (!que.isEmpty()) {
			Point now = que.poll();

			for (int d = 0; d < 4; d++) {
				int ny = now.y + dyx[d][0];
				int nx = now.x + dyx[d][1];
				if (map[ny][nx] == now.color || !calcCircle(ny, nx))
					continue;
				map[ny][nx] = now.color;
				que.add(new Point(ny, nx, now.color));
			}
		}
	}

	private static void drawBlue() {
		que.clear();
		que.add(new Point(a, b, 2));
		
		while(!que.isEmpty()) {
			Point now = que.poll();
			
			for(int d = 1; d < 3; d++) {
				int ny = now.y + dyx[d][0];
				int nx = now.x + dyx[d][1];
				if(check[ny][nx] || !calcSquare(ny, nx))
					continue;
				if(map[ny][nx] == 0) {
					
				}
			}
		}
	}

	private static boolean calcCircle(int y, int x) {
		return Math.pow(x - p, 2) + Math.pow(y - q, 2) <= r * r;
	}

	private static boolean calcSquare(int y, int x) {
		return x <= c && y <= d;
	}

	private static void initMap() {
		for (int i = 0; i < 2001; i++) {
			Arrays.fill(map[i], 0);
		}
	}
	
	private static void initCheck() {
		for (int i = 0; i < 2001; i++) {
			Arrays.fill(check[i], false);
		}
	}

	private static void inputData() throws IOException {
		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken()) + 1000;
		q = Integer.parseInt(st.nextToken()) + 1000;
		r = Integer.parseInt(st.nextToken()) + 1000;
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken()) + 1000;
		b = Integer.parseInt(st.nextToken()) + 1000;
		c = Integer.parseInt(st.nextToken()) + 1000;
		d = Integer.parseInt(st.nextToken()) + 1000;
	}
}
