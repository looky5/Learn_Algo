package com.programmers;

public class _0907_스킬트리 {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA", "AKL" };
		System.out.println(solution(skill, skill_trees));
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		for (String str : skill_trees) {
			int curSkill = -1;
			boolean flag = false;
			boolean possible = true;
			for (int i = str.length() - 1; i >= 0; i--) {
				int curIdx = skill.indexOf(str.charAt(i));
				if (curIdx < 0)
					continue;
				if (!flag) {
					curSkill = curIdx;
					flag = true;
				} else {
					if (curIdx == curSkill - 1) {
						curSkill = curIdx;
					} else {
						possible = false;
						break;
					}
				}
			}
			if (possible && curSkill <= 0) {
				answer++;
			}
		}

		return answer;
	}
}
