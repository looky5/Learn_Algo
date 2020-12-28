package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1062 {
	static ArrayList<Character> alphabet;
	static String[] strArr;
	static int N, K, answer;
	static final char[] antic = { 'a', 'n', 't', 'i', 'c' };

//	a, n, t, i, c
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()) - 5;

		alphabet = new ArrayList<>();
		boolean[] checked = new boolean[26];
		strArr = new String[N];
		long flag = 0;
		for (int n : antic) {
			checked[n - 'a'] = true;
			flag |= 1 << (n - 'a');
		}
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			strArr[i] = str.substring(4, str.length() - 4);
			for (char c : strArr[i].toCharArray()) {
				if (!checked[c - 'a']) {
					alphabet.add(c);
					checked[c - 'a'] = true;
				}
			}
		}
//		System.out.println(Arrays.toString(strArr));
//		for(char c : alphabet) {
//			System.out.print(c + " ");
//		}
//		System.out.println();

		if (K < 0) {
			answer = 0;
		} else if (K + 5 == 26) {
			answer = N;
		} else {
			K = alphabet.size() < K ? alphabet.size() : K;
			solution(0, 0, flag);
		} // end of else()
		System.out.println(answer);
	} // end of main

	private static void solution(int start, int count, long flag) {
		if (count == K) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				int len = strArr[i].length();
				for (int j = 0; j < len; j++) {
					if ((flag & 1 << (strArr[i].charAt(j) - 'a')) == 0) {
						--cnt;
						break;
					}
				}
				++cnt;
			}
			answer = Math.max(answer, cnt);
			return;
		}
		for (int i = start; i < alphabet.size(); i++) {
			solution(i + 1, count + 1, flag | 1 << (alphabet.get(i) - 'a'));
		}
	}
} // end of class
