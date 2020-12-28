package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _5653_줄기세포배양 {

	private static class Cell {
		int y;
		int x;
		int life;
		int birthTime;

		public Cell(int y, int x, int life, int birthTime) {
			super();
			this.y = y;
			this.x = x;
			this.life = life;
			this.birthTime = birthTime;
		}
	}

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int[][] map = new int[350][350];
	static int N, M, K;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Comparator<Cell> comp = new Comparator<Cell>() {
			@Override
			public int compare(Cell o1, Cell o2) {
				return o2.life - o1.life;
			}
		};
		PriorityQueue<Cell>[] pq = new PriorityQueue[2];
		pq[0] = new PriorityQueue<Cell>(comp);
		pq[1] = new PriorityQueue<Cell>(comp);
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			initMap();
			pq[0].clear();
			pq[1].clear();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int time = 0;

			for (int i = 150; i < 150 + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 150; j < 150 + M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 0) {
						pq[0].add(new Cell(i, j, map[i][j], time));
					}
				}
			}

			int idx = 1;
			int idx2 = 0;
			while (time <= K) {
				int tmp = idx;
				idx = idx2;
				idx2 = tmp;
				while (!pq[idx].isEmpty()) {
					Cell now = pq[idx].poll();
					int elapsedTime = time - now.birthTime;
					if (elapsedTime == now.life + 1) { // 번식
						for (int d = 0; d < 4; d++) {
							int ny = now.y + dy[d];
							int nx = now.x + dx[d];
							if (map[ny][nx] != 0)
								continue;
							map[ny][nx] = now.life;
							pq[idx2].add(new Cell(ny, nx, now.life, time));
						}
					}
					if (elapsedTime == now.life << 1) { // 죽음
						map[now.y][now.x] = -1;
					} else {
						pq[idx2].add(now);
					}
				}
				++time;
			}
			sb.append('#').append(tc).append(' ').append(countCell()).append('\n');
		} // end of case
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	} // end of main

	private static void initMap() {
		for (int i = 0; i < 350; i++) {
			Arrays.fill(map[i], 0);
		}
	}

	private static int countCell() {
		int count = 0;
		for (int i = 0; i < 350; i++) {
			for (int j = 0; j < 350; j++) {
				if (map[i][j] > 0)
					++count;
			}
		}
		return count;
	}

}
