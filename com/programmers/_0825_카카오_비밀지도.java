package com.programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _0825_카카오_비밀지도 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {0, 1, 21, 17, 28};
		String[] answer = solution(n, arr1, arr2);
		System.out.println(Arrays.toString(answer));
	}
	private static String[] solution(int n, int[] arr1, int[] arr2) {
		StringBuilder sb = new StringBuilder();
        String[] answer = new String[n];

        for(int i = 0; i < n; i++) {
        	int num = arr1[i] | arr2[i];
        	String str = Integer.toBinaryString(num);
        	int len = str.length();
        	for(int j = 0; j < n - len; j++){
        		sb.append('0');
        	}
        	sb.append(str);
        	System.out.println(sb.toString());
        	str = sb.toString();
        	sb.delete(0, sb.length());
        	str = str.replace('1', '#');
        	str = str.replace('0', ' ');
        	answer[i] = str;
        }
        
        return answer;
    }
}
