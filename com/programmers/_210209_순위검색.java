package programmers;

import java.util.Arrays;

public class _210209_순위검색 {

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
		String[][] emp_arr = new String[info_len][5];
		for (int i = 0; i < info_len; i++) {
			String[] strArr = info[i].split(" ");
			for (int j = 0; j < 5; j++) {
				emp_arr[i][j] = strArr[j];
			}
		}
		boolean match;
		int cnt;
		for (int i = 0; i < query_len; i++) {
			query[i] = query[i].replaceAll("and ", "");
			String[] strArr = query[i].split(" ");
			cnt = 0;
			for (int j = 0; j < info_len; j++) {
				match = true;
				for (int k = 0; k < 4; k++) {
					if (strArr[k].equals("-"))
						continue;
					if (!strArr[k].equals(emp_arr[j][k])) {
						match = false;
						break;
					}
				}
				if (match && Integer.parseInt(emp_arr[j][4]) >= Integer.parseInt(strArr[4])) {
					++cnt;
				}
			}
			answer[i] = cnt;
		}

		return answer;
	}
}
