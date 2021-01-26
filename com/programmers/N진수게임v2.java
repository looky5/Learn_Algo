package programmers;

public class N진수게임v2 {

	public static void main(String[] args) {
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 2;
		System.out.println(solution(n, t, m, p));
	}

	// n : n진법, t : 숫자 개수, m : 플레이어 수, p : 튜브 순서

	private static String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		--p;
		int num = 0;
		int tm = t * m;
		while(sb.length() < tm) {
			sb.append(Integer.toString(num++, n));
		}
		for(int i = 0; i < t; i++) {
			answer.append(sb.charAt(i * m + p));
		}
		
		return answer.toString().toUpperCase();
	}
}
