package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14501_��� {

	static int N, answer;
	static int[][] scheduleTable;
	static int[] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		scheduleTable = new int[N + 1][2];
		memo = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			scheduleTable[i][0] = Integer.parseInt(st.nextToken());
			scheduleTable[i][1] = Integer.parseInt(st.nextToken());
		}
		solution(1, 0);
		System.out.println(answer);
	}

	private static void solution(int day, int profit) {
		if (day > N) {
			if (day <= N + 1) {
				answer = Math.max(answer, profit);
			}
			return;
		}
		int addedProfit = profit + scheduleTable[day][1]; // �� ���� ����
		if (memo[day] != 0 && memo[day] >= addedProfit)
			return;
		if (day + scheduleTable[day][0] <= N)
			memo[day] = Math.max(memo[day], addedProfit);
		// �� ���ڿ� ����� �� ��� -> ���� ����� ��� ���� ��¥�� �̵�
		solution(day + scheduleTable[day][0], addedProfit);
		// �� ���ڿ� ����� ���� ���� ��� -> ���� ���� �̵�
		solution(day + 1, profit);
	}
}
