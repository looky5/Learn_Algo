package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1062_2 {

	static int N, K, answer;
	static int[] strArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		strArr = new int[N];
//		a, n, t, i, c
		int letters = 0;
		char[] antic = { 'a', 'n', 't', 'i', 'c' };
		for (char c : antic) {
			letters |= 1 << (c - 'a');
		}
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int len = str.length();
			for(int j = 4; j < len - 4; j++) {
				strArr[i] |= 1 << (str.charAt(j) - 'a');
			}
		}
		answer = 0;
		if(K < 5) {}
		else if(K == 26) answer = N;
		else {
			solution(0, 5, letters);
		}
		System.out.println(answer);
	}

	private static void solution(int start, int count, int letters) {
		if(count == K) {
			int matchCnt = 0;
			for(int n : strArr) {
				if((n & letters) == n) ++matchCnt;
			}
			answer = answer < matchCnt ? matchCnt : answer;
			return;
		}
		for(int i = start; i < 26; i++) {
			if((letters & 1 << i) == 0) {
				solution(i + 1, count + 1, letters | 1 << i);
			}
		}
	}
}
