package com.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _1031_BOJ_9095 {

    static ArrayList<Integer> al;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            al = new ArrayList<>();
            count = 0;
            int n = Integer.parseInt(br.readLine());
            solution(n, 0);
            sb.append(count).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private static void solution(int n, int sum) {
        if(sum == n) {
            count++;
            return;
        }
        else {
            for(int i = 1; i <= 3; i++) {
                if(sum + i > n) return;
                solution(n, sum + i);
            }
        }
    }
}
