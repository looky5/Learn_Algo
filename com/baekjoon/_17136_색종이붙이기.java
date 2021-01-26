package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// �����̴� 1x1���� 5x5���� ���� 5�徿 �ִ�.
// 1�� ���� ĭ�� ��� �����̷� �������� �Ѵ�.
// �����̰� ��� ������ �����ų� ��ġ�� �� �ȴ�.
// �����̴� 0�� ����� �� �ȴ�.
// 1�� ���� ��� ĭ�� ���̴� ���� �ʿ��� �������� �ּ� ������ ���Ͽ���.
// 1�� ��� ���� ���� �Ұ����� ��� -1�� ����Ѵ�.

public class _17136_�����̺��̱� {

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
