package com.programmers;
public class _1110_군수열 {
    public static void main(String[] args) {
        long k = 50000000000L;
        System.out.println(solution(k));
    }

    private static long solution(long k) {
        long answer = 0;

        // (1), (1, 2), (1, 2, 3), (1, 2, 3, 4), (1, 2, 3, 4, 5), (1, 2, 3, 4, 5, 6), ...
        // 1, 2, 4, 7, 11, 16
        long n = 1;
        long numCnt1 = 0;
        long numCnt2 = 0;
        int repeatCnt = 0;
        while(true) {
            repeatCnt++;
            numCnt1 = ((n - 1) * n / 2) + 1; // n번째 항의 1의 위치
            numCnt2 = (n * (n + 1) / 2) + 1; // n + 1번째 항의 1의 위치
            if(numCnt2 > k) break;
            n++;
        }
        System.out.println(numCnt1);
        System.out.println(numCnt2);
        System.out.println(repeatCnt);
        answer = k - numCnt1 + 1;

        return answer;
    }
}
