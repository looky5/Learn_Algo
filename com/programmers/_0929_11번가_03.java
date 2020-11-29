package com.programmers;

import java.util.Arrays;

public class _0929_11번가_03 {

	public static void main(String[] args) {
		int[] A1 = { 6, 2, 3, 5, 6, 3 };
		int[] A2 = { 6, 5, 4, 3, 2, 1 };
		int[] A3 = { 3, 3, 4, 5, 6, 6, 6, 6, 7, 8, 9 };
		int[] A4 = { 3, 3, 4, 5, 6, 6 };
		System.out.println(solution(A3));
	}

	public static int solution(int[] A) {
		int answer = 0;
		int len = A.length;
		Arrays.sort(A);
		for (int i = 0; i < len; i++) {
			answer += A[i] >= i + 1 ? A[i] - (i + 1) : i + 1 - A[i];
		}

		return answer = answer >= (int) 1e9 ? -1 : answer;
	}
}
