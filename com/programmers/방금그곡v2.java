package programmers;

public class ¹æ±Ý±×°îv2 {

	public static void main(String[] args) throws Exception {
		String m = "ABCDEFG";
		String[] musicinfos = { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" };
		System.out.println(solution(m, musicinfos));
	}

	private static String solution(String m, String[] musicinfos) throws Exception {
		StringBuilder answer = new StringBuilder("(None)");
		m = formatString(m);
		StringBuilder sb = new StringBuilder();
		int len = musicinfos.length;
		String[] info;
		int start, end, playing_time, sheet_len;
		int longest_time = 0;
		for (int i = 0; i < len; i++) {
			info = musicinfos[i].split(",");
			start = Integer.parseInt(info[0].substring(0, 2)) * 60 + Integer.parseInt(info[0].substring(3));
			end = Integer.parseInt(info[1].substring(0, 2)) * 60 + Integer.parseInt(info[1].substring(3));
			playing_time = end - start;
			if (playing_time <= longest_time)
				continue;
			sb.setLength(0);
			info[3] = formatString(info[3]);
			sheet_len = info[3].length();
			for (int j = 0; j < playing_time; j++) {
				sb.append(info[3].charAt(j % sheet_len));
			}
			if (sb.toString().indexOf(m) > -1) {
				answer.setLength(0);
				answer.append(info[2]);
				longest_time = playing_time;
			}
		}

		return answer.toString();
	}

	static StringBuilder strb = new StringBuilder();

	private static String formatString(String S) {
		strb.setLength(0);
		int len = S.length();
		int strb_len = 0;
		char ch = 0, prev_ch = 0;
		for (int i = 0; i < len; i++) {
			ch = S.charAt(i);
			if (ch == '#') {
				strb.setCharAt(strb_len - 1, (char) (prev_ch + 32));
			} else {
				strb.append(ch);
				++strb_len;
				prev_ch = ch;
			}
		}
		return strb.toString();
	}
}
