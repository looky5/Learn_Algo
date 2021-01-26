package programmers;

public class ÀÚ¹°¼è¿Í¿­¼è {

	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		System.out.println(solution(key, lock));
	}

	static int[][][] pKey;
	static int[][] pLock, board, tmp, initLock;
	static int N, M, boardSize, start_lock, end_lock;

	private static boolean solution(int[][] key, int[][] lock) {
		N = lock.length;
		M = key.length;
		boolean trigger = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (lock[i][j] == 0) {
					trigger = false;
					i = N;
					break;
				}
			}
		}
		if (trigger)
			return true;
		pKey = new int[4][M][M];
		for (int i = 0; i < M; i++) {
			System.arraycopy(key[i], 0, pKey[0][i], 0, M);
		}
		tmp = new int[M][M];
		for (int i = 1; i < 4; i++) {
			rotateKey(i);
		}
		pLock = lock;
		initLock = new int[N][N];
		for (int i = 0; i < N; i++) {
			System.arraycopy(lock[i], 0, initLock[i], 0, N);
		}
		boardSize = ((M - 1) * 2) + N;
		start_lock = M - 1;
		end_lock = start_lock + N;
		board = new int[boardSize][boardSize];
		rollbackLock();

		return putKey();
	}

	private static boolean putKey() {
		for (int i = 0; i <= boardSize - M; i++) {
			for (int j = 0; j <= boardSize - M; j++) {
				for (int n = 0; n < 4; n++) {
					for (int r = 0; r < M; r++) {
						for (int c = 0; c < M; c++) {
							board[i + r][j + c] += pKey[n][r][c];
						}
					}
					if (doesFit())
						return true;
					rollbackLock();
				}
			}
		}
		return false;
	}

	private static boolean doesFit() {
		for (int i = start_lock; i < end_lock; i++) {
			for (int j = start_lock; j < end_lock; j++) {
				if (board[i][j] != 1)
					return false;
			}
		}
		return true;
	}

	private static void rollbackLock() {
		for (int i = start_lock; i < end_lock; i++) {
			System.arraycopy(initLock[i - M + 1], 0, board[i], start_lock, N);
		}
	}

	private static void rotateKey(int n) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				tmp[j][M - 1 - i] = pKey[n - 1][i][j];
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				pKey[n][i][j] = tmp[i][j];
			}
		}
	}
}
