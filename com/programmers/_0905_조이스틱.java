package com.programmers;

import java.util.ArrayList;

public class _0905_조이스틱 {

	public static void main(String[] args) {
		String name = "ZAAAAZZZ";
		System.out.println(solution(name));
	}

	public static int solution(String name) {
		int answer = 0;
		int len = name.length();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0; i < len; i++) {
			if(name.charAt(i) != 'A') {
				al.add(i);
			}
		}
		int preIdx = 0;
		while(!al.isEmpty()) {
			int curIdx = 0;
			int delIdx = -1;
			int minOfCur = 987654321;
			for(int i = 0; i < al.size(); i++) {
				int tmp = al.get(i);
				int curMin = Math.min(Math.abs(tmp - preIdx), tmp > preIdx ? len + preIdx - tmp : len + tmp - preIdx);
				if(minOfCur > curMin) {
					minOfCur = curMin;
					curIdx = tmp;
					delIdx = i;
				}
			}
			al.remove(delIdx);
			answer += minOfCur;
			answer += Math.min(name.charAt(curIdx) - 'A', 'A' - (name.charAt(curIdx) - 26));
			preIdx = curIdx;
		}

		return answer;
	}
}
