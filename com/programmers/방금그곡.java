package programmers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class ¹æ±Ý±×°î {

	static final int MINUTE = 60000;
	static Pattern[] patterns;

	public static void main(String[] args) throws Exception {
		String m = "ABCDEFG";
		String[] musicinfos = { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" };
		System.out.println(solution(m, musicinfos));
	}

	private static String solution(String m, String[] musicinfos) throws Exception {
		initPatterns();
		String answer = "(None)";
		int maxTime = -1;
		StringBuilder sb = new StringBuilder();
		String[] strArr;
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date start;
		Date end;
		m = switchWord(m);
		for (String str : musicinfos) {
			strArr = str.split(",");
			start = dateFormat.parse(strArr[0]);
			end = dateFormat.parse(strArr[1]);
			long time = (end.getTime() - start.getTime()) / MINUTE;
			sb.delete(0, sb.length());
			strArr[3] = switchWord(strArr[3]);
			int len = strArr[3].length();
			int[] mn = new int[2];
			mn[0] = (int) (time / len);
			mn[1] = (int) (time % len);
			for(int i = 0; i < (time / len); i++) {
				sb.append(strArr[3]);
			}
			if(mn[1] > 0)
				sb.append(strArr[3].substring(0, mn[1]));
			strArr[3] = sb.toString();
			if(strArr[3].contains(m) && time > maxTime) {
				answer = strArr[2];
				maxTime = (int) time;
			}
		}

		return answer;
	}

	private static String switchWord(String str) {
		str = patterns[0].matcher(str).replaceAll("c");
		str = patterns[1].matcher(str).replaceAll("d");
		str = patterns[2].matcher(str).replaceAll("f");
		str = patterns[3].matcher(str).replaceAll("g");
		return patterns[4].matcher(str).replaceAll("a");
	}

	private static void initPatterns() {
		patterns = new Pattern[5];
		patterns[0] = Pattern.compile("C#");
		patterns[1] = Pattern.compile("D#");
		patterns[2] = Pattern.compile("F#");
		patterns[3] = Pattern.compile("G#");
		patterns[4] = Pattern.compile("A#");
	}
}
