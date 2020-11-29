package com.programmers;

import java.util.Arrays;

public class _0913_line03 {

	public static void main(String[] args) {
		int n = 90000;
		System.out.println(Arrays.toString(solution(n)));
	}

	public static int[] solution(int n) {
		int[] answer = new int[2];
		StringBuilder sb = new StringBuilder();
		sb.append(n);
		while (n / 10 > 0) {
			int size = sb.length();
			int right = Integer.parseInt(sb.substring((size - 1) / 2 + 1, sb.length()));
			int left = n / (int) Math.pow(10, (int) Math.log10(right) + 1);
			n = left + right;
			sb.delete(0, sb.length());
			sb.append(n);
			System.out.println(left + " " + right);
			answer[0]++;
		}
		answer[1] = n;
		return answer;
	}
}
