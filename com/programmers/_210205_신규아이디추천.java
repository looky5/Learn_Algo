package programmers;

public class _210205_신규아이디추천 {

	public static void main(String[] args) {
		String new_id = "=.=";
		System.out.println(solution(new_id));
	}

	public static String solution(String new_id) {
		new_id = new_id.toLowerCase();
		new_id = new_id.replaceAll("[^0-9a-z\\-\\_\\.]", "");
		new_id = new_id.replaceAll("\\.+", ".");
		if (new_id.charAt(0) == '.') {
			new_id = new_id.substring(1);
		}
		if (new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') {
			new_id = new_id.substring(0, new_id.length() - 1);
		}
		if (new_id.length() == 0) {
			new_id = "a";
		}
		if (new_id.length() > 15) {
			new_id = new_id.substring(0, 15);
			if (new_id.charAt(14) == '.') {
				new_id = new_id.substring(0, new_id.length() - 1);
			}
		}
		int n = 3 - new_id.length();
		if (n > 0) {
			char c = new_id.charAt(new_id.length() - 1);
			for (int i = 0; i < n; i++) {
				new_id += c;
			}
		}

		return new_id;
	}
}
