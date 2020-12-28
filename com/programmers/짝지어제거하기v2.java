package programmers;

import java.util.Stack;

public class 짝지어제거하기v2 {

	public static void main(String[] args) {
		String s = "cdcd";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();

		int len = s.length();

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (stack.isEmpty()) {
				stack.add(c);
			} else {
				if (stack.peek() == c)
					stack.pop();
				else
					stack.add(c);
			}
		}
		if(stack.isEmpty()) answer = 1;

		return answer;
	}
}
