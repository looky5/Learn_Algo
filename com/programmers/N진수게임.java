package programmers;

public class N진수게임 {

	public static void main(String[] args) {
		int n = 2;
		int t = 4;
		int m = 2;
		int p = 1;
		System.out.println(solution(n, t, m, p));
	}

	// n : n진법, t : 숫자 개수, m : 플레이어 수, p : 튜브 순서

	private static String solution(int n, int t, int m, int p) {
		--p;
		StringBuilder sb = new StringBuilder();
		int num = 0;
		while (true) {
			sb.append(getJinsu(num++, n));
			if (sb.length() / m >= t)
				break;
		}
		int len = sb.length();
		StringBuilder answer = new StringBuilder();
		for(int i = 0; i < len; i += m) {
			if(i + p >= len || answer.length() == t) break;
			answer.append(sb.charAt(i + p));
		}

		return answer.toString();
	}

	static StringBuilder strbd = new StringBuilder();

	private static String getJinsu(int num, int jinsu) {
		strbd.setLength(0);
		while (num / jinsu > 0) {
			int nmj = num % jinsu;
			if (nmj > 9) {
				strbd.append((char) ('A' + (nmj - 10)));
			} else {
				strbd.append(nmj);
			}
			num /= jinsu;
		}
		if (num > 9) {
			strbd.append((char) ('A' + (num - 10)));
		} else {
			strbd.append(num);
		}
		strbd.reverse();
		return strbd.toString();
	}
}
