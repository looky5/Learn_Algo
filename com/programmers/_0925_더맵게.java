package com.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _0925_더맵게 {

	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;
		System.out.println(solution(scoville, K));
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		for (int i : scoville) {
			pq.offer(i);
		}

		while (true) {
			int first = pq.poll();
			if (first >= K) {
				break;
			}
			if (pq.isEmpty()) {
				answer = -1;
				break;
			}
			int second = pq.poll();
			pq.offer(first + second * 2);
			answer++;
		}

		return answer;
	}
}
