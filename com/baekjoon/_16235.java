package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _16235 {

	private static class Tree {
		int age;
		int count;

		public Tree(int age, int count) {
			super();
			this.age = age;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Tree [age=" + age + ", count=" + count + "]";
		}

	}

	static int N, M, K, answer;
	static int[][] map, A;
	static LinkedList<Tree>[][] Trees;
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		A = new int[N][N];
		Trees = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
				A[i][j] = Integer.parseInt(st.nextToken());
				Trees[i][j] = new LinkedList<Tree>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			int size = Trees[r][c].size();
			boolean haveSameAge = false;
			int idx = 0;
			for (int j = 0; j < size; j++) {
				Tree curTree = Trees[r][c].get(j);
				if (curTree.age == z) {
					++curTree.count;
					haveSameAge = true;
					break;
				} else if (curTree.age < z)
					++idx;
			}
			if (!haveSameAge)
				Trees[r][c].add(idx, new Tree(z, 1));
		}
		int year = 0;
		while (year < K) {
			springNsummer();
			autumnNwinter();
			++year;
		}
		answer = 0;
		countingSurvive();
		System.out.println(answer);
	} // end of main

	private static void springNsummer() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int size = Trees[r][c].size();
				int mapfood = 0;
				for (int n = 0; n < size; n++) {
					Tree t = Trees[r][c].get(n);
					int canSurvive = map[r][c] / t.age;
					if (canSurvive >= t.count) {
						map[r][c] -= t.age * t.count;
						++t.age;
					} else {
						map[r][c] -= t.age * canSurvive;
						int deadCnt = t.count - canSurvive;
						t.count = canSurvive;
						mapfood += deadCnt * (t.age / 2);
						if (t.count == 0) {
							Trees[r][c].remove(n--);
							--size;
						} else
							++t.age;
					}
				}
				map[r][c] += mapfood;
			}
		}
	} // end of springNsummer

	private static void autumnNwinter() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int size = Trees[r][c].size();
				for (int d = 0; d < 8; d++) {
					int ny = r + dy[d];
					int nx = c + dx[d];
					if (!check(ny, nx))
						continue;
					for (int n = 0; n < size; n++) {
						Tree t = Trees[r][c].get(n);
						if (t.age % 5 != 0)
							continue;
						if (Trees[ny][nx].size() == 0) {
							Trees[ny][nx].add(new Tree(1, t.count));
							continue;
						}
						Tree thisTree = Trees[ny][nx].getFirst();
						if (thisTree.age == 1) {
							thisTree.count += t.count;
						} else {
							Trees[ny][nx].addFirst(new Tree(1, t.count));
						}
					}
				}
				map[r][c] += A[r][c];
			}
		}
	}

	private static void countingSurvive() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int size = Trees[r][c].size();
				for (int n = 0; n < size; n++) {
					answer += Trees[r][c].get(n).count;
				}
			}
		}
	}

	private static boolean check(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
} // end of _16235

/*
 * 5 2 6 2 3 2 3 2 2 3 2 3 2 2 3 2 3 2 2 3 2 3 2 2 3 2 3 2 2 1 3 3 2 3
 */