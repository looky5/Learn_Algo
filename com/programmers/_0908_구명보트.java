package com.programmers;

import java.util.Arrays;

public class _0908_구명보트 {

	public static void main(String[] args) {
		int[] people = { 90, 90, 90, 90 };
		int limit = 100;
		System.out.println(solution(people, limit));
	}

	public static int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people); // {1, 2, 3, 4, 5}
		int[] point = new int[2];
		point[1] = people.length - 1;
		while(point[0] < point[1]) {
			if(people[point[0]] + people[point[1]] > limit) {
				point[1]--;
			} else {
				point[0]++;
				point[1]--;
			}
			answer++;
		}
		if(point[0] == point[1]) {
			answer++;
		}

		return answer;
	}
}
