package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이는 1x1부터 5x5까지 각각 5장씩 있다.
// 1이 적힌 칸은 모두 색종이로 덮어져야 한다.
// 색종이가 경계 밖으로 나가거나 겹치면 안 된다.
// 색종이는 0을 덮어서는 안 된다.
// 1이 적힌 모든 칸을 붙이는 데에 필요한 색종이의 최소 개수를 구하여라.
// 1을 모두 덮는 것이 불가능한 경우 -1을 출력한다.

public class _17136_색종이붙이기 {

	static int answer, pCnt;
	static int[][] board;
	static int[] paper;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board = new int[10][10];
		board = new int[10][10];
		paper = new int[] { 0, 5, 5, 5, 5, 5 };
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = 100000;
		pCnt = 0;
		solution(0, 0);
		answer = answer == 100000 ? -1 : answer;
		System.out.println(answer);
	}

	private static void solution(int r, int c) {
//		if (countPaper() > answer)
//			return;
		if (pCnt > answer)
			return;
		for (int i = r; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (board[i][j] == 1) {
					for (int k = 5; k >= 1; k--) {
						if (paper[k] < 1)
							continue;
						if (canStickPaper(i, j, k - 1)) {
							stickPaper(i, j, k);
							--paper[k];
							++pCnt;
							solution(i, j);
							removePaper(i, j, k);
							++paper[k];
							--pCnt;
						}
					}
					return;
				}
			}
		}
		if (isPossible()) {
//			int PaperCnt = countPaper();
//			answer = Math.min(answer, PaperCnt);
			answer = Math.min(answer, pCnt);
		}
	}

	private static int countPaper() {
		int count = 0;

		for (int i = 1; i <= 5; i++) {
			count += 5 - paper[i];
		}

		return count;
	}

	private static boolean isPossible() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (board[i][j] == 1)
					return false;
			}
		}
		return true;
	}

	private static boolean canStickPaper(int y, int x, int n) {
		if (y + n < 10 && x + n < 10) {
			for (int i = y; i <= y + n; i++) {
				for (int j = x; j <= x + n; j++) {
					if (board[i][j] != 1)
						return false;
				}
			}
			return true;
		} else
			return false;
	}

	private static void stickPaper(int y, int x, int n) {
		int limitY = y + n;
		int limitX = x + n;
		for (int i = y; i < limitY; i++) {
			for (int j = x; j < limitX; j++) {
				board[i][j] = 2;
			}
		}
	}

	private static void removePaper(int y, int x, int n) {
		int limitY = y + n;
		int limitX = x + n;
		for (int i = y; i < limitY; i++) {
			for (int j = x; j < limitX; j++) {
				board[i][j] = 1;
			}
		}
	}
}
