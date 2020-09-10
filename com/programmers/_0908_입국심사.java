package com.programmers;

import java.util.Arrays;

public class _0908_입국심사 {

	public static void main(String[] args) {
		int n = 9;
		int[] times = { 7, 10, 12 };
		System.out.println(solution(n, times));
	}

	public static long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
//		가장 첫 두 사람은 바로 심사를 받으러 갑니다.
//		7분이 되었을 때, 첫 번째 심사대가 비고 3번째 사람이 심사를 받습니다.
//		10분이 되었을 때, 두 번째 심사대가 비고 4번째 사람이 심사를 받습니다.
//		14분이 되었을 때, 첫 번째 심사대가 비고 5번째 사람이 심사를 받습니다.
//		20분이 되었을 때, 두 번째 심사대가 비지만 6번째 사람이 그곳에서 심사를 받지 않고 1분을 더 기다린 후에 첫 번째 심사대에서 심사를 받으면 28분에 모든 사람의 심사가 끝납니다.
		Arrays.sort(times);
		long left = 0;
		long right = (long)times[times.length - 1] * n;
		while(left <= right) {
			long mid = 0;
			long people = 0;
			mid = (left + right) / 2;
			for(int time : times) {
				people += mid / time;
			}
			if(people >= n) {
				answer = Math.min(answer, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return answer;
	}
}
