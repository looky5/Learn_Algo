package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1062_°¡¸£Ä§_210119 {

	static int N, K, antic, spells, answer;
	static int[] words;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = 0;
		if (K >= 5) {
			words = new int[N];
			StringBuilder sb = new StringBuilder();
			int len = 0;
			antic = 1;
			antic |= 1 << 'n' - 'a';
			antic |= 1 << 't' - 'a';
			antic |= 1 << 'i' - 'a';
			antic |= 1 << 'c' - 'a';
			for (int i = 0; i < N; i++) {
				sb.setLength(0);
				sb.append(br.readLine());
				len = sb.length();
				words[i] |= antic;
				for (int j = 4; j < len - 4; j++) {
					words[i] |= 1 << (sb.charAt(j) - 'a');
				}
				spells |= words[i];
			}
			solution(0, 5, antic);
		}
		System.out.println(answer);
	}

	private static void solution(int start, int count, int letters) {
		if (count == K) {
			answer = Math.max(answer, getCnt(letters));
			return;
		}
		for (int i = start; i < 26; i++) {
			if ((spells & 1 << i) == 0 || (antic & 1 << i) != 0)
				continue;
			solution(i + 1, count + 1, letters | 1 << i);
		}
		answer = Math.max(answer, getCnt(letters));
	}

	private static int getCnt(int letters) {
		int cnt = 0;
		for (int word : words) {
			if ((word & letters) == word) {
				++cnt;
			}
		}
		return cnt;
	}
}
