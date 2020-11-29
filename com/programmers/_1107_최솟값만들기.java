package com.programmers;
import java.util.Arrays;

public class _1107_최솟값만들기 {
    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        int j = len - 1;
        for(int i = 0; i < len; i++) {
            answer += A[i] * B[j - i];
        }

        return answer;
    }
}
