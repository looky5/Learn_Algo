package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class _210209_메뉴리뉴얼 {

	public static void main(String[] args) {
//		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
//		String[] orders = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
		String[] orders = { "XYZ", "XWY", "WXA" };
		int[] course = { 2, 3, 4 };
		System.out.println(Arrays.toString(solution(orders, course)));
	}

	static boolean[] valid_course;
	static int[] maxCount;
	static Map<String, Integer>[] map;
	static char[] charArr;
	static int max_course;

	public static String[] solution(String[] orders, int[] course) {
		ArrayList<String> answer = new ArrayList<>();
		valid_course = new boolean[11];
		int orders_len = orders.length;
		int course_len = course.length;
		max_course = course[course_len - 1];
		maxCount = new int[11];
		map = new HashMap[11];
		for (int i = 2; i < 11; ++i) {
			map[i] = new HashMap<>();
		}
		for (int i = 0; i < course_len; i++) {
			valid_course[course[i]] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < orders_len; ++i) {
			sb.setLength(0);
			charArr = orders[i].toCharArray();
			Arrays.sort(charArr);
			Comb(0, 0, charArr.length);
		}
		for (int i = 0; i < course_len; i++) {
			for (String s : map[course[i]].keySet()) {
				Integer n = map[course[i]].get(s);
				if (n < 2)
					continue;
				else if (n > maxCount[course[i]]) {
					maxCount[course[i]] = n;
				}
			}
		}
		for (int i = 0; i < course_len; i++) {
			if (maxCount[course[i]] < 2)
				continue;
			for (String s : map[course[i]].keySet()) {
				if (map[course[i]].get(s) == maxCount[course[i]]) {
					answer.add(s);
				}
			}
		}
		Collections.sort(answer);
		sb.setLength(0);

		return answer.toArray(new String[] {});
	}

	static StringBuilder sb2 = new StringBuilder();

	private static void Comb(int count, int start, int arr_len) {
		if (count > arr_len || count > max_course) {
			return;
		}
		if (count > 1 && valid_course[count]) {
			Integer a = map[count].get(sb2.toString());
			if (a == null) {
				map[count].put(sb2.toString(), 1);
			} else {
				map[count].put(sb2.toString(), a + 1);
			}
		}
		for (int i = start; i < arr_len; ++i) {
			sb2.append(charArr[i]);
			Comb(count + 1, i + 1, arr_len);
			sb2.deleteCharAt(count);
		}
	}
}
