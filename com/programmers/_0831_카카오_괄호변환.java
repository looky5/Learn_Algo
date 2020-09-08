package com.programmers;

import java.util.Stack;

public class _0831_카카오_괄호변환 {

	public static void main(String[] args) {
		String p = ")()()()(";
//		String p = "(()())()";
		System.out.println(solution(p));
	} // end of main

	private static String solution(String str) {
		if (str.equals("") || isRight(str)) {
			return str;
		}
		StringBuffer sb = new StringBuffer();
		String u = "", v = "";
		int[] count = new int[2];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				count[0]++;
			} else {
				count[1]++;
			}
			if (count[0] == count[1]) {
				u = str.substring(0, i + 1);
				v = str.substring(i + 1);
				break;
			}
		}
		if (isRight(u)) {
			return sb.append(u).append(solution(v)).toString();
		} else {
			sb.append('(').append(solution(v)).append(')');
			for(int i = 1; i < u.length() - 1; i++) {
				if(u.charAt(i) == '(') {
					sb.append(')');
				} else {
					sb.append('(');
				}
			}
			return sb.toString();
		}
	} // end of dfs()

	private static boolean isRight(String str) {
		Stack<Character> stack = new Stack<>();
		char[] charArr = str.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == ')') {
				if (stack.isEmpty() || stack.peek() == ')') {
					return false;
				}
				stack.pop();
			} else {
				stack.push('(');
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	} // end of isRight()
} // end of class
