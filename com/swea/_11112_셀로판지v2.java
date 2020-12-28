package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11112_셀로판지v2 {

	static final String[] answer = { "YY", "YN", "NY", "NN" };
	static int a, b, c, d, p, q, r;
	static boolean[] square = new boolean[4];

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			initSquare(); // 원 안에 꼭짓점이 속하면 true, 그렇지 않으면 false
			sb.append('#').append(tc).append(' ');
			if (calc(b, a) && calc(b, c) && calc(d, a) && calc(d, c)) {
				sb.append(answer[1]);
			} else {
				if (p - r >= a && p + r <= c && q + r <= d && q - r >= b) {
					sb.append(answer[2]);
				} else {
					sb.append(answer[0]);
				}
			}
			if (tc < T) {
				sb.append('\n');
			}
		} // end of case
		System.out.println(sb.toString());
		br.close();
	} // end of main

//	private static boolean calc(int y, int x) {
//		return Math.pow(x - p, 2) + Math.pow(y - q, 2) <= r * r;
//	}

	private static boolean calc(int y, int x) {
		return (x - p) * (x - p) + (y - q) * (y - q) <= r * r;
	}

	private static void initSquare() {
		Arrays.fill(square, false);
	}

//	private static void inputData() throws IOException {
//		st = new StringTokenizer(br.readLine());
//		p = Integer.parseInt(st.nextToken());
//		q = Integer.parseInt(st.nextToken());
//		r = Integer.parseInt(st.nextToken());
//		st = new StringTokenizer(br.readLine());
//		a = Integer.parseInt(st.nextToken());
//		b = Integer.parseInt(st.nextToken());
//		c = Integer.parseInt(st.nextToken());
//		d = Integer.parseInt(st.nextToken());
//	}
}
