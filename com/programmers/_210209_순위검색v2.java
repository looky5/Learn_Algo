package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _210209_순위검색v2 {

	static Map<String, ArrayList<Integer>> map;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> al;
	static String[] strArr;

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		System.out.println(Arrays.toString(solution(info, query)));
	}

	public static int[] solution(String[] info, String[] query) {
		int info_len = info.length;
		int query_len = query.length;
		int[] answer = new int[query_len];
		map = new HashMap<>();

		for (int i = 0; i < info_len; i++) {
			strArr = info[i].split(" ");
			makeDB(0, 0, 0);
		}
		int map_size = map.size();
		for (String s : map.keySet()) {
			al = map.get(s);
			al.sort(Comparator.naturalOrder());
		}
		String[] tmp;
		for (int i = 0; i < query_len; i++) {
			tmp = query[i].split(" ");
			sb.setLength(0);
			for (int j = 0; j < 7; j += 2) {
				sb.append(tmp[j]);
			}
			answer[i] = findCnt(sb.toString(), Integer.parseInt(tmp[7]));
		}

		return answer;
	}

	public static int findCnt(String str, int score) {
		al = map.get(str);
		if (al == null)
			return 0;
		int size = al.size();
		int left = 0, right = size - 1;
		int mid = 0;

		if (score > al.get(right))
			return 0;
		if (score < al.get(0))
			return size;

		while (left < right) {
			mid = (left + right) / 2;
			if (score <= al.get(mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return size - right;
	}

	public static void makeDB(int flag, int start, int count) {
		if (count == 4) {
			sb.setLength(0);
			for (int i = 0; i < 4; i++) {
				if ((flag & 1 << i) == 0) {
					sb.append(strArr[i]);
				} else {
					sb.append('-');
				}
			}
			if (map.containsKey(sb.toString())) {
				map.get(sb.toString()).add(Integer.parseInt(strArr[4]));
			} else {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(Integer.parseInt(strArr[4]));
				map.put(sb.toString(), al);
			}
			return;
		}
		for (int i = start; i < 4; i++) {
			makeDB(flag | 1 << i, i + 1, count + 1);
			makeDB(flag, i + 1, count + 1);
		}
	}

}
