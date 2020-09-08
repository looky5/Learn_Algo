package com.programmers;

public class _0830_카카오_문자열압축 {

	public static void main(String[] args) {
//		String s = "aabbaccc";
//		String s = "ababcdcdababcdcd";
//		String s = "abcabcabcabcdededededede";
		String s = "aaaaaaaaaaaaaaaaaaa";
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
        int answer = 987654321;
        if(s.length() < 2) {
        	return s.length();
        }
        for(int i = 1; i <= s.length() / 2; i++) { // i : split size
        	String s1 = s.substring(0, i);
        	int count = s.length();
        	int num = 1;
        	boolean check = false;
        	for(int j = i; j + i <= s.length(); j += i) {
        		String s2 = s.substring(j, j + i);
        		if(s1.equals(s2)) {
        			num++;
        			count -= i;
        			check = true;
        			if(j + 2 * i > s.length()) {
        				count += (int)Math.log10(num) + 1;
        				break;
        			}
        		} else {
        			if(check) {
        				count += (int)Math.log10(num) + 1;
        				num = 1;
        				check = false;
        			}
        			s1 = s2;
        		}
        	}
        	answer = Math.min(answer, count);
        }
        
        return answer;
    }
}
