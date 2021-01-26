package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _14852_타일채우기3 {

	static final int LIMIT = (int) 1e9 + 7;
	static int N;
	static long[] dp, unique;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new long[N + 2];
		unique = new long[N + 2];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 7;

//		D[i] = 3*d[i-2] + 2*D[i-1] + (2*D[i-3] + 2*D[i-4] + ... + 2*D[0])
		for (int i = 3; i <= N; i++) {
			unique[i] = (unique[i - 1] + dp[i - 3]) % LIMIT;
			dp[i] = ((dp[i - 1] << 1) + dp[i - 2] * 3 + (unique[i] << 1)) % LIMIT;
		}
		System.out.println(dp[N]);
	}
}
