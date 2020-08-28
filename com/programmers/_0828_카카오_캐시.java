package com.programmers;

import java.util.ArrayList;

public class _0828_카카오_캐시 {

	public static void main(String[] args) {
		int cacheSize = 5;
		String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "LA" , "Seoul", "Pangyo",  "NewYork"};
		System.out.println(solution(cacheSize, cities));
	}

	public static int solution(int cacheSize, String[] cities) {
		if (cacheSize == 0) {
			return cities.length * 5;
		}
		int answer = 0;

		ArrayList<String> cacheMemory = new ArrayList<>();
		for (int i = 0; i < cities.length; i++) {
			if (cacheMemory.contains(cities[i].toUpperCase())) {
				answer += 1;
				cacheMemory.remove(cacheMemory.indexOf(cities[i].toUpperCase()));
			} else {
				answer += 5;
				if (cacheMemory.size() >= cacheSize)
					cacheMemory.remove(0);
			}
			cacheMemory.add(cities[i].toUpperCase());
		}

		return answer;
	}
}
