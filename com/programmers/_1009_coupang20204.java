package com.programmers;

import java.util.*;

public class _1009_coupang20204 {

	public static void main(String[] args) {
//        String depar = "SEOUL";
//        String hub = "DAEGU";
//        String dest = "YEOSU";
//        String[][] roads = {{"ULSAN", "BUSAN"}, {"DAEJEON", "ULSAN"}, {"DAEJEON", "GWANGJU"},
//                {"SEOUL", "DAEJEON"}, {"SEOUL", "ULSAN"}, {"DAEJEON", "DAEGU"},
//                {"GWANGJU", "BUSAN"}, {"DAEGU", "GWANGJU"}, {"DAEGU", "BUSAN"},
//                {"ULSAN", "DAEGU"}, {"GWANGJU", "YEOSU"}, {"BUSAN", "YEOSU"}};
		String depar = "ULSAN";
		String hub = "DAEGU";
		String dest = "YEOSU";
		String[][] roads = { { "SEOUL", "DAEJEON" }, { "ULSAN", "BUSAN" }, { "DAEJEON", "ULSAN" },
				{ "DAEJEON", "GWANGJU" }, { "SEOUL", "ULSAN" }, { "DAEJEON", "BUSAN" }, { "GWANGJU", "BUSAN" } };
		System.out.println(solution(depar, hub, dest, roads));
	}

	static Map<String, ArrayList<String>> map;

	private static int solution(String depar, String hub, String dest, String[][] roads) {
		int answer = 0;

		map = new HashMap<>();

		for (int i = 0; i < roads.length; i++) {
			if (!map.containsKey(roads[i][0])) {
				map.put(roads[i][0], new ArrayList<String>());
			}
			map.get(roads[i][0]).add(roads[i][1]);
		}
		answer += bfs(depar, hub);
		answer *= bfs(hub, dest);

		return answer;
	}

	private static int bfs(String start, String end) {
		int count = 0;
		Queue<String> que = new LinkedList<>();
		que.add(start);
		while (!que.isEmpty()) {
			String now = que.poll();
			if (now.equals(end)) {
				count++;
				continue;
			}
			if (map.get(now) == null)
				continue;
			for (String s : map.get(now)) {
				que.add(s);
			}
		}
		return count;
	}
}
