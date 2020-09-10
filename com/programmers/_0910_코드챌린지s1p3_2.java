package com.programmers;

public class _0910_코드챌린지s1p3_2 {
	
	public static void main(String[] args) {
//		int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
//		int[] a = {9, -1, -5};
		int[] a = {1,3,4};
		System.out.println(solution(a));
	}
	
	public static int solution(int[] a) {
		int answer = 2;
		if(a.length <= 2) {
			return a.length;
		}
		int[] leftMin = new int[a.length];
		leftMin[0] = a[0];
		int[] rightMin = new int[a.length];
		rightMin[a.length - 1] = a[a.length - 1];
		
		for(int i = 1; i < a.length; i++) {
			leftMin[i] = leftMin[i - 1] < a[i] ? leftMin[i - 1] : a[i];
		}
		
		for(int i = a.length - 2; i >= 1; i--) {
			rightMin[i] = rightMin[i + 1] < a[i] ? rightMin[i + 1] : a[i];
		}
		
		for (int i = 1; i < a.length - 1; i++) {
			if(a[i] > leftMin[i - 1] && a[i] > rightMin[i + 1]) continue;
			answer++;
		}

		return answer;
    }
}
