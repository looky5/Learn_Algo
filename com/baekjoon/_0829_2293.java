package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _0829_2293 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		int[][] dp = new int[n + 1][k + 1];
		Arrays.fill(dp[0], 0);
		for (int i = 1; i <= n; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= k; j++) {
				if (j - coins[i] < 0)
					dp[i][j] = dp[i - 1][j];
				else {
					dp[i][j] = dp[i][j - coins[i]] + dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n][k]);

	} // end of main
} // end of class
