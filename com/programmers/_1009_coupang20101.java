package com.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1009_coupang20101 {

	public static void main(String[] args) {
//        int[][] goods = {{25400, 2}, {10000, 1}, {31600, 1}};
		int[][] goods = { { 3100, 2 }, { 7700, 1 }, { 3100, 2 } };
//        int[][] coupons = {{5, 3}, {23, 2}, {11, 2}, {9, 5}};
		int[][] coupons = { { 33, 4 } };
		System.out.println(solution(goods, coupons));
	}

	private static int solution(int[][] goods, int[][] coupons) {
		int answer = 0;

		PriorityQueue<Integer> goodsQue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		for (int i = 0; i < goods.length; i++) {
			for (int j = 0; j < goods[i][1]; j++) {
				goodsQue.add(goods[i][0]);
			}
		}

		PriorityQueue<Integer> couponsQue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		for (int i = 0; i < coupons.length; i++) {
			for (int j = 0; j < coupons[i][1]; j++) {
				couponsQue.add(coupons[i][0]);
			}
		}

		while (!goodsQue.isEmpty()) {
			if (!couponsQue.isEmpty()) {
				answer += goodsQue.poll() / 100 * (100 - couponsQue.poll());
			} else {
				answer += goodsQue.poll();
			}
		}

		return answer;
	}
}
