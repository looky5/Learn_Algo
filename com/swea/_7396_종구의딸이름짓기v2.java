package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7396_Á¾±¸ÀÇµþÀÌ¸§Áþ±âv2 {

	private static class Point {
		int y;
		int x;
		char ch;

		public Point(int y, int x, char ch) {
			super();
			this.y = y;
			this.x = x;
			this.ch = ch;
		}

	}

	static int N, M;
	static char[][] board = new char[2000][2000];
	static boolean[][] check = new boolean[2000][2000];
	static int[] dy = { 0, 1 };
	static int[] dx = { 1, 0 };
	static StringBuilder answer = new StringBuilder();
	static Queue<Point> que = new LinkedList<>();
	static Queue<Point> que2 = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		StringBuilder strb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			que.clear();
			que2.clear();
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

			makeName();

			strb.append('#').append(tc).append(' ').append(answer.toString()).append('\n');
		} // end of case
		strb.deleteCharAt(strb.length() - 1);
		System.out.println(strb.toString());
	} // end of main

	private static void makeName() {
		que.add(new Point(0, 0, board[0][0]));
		check[0][0] = true;

		while (!que.isEmpty()) {
			int queSize = que.size();
			char c1 = 'z' + 1;
			char c2 = 'z' + 1;
			for (int i = 0; i < queSize; i++) {
				Point now = que.poll();
				if (now.y == N - 1 && now.x == M - 1) {
					answer.append(now.ch);
					return;
				}
				c1 = c1 > now.ch ? now.ch : c1;
				for (int d = 0; d < 2; d++) {
					int ny = now.y + dy[d];
					int nx = now.x + dx[d];
					if (ny < N && nx < M && !check[ny][nx]) {
						if (board[ny][nx] < c2) {
							c2 = board[ny][nx];
							que2.clear();
							que2.add(new Point(ny, nx, board[ny][nx]));
							check[ny][nx] = true;
						} else if(board[ny][nx] == c2) {
							que2.add(new Point(ny, nx, board[ny][nx]));
							check[ny][nx] = true;
						}
					}
				}
			}
			answer.append(c1);
			que.addAll(que2);
		}

	} // end of makeName()

	private static void clearCheckArr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				check[i][j] = false;
			}
		}
	}
}
