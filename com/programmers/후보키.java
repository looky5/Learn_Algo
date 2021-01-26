package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ÈÄº¸Å° {

	public static void main(String[] args) {
		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		System.out.println(solution(relation));
	}

	private static int solution(String[][] relation) {
		int colLen = relation[0].length;
		int rowLen = relation.length;
		int limit = 1 << colLen;
		ArrayList<Integer> candKey = new ArrayList<>();
		Set<String> checkTool = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		for (int loc = 1; loc < limit; loc++) {
			boolean trigger = true;
			checkTool.clear();
			for (int i = 0; i < rowLen; i++) {
				sb.delete(0, sb.length());
				for (int j = 0; j < colLen; j++) {
					if ((loc & 1 << j) == 0)
						continue;
					sb.append(relation[i][j]);
				}
				if (checkTool.contains(sb.toString())) {
					trigger = false;
					break;
				}
				checkTool.add(sb.toString());
			}
			if (trigger) {
				boolean checkCandKey = true;
				for (int n : candKey) {
					if ((n & loc) == n) {
						checkCandKey = false;
						break;
					}
				}
				if (checkCandKey)
					candKey.add(loc);
			}
		}

		return candKey.size();
	}
}
