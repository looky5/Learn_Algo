package com.programmers;

import java.util.Arrays;

public class _1009_coupang20201 {

	public static void main(String[] args) {
		int N = 1000000;
		System.out.println(Arrays.toString(solution(N)));
	}

	private static int[] solution(int N) {
		int jinbup = 0;
		int answer = 0;
		String n = "" + N;
		for (int i = 2; i <= 10; i++) {
			String s = jinsu(N, i);
			int gop = multiple(s);
			if (gop >= answer) {
				jinbup = i;
				answer = gop;
			}
		}

		return new int[] { jinbup, answer };
	}

	private static int multiple(String s) {
		int answer = 1;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			answer *= s.charAt(i) - '0';
		}
		return answer;
	}

	private static String jinsu(int N, int radix) {
		StringBuilder sb = new StringBuilder();
		if (N / radix > 0) {
			sb.append(jinsu(N / radix, radix));
		}
		sb.append(N % radix);
		return sb.toString();
	}
}
