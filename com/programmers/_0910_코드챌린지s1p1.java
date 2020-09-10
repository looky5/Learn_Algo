package com.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _0910_코드챌린지s1p1 {

	public static void main(String[] args) {
		int[] numbers = {0, 100, 99, 54};
		System.out.println(Arrays.toString(solution(numbers)));
	}
	
	public static int[] solution(int[] numbers) {
		Set<Integer> set = new HashSet<>();
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 1; i++) {
        	int preJ = 999;
        	for(int j = i + 1; j < numbers.length; j++) {
        		if(preJ == j) continue;
        		set.add(numbers[i] + numbers[j]);
        	}
        }
        int[] answer = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        for(int i = 0; i < set.size(); i++) {
        	answer[i] = it.next();
        }
        Arrays.sort(answer);
        return answer;
    }
}
