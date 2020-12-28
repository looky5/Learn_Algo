package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5658_보물상자비밀번호 {

	private static class Area {
		private int first;
		private int end;
		private int endIndex;

		public Area(int first, int end, int endIndex) {
			super();
			this.first = first;
			this.end = end;
			this.endIndex = endIndex;
		}

		private void rotate() {
			if (--first < 0)
				first = endIndex;
			if (--end < 0)
				end = endIndex;
		}

		private int getNumber() {
			if (end - first < 0) {
				StringBuilder str = new StringBuilder();
				str.append(sb.substring(first)).append(sb.substring(0, end + 1));
				return Integer.parseInt(str.toString(), 16);
			} else {
				return Integer.parseInt(sb.substring(first, end + 1), 16);
			}
		}
	}

	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		StringBuilder strb = new StringBuilder("");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		int N, K = 0;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			sb = new StringBuilder(br.readLine());
			Area[] areaArr = new Area[4];
			int divide = N >> 2;
			for (int i = 0; i < 4; i++) {
				int start = divide * i;
				areaArr[i] = new Area(start, start + divide - 1, N - 1);
			}
			int[] numArr = new int[N];
			int idx = 0;
			for (int i = 0; i < divide; i++) {
				for (int j = 0; j < 4; j++) {
					numArr[idx++] = areaArr[j].getNumber();
					areaArr[j].rotate();
				}
			}
			Arrays.sort(numArr);
			int preNum = -1;
			int answer = 0;
			idx = 1;
			for (int i = N - 1; i >= 0; i--) {
				if (preNum == numArr[i])
					continue;
				if(idx == K) {
					answer = numArr[i];
					break;
				}
				preNum = numArr[i];
				++idx;
			}
			strb.append('#').append(tc).append(' ').append(answer).append('\n');
		} // end of case
		strb.deleteCharAt(strb.length() - 1);
		System.out.println(strb.toString());
	} // end of main
} // end of class
