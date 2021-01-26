package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class æ–√‡ {

	public static void main(String[] args) {
		String msg = "ABABABABABABABAB";
		System.out.println(Arrays.toString(solution(msg)));
	}

	static Map<String, Integer> dictionary;

	public static int[] solution(String msg) {
		ArrayList<Integer> answer = new ArrayList<>();
		dictionary = new HashMap<String, Integer>();
		initDictionary();
		int len = msg.length();
		StringBuilder sb = new StringBuilder();
		int pre = 0;
		int num = 27;
		int idx = 0;
		Integer n = null;
		for (int i = 0; i < len; i++) {
			sb.append(msg.charAt(i));
			n = dictionary.get(sb.toString());
			if (n == null) {
				answer.add(idx);
				dictionary.put(sb.toString(), num++);
				sb.setLength(0);
				i = pre;
			} else {
				pre = i;
				idx = n;
				continue;
			}
		}
		if (sb.length() > 0) {
			answer.add(idx);
		}

		return toArray(answer);
	}

	private static int[] toArray(ArrayList<Integer> al) {
		int size = al.size();
		int[] answer = new int[size];
		for (int i = 0; i < size; i++) {
			answer[i] = al.get(i);
		}
		return answer;
	}

	private static void initDictionary() {
		StringBuilder strBuilder = new StringBuilder();
		char c = 'A';
		int n = 1;
		for (int i = 0; i < 26; i++) {
			strBuilder.setLength(0);
			strBuilder.append(c++);
			dictionary.put(strBuilder.toString(), n++);
		}
	}
}
