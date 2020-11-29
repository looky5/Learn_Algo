package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class _0923_가장큰수 {

	public static void main(String[] args) {
		int[] numbers = { 3, 30, 34, 5, 9 };
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		int len = numbers.length;
		Comparator<String> cprt = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
//                System.out.println("o2 + o1: " + (o2+o1) + " / o1 + o2: " + (o1+o2));
				return (o2 + o1).compareTo(o1 + o2);
			}
		};
		String[] arr = new String[len];
//        ArrayList<String> al = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			arr[i] = Integer.toString(numbers[i]);
		}
		Arrays.sort(arr, cprt);

//        for(int i = 0; i < len; i++) {
//            al.add(Integer.toString(numbers[i]));
//            String[] str = new String[al.size()];
//            al.toArray(str);
//            Arrays.sort(str, cprt);
//            System.out.println(Arrays.toString(str));
//        }

		if (arr[0].equals("0")) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(arr[i]);
		}

		return sb.toString();
	}
}
