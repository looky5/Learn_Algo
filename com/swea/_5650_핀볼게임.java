package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _5650_핀볼게임 {

	private static class Ball {
		int y;
		int x;
		int dir;

		public Ball(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}

	}

	private static class Wormhole {
		int y;
		int x;
		Wormhole otherSide;

		public Wormhole(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	static int N, answer;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int[][] obj = { {}, { 2, 3, 1, 0 }, { 1, 3, 0, 2 }, { 3, 2, 0, 1 }, { 2, 0, 3, 1 }, { 2, 3, 0, 1 } };
	static Map<Integer, Wormhole> wormholes = new HashMap<>();
	static int[][] map = new int[101][101];

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			answer = 0;
			initMap();
			wormholes.clear();
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] >= 6) {
						if (wormholes.containsKey(map[i][j]))
							wormholes.get(map[i][j]).otherSide = new Wormhole(i, j);
						else
							wormholes.put(map[i][j], new Wormhole(i, j));
					}
				}
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] != 0)
						continue;
					for (int d = 0; d < 4; d++) {
						int score = startGame(new Ball(i, j, d));
						answer = Math.max(answer, score);
					}
				}
			}
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		} // end of case
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	} // end of main

	private static int startGame(Ball ball) {
		int score = 0;
		int startY = ball.y;
		int startX = ball.x;
		while (true) {
			boolean outOfRange = false;
			boolean fallBlackHole = false;
			boolean comebackStart = false;
			while (true) {
				int nextY = ball.y + dy[ball.dir];
				int nextX = ball.x + dx[ball.dir];
				if (checkSafeArea(nextY, nextX)) { // 범위를 벗어나지 않은 경우
					int num = map[nextY][nextX];
					if (num == 0) {
						ball.y = nextY;
						ball.x = nextX;
						if (ball.y == startY && ball.x == startX) {
							comebackStart = true;
							break;
						}
						continue;
					} else if (num >= 6) { // 웜홀
						Wormhole nowWH = wormholes.get(num);
						if (nowWH.y == nextY && nowWH.x == nextX) {
							ball.y = nowWH.otherSide.y;
							ball.x = nowWH.otherSide.x;
						} else {
							ball.y = nowWH.y;
							ball.x = nowWH.x;
						}
						continue;
					} else if (num == -1) {
						fallBlackHole = true;
					} else { // 벽
						ball.y = nextY;
						ball.x = nextX;
						ball.dir = obj[num][ball.dir];
					}
					break;
				} else { // 범위를 벗어난 경우
					outOfRange = true;
					ball.y = nextY;
					ball.x = nextX;
					if (nextY < 1)
						ball.dir = 2;
					else if (nextY > N)
						ball.dir = 0;
					else if (nextX < 1)
						ball.dir = 1;
					else if (nextX > N)
						ball.dir = 3;
					break;
				}
			}
			if (fallBlackHole)
				break;
			if (comebackStart) {
				if (outOfRange)
					++score;
				break;
			}
			++score;
		}
		return score;
	}

	private static boolean checkSafeArea(int y, int x) {
		return y > 0 && y <= N && x > 0 && x <= N;
	}

	private static void initMap() {
		for (int i = 1; i <= N; i++) {
			Arrays.fill(map[i], 0);
		}
	}
}
