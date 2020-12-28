package programmers;

public class 짝지어제거하기 {

	public static void main(String[] args) {
		String s = "abbacbbc";
		System.out.println(solution(s));
	}
	
	static StringBuilder sb;
	
	public static int solution(String s) {
		int answer = 0;
		
		sb = new StringBuilder(s);
		
		int idx = 1;
		while(idx < sb.length()) {
			if(sb.charAt(idx - 1) != sb.charAt(idx)) ++idx;
			else {
				sb.delete(idx - 1, idx + 1);
				idx = idx - 1 == 0 ? 1 : idx - 1;
			}
		}
		
		if(sb.length() == 0) answer = 1;
		
		return answer;
	}
}
