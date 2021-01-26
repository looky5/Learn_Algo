package programmers;

public class N��������v2 {

	public static void main(String[] args) {
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 2;
		System.out.println(solution(n, t, m, p));
	}

	// n : n����, t : ���� ����, m : �÷��̾� ��, p : Ʃ�� ����

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
