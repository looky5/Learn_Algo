package com.programmers;

public class _0910_코드챌린지s1p3 {

	public static void main(String[] args) {
//		int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
		int[] a = { 9, -1, -5 };
		System.out.println(solution(a));
	}

	public static int solution(int[] a) {
		int answer = 0;

		for (int i = 0; i < a.length; i++) {
			int num = a[i];
			int cnt = 2;
			for (int left = i - 1; left >= 0; left--) {
				if (a[left] < num) {
					cnt--;
					break;
				}
			}
			if (cnt == 1) {
				for (int right = i + 1; right < a.length; right++) {
					if (a[right] < num) {
						cnt--;
						break;
					}
				}
			}
			if (cnt != 0) {
				answer++;
			}
		}

		return answer;
	}
}
