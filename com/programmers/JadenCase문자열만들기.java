package programmers;

public class JadenCase문자열만들기 {

	public static void main(String[] args) {
		String s = " for the last  week";
		System.out.println(solution(s));
	}

	private static String solution(String s) {
		StringBuilder sb = new StringBuilder(s.toLowerCase());

		int len = sb.length();
		char c = sb.charAt(0);
		boolean check = false;
		if (c >= 'a' && c <= 'z') {
			sb.replace(0, 1, "" + (char) (c - 32));
		}
		for (int i = 1; i < len; i++) {
			c = sb.charAt(i);
			if (c != ' ') {
				if (check) {
					sb.replace(i, i + 1, "" + (char) (c - 32));
				}
				check = false;
			} else {
				check = true;
			}
		}

		return sb.toString();
	}
}
