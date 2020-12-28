package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _7396_Á¾±¸ÀÇµþÀÌ¸§Áþ±â {

	private static class Point {
		int y;
		int x;
		int order;
		char ch;

		public Point(int y, int x, int order, char ch) {
			super();
			this.y = y;
			this.x = x;
			this.order = order;
			this.ch = ch;
		}

	}

	static int N, M;
	static char[][] board = new char[2000][2000];
	static boolean[][] check = new boolean[2000][2000];
	static int[] dy = { 0, 1 };
	static int[] dx = { 1, 0 };
	static StringBuilder answer = new StringBuilder();
	static PriorityQueue<Point> que = new PriorityQueue<Point>(new Comparator<Point>() {

		@Override
		public int compare(Point o1, Point o2) {
			int rank1 = o1.order - o2.order;
			if (rank1 == 0) {
				return o1.ch - o2.ch;
			} else {
				return rank1;
			}
		}
	});

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		StringBuilder strb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			que.clear();
			answer.delete(0, answer.length());
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			clearCheckArr();
			sb.delete(0, sb.length());
			for (int i = 0; i < N; i++) {
				sb.append(br.readLine());
				for (int j = 0; j < M; j++) {
					char c = sb.charAt(j);
					board[i][j] = c;
				}
				sb.delete(0, sb.length());
			}

			answer.append(board[0][0]);
			makeName();

			strb.append('#').append(tc).append(' ').append(answer.toString()).append('\n');
		} // end of case
		strb.deleteCharAt(strb.length() - 1);
		System.out.println(strb.toString());
	} // end of main

	private static void makeName() {
		que.add(new Point(0, 0, 0, board[0][0]));
		check[0][0] = true;
		while (!que.isEmpty()) {
			Point now = que.poll();
			if (now.ch > answer.charAt(now.order)) {
				continue;
			}
			if (now.ch < answer.charAt(now.order)) {
				answer.setCharAt(now.order, now.ch);
			}
			for (int d = 0; d < 2; d++) {
				int nextY = now.y + dy[d];
				int nextX = now.x + dx[d];
				if (nextY < N && nextX < M && !check[nextY][nextX]) {
					if (now.order + 1 > answer.length() - 1) {
						answer.append(board[nextY][nextX]);
						que.add(new Point(nextY, nextX, now.order + 1, board[nextY][nextX]));
						check[nextY][nextX] = true;
					} else if (board[nextY][nextX] <= answer.charAt(now.order + 1)) {
						que.add(new Point(nextY, nextX, now.order + 1, board[nextY][nextX]));
						check[nextY][nextX] = true;
					}
				}
			}
		}
	}

	private static void clearCheckArr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				check[i][j] = false;
			}
		}
	}
}
