package com.programmers;
public class _1021_숫자의표현 {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 1;
        int len = n % 2 == 0 ? n / 2 : n / 2 + 1;

        for(int i = 1; i < len; i++) {
            int sum = i;
            for(int j = i + 1; j <= len; j++) {
                sum += j;
                if(sum > n) break;
                if(sum == n) {
                    answer++;
                    break;
                }
            }
        }


        return answer;
    }
}
