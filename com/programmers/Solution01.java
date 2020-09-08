package com.programmers;

public class Solution01 {

	public static void main(String[] args) {
		int n = 2;
		int[][] products = { { 10, 3, 2 }, { 15, 2, 5 } };
		System.out.println(solution(n, products));
	}

	static int max = -1;
	static int days;
	static int[][] goods;

	public static int solution(int n, int[][] products) {
		int answer = 0;

		// arr[0]: 재고량, [1]: 개당 가격, [2]: 일일 판매 수량
		// 1. 모든 상품은 매일 정해진 수량만큼 팔림
		// 2. 행사장에는 매대가 있는데 이 매대에서 파는 물건은 매일 정해진 수량의 2배만큼 팔림
		// 3. 행사 매대에는 상품을 한 번에 한 종류만 올려놓을 수 있음.
		// 3-1. 매일 아침 한 번씩 그날 매대에 상품을 올리지 말지, 올린다면 어떤 상품을 올릴지 정할 수 있음.

		days = n;
		goods = products.clone();
		
		dfs(0, 0, 0);
		answer = max;
		return answer;
	}

	private static void dfs(int count, int sum, int idx) {
		if (count == days) {
			if (sum > max) {
				max = sum;
			}
			return;
		}
		for (int i = 0; i < goods.length; i++) {
			if (i == idx) {
				if(goods[i][2] * 2 <= goods[i][0]) {
					sum += goods[i][2] * goods[i][1] * 2;
					goods[i][0] -= goods[i][2] * 2;
				} else {
					sum += goods[i][0] * goods[i][1];
					goods[i][0] = 0;
				}
			} else {
				if(goods[i][2] <= goods[i][0]) {
					sum += goods[i][2] * goods[i][1];
					goods[i][0] -= goods[i][2];
				} else {
					sum += goods[i][2] * goods[i][0];
					goods[i][0] = 0;
				}
			}
		}
		dfs(count + 1, sum, idx);
		dfs(count + 1, sum, idx + 1);
	}
}
