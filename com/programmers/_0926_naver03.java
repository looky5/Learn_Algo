package com.programmers;

public class _0926_naver03 {

	public static void main(String[] args) {
		int k1 = 5; // 5
		int k2 = 6; // 7
		int k3 = 11; // 99
		int k4 = 1; // 0
		int k5 = 50;
		System.out.println(solution(15));
	}

	public static long solution(int k) {
		int[] numbers = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };
		return Perm(numbers, k, 0, new StringBuilder(), true);
	}

	private static long Perm(int[] numbers, int remainder, long answer, StringBuilder sb, boolean isFirst) {
		int idx = 0;
		if (isFirst)
			idx = 1;
		for (; idx < 10; idx++) {
			if (remainder - numbers[idx] > 1) {
				StringBuilder sbu = new StringBuilder(sb.toString());
				answer = Perm(numbers, remainder - numbers[idx], answer, sbu.append(" ").append(idx), false);
			} else if (remainder - numbers[idx] == 0) {
				sb.append(" ").append(idx);
				System.out.println("remainder: " + remainder + " | i: " + idx + " | numbers: " + numbers[idx] + " | "
						+ sb.toString());
				sb.delete(sb.length() - 2, sb.length());
				answer++;
			}
		}
//        System.out.println("answer: " + answer);
		return answer;
	}
}
