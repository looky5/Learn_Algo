package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5656_벽돌깨기 {

	private static class Block {
		int y;
		int x;
		int num;

		public Block(int y, int x, int num) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
		}
	}

	static int N, W, H, answer;
	static Queue<Block> que = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder("");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			answer = 99999;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] originalMap = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					originalMap[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] map = new int[H][W];

			for (int j = 0; j < W; j++) {
				for (int i = 0; i < H; i++) {
					System.arraycopy(originalMap[i], 0, map[i], 0, W);
				}
				dropTheBall(j, 0, map);
			}

			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static void dropTheBall(int col, int time, int[][] map) {
		if (time == N) {
			int blocks = getRemainingCnt(map);
			answer = Math.min(answer, blocks);
			return;
		}

		que.clear();

		for (int i = 0; i < H; i++) {
			if (map[i][col] != 0) {
				que.add(new Block(i, col, map[i][col]));
				break;
			}
		}

		while (!que.isEmpty()) {
			Block now = que.poll();
			map[now.y][now.x] = 0;
			if (now.num == 1) {
				continue;
			}
			// 좌,우 제거
			int left = now.x - now.num + 1 < 0 ? 0 : now.x - now.num + 1;
			int right = now.x + now.num - 1 >= W ? W - 1 : now.x + now.num - 1;
			for (int c = left; c <= right; c++) {
				if (map[now.y][c] > 1) {
					que.add(new Block(now.y, c, map[now.y][c]));
				}
				map[now.y][c] = 0;
			}
			// 상,하 제거
			int up = now.y - now.num + 1 < 0 ? 0 : now.y - now.num + 1;
			int down = now.y + now.num - 1 >= H ? H - 1 : now.y + now.num - 1;
			for (int r = up; r <= down; r++) {
				if (map[r][now.x] > 1) {
					que.add(new Block(r, now.x, map[r][now.x]));
				}
				map[r][now.x] = 0;
			}
		}

		relocateMap(map);

		int[][] tempMap = new int[H][W];
		for (int j = 0; j < W; j++) {
			for (int i = 0; i < H; i++) {
				System.arraycopy(map[i], 0, tempMap[i], 0, W);
			}
			dropTheBall(j, time + 1, tempMap);
		}
	}

	private static void relocateMap(int[][] map) {
		for (int j = 0; j < W; j++) {
			int row = H - 1;
			for (int i = H - 1; i >= 0; i--) {
				if (map[i][j] != 0) {
					if (row != i) {
						map[row][j] = map[i][j];
						map[i][j] = 0;
					}
					--row;
				}
			}
		}
	}

	private static int getRemainingCnt(int[][] map) {
		int result = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] != 0)
					++result;
			}
		}
		return result;
	}
}
