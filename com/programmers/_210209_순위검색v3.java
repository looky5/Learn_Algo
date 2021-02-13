package programmers;

import java.util.Arrays;

public class _210209_순위검색v3 {

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		System.out.println(Arrays.toString(solution(info, query)));
	}

	static int[][][][] group = new int[4][3][3][3];

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[] {};
		int info_len = info.length, query_len = query.length;
		for (int i = 0; i < info_len; i++) {
			String[] tmp = info[i].split(" ");
			
		}

		return answer;
	}
}
