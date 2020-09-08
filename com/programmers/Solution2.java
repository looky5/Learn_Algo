package com.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {

	public static void main(String[] args) {
		int n = 3;
		int[][] products = { { 6, 5, 1 }, { 11, 3, 2 }, { 7, 10, 3 } };
//		int[][] products = {{10, 3, 2}, {15, 2, 5}};
		System.out.println(solution(n, products));
	}

	public static int solution(int n, int[][] products) {
		int answer = 0;

		// arr[0]: 재고량, [1]: 개당 가격, [2]: 일일 판매 수량
		// 1. 모든 상품은 매일 정해진 수량만큼 팔림
		// 2. 행사장에는 매대가 있는데 이 매대에서 파는 물건은 매일 정해진 수량의 2배만큼 팔림
		// 3. 행사 매대에는 상품을 한 번에 한 종류만 올려놓을 수 있음.
		// 3-1. 매일 아침 한 번씩 그날 매대에 상품을 올리지 말지, 올린다면 어떤 상품을 올릴지 정할 수 있음.

		for (int j = 0; j < n; j++) {
			int max = -1;
			int idx = 0;
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return (o1[0] / o1[2]) - (o2[0] / o2[2]);
				}
			});
			for (int i = 0; i < products.length; i++) {
				int thisMax = products[i][2] * 2 <= products[i][0] ? products[i][2] * 2 * products[i][1]
						: products[i][0] * products[i][1];
				if (max <= thisMax) {
					max = thisMax;
					idx = i;
				}
			}
			products[idx][0] = products[idx][2] * 2 <= products[idx][0] ? products[idx][0] - products[idx][2] * 2 : 0;
			answer += max;
			for (int i = 0; i < products.length; i++) {
				if (i == idx)
					continue;
				int normal = 0;
				if(products[i][2] <= products[i][0]) {
					normal = products[i][2] * products[i][1];
					products[i][0] -= products[i][2];
				} else {
					normal = products[i][0] * products[i][1];
					products[i][0] = 0;
				}
				answer += normal;
			}
		}

		return answer;
	}
}
