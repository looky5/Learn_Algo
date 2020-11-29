package com.programmers;

public class _0929_11번가_01 {

	public static void main(String[] args) {
		String s = "aadog";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = 0;

		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (cnt > 2) {
				answer = -1;
				break;
			}
			if (s.charAt(i) == 'a') {
				cnt++;
			} else {
				answer += 2 - cnt;
				cnt = 0;
			}
		}
		if (answer != -1) {
			answer += 2 - cnt;
		}

		return answer;
	}
}
