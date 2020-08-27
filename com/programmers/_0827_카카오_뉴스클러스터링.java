package com.programmers;

import java.util.HashMap;
import java.util.Map;

public class _0827_카카오_뉴스클러스터링 {

	public static void main(String[] args) {
		String st1 = "E=M*C^2";
		String st2 = "e=m*c^2";
		System.out.println(solution(st1, st2));
	} // end of main

	private static int solution(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		int answer = 0;
		Map<String, Integer> strArr = new HashMap<>();
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		System.out.println(str1);
		System.out.println(str2);
		
		int interSec = 0;
		int total = 0;

		for (int i = 0; i < str1.length() - 1; i++) {
			char c1 = str1.charAt(i);
			char c2 = str1.charAt(i + 1);

			if ((c1 >= 65 && c1 <= 90) && (c2 >= 65 && c2 <= 90)) {
				sb.append(c1).append(c2);
				if (strArr.containsKey(sb.toString())) {
					strArr.replace(sb.toString(), strArr.get(sb.toString()) + 1);
				}
				else {
					strArr.put(sb.toString(), 1);
				}
				sb.delete(0, sb.length());
				total++;
			}
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			char c1 = str2.charAt(i);
			char c2 = str2.charAt(i + 1);

			if ((c1 >= 65 && c1 <= 90) && (c2 >= 65 && c2 <= 90)) {
				sb.append(c1).append(c2);
				if (strArr.containsKey(sb.toString())) {
					if (strArr.get(sb.toString()) > 0) {
						strArr.replace(sb.toString(), strArr.get(sb.toString()) - 1);
						interSec++;
					}
				}
				sb.delete(0, sb.length());
				total++;
			}
		}
		
		if(total != 0) {
			answer = (int) (((double) interSec / (total - interSec)) * 65536);
		} else {
			answer = 65536;
		}

		return answer;
	} // end of solution
} // end of class
