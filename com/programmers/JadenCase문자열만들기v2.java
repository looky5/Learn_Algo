package programmers;

public class JadenCase문자열만들기v2 {

	public static void main(String[] args) {
		String s = " for the last  week";
		System.out.println(solution(s));
	}

	private static String solution(String s) {
		StringBuilder sb = new StringBuilder();
		s = s.toLowerCase();

		int len = s.length();
		char c = s.charAt(0);
		boolean check = false;
		sb.append(Character.toUpperCase(c));
		if(c == ' ') check = true;
		else check = false;
		for (int i = 1; i < len; i++) {
			c = s.charAt(i);
			if(c == ' ') {
				sb.append(c);
				check = true;
			} else {
				if(check) {
					sb.append(Character.toUpperCase(c));
				} else {
					sb.append(c);
				}
				check = false;
			}
		}

		return sb.toString();
	}
}
