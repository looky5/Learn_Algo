package com.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _1002_BOJ_16637 {

    static int N;
    static char[] arr;
    static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        arr = str.toCharArray();
        max = Long.MIN_VALUE;
        dfs(0, 0, 0);
        System.out.println(max);
    }

    private static void dfs(int start, int count, int flag) {
        StringBuilder sb = new StringBuilder();
        Queue<Long> nQue = new LinkedList<>();
        Queue<Character> cQue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0 && i < N - 2 && (flag & 1 << i) != 0) {
                nQue.add(calc(arr[i] - '0', arr[i + 1], arr[i + 2] - '0'));
                i += 2;
            } else {
                if(arr[i] >= '0' && arr[i] <= '9') {
                    nQue.add(1L * (arr[i] - '0'));
                } else {
                    cQue.add(arr[i]);
                }
            }
        }
//        System.out.println(Arrays.toString(nQue.stream().toArray()));
//        System.out.println(Arrays.toString(cQue.stream().toArray()));
        long result = nQue.poll();
//        sb.append(result).append(' ');
        while (!nQue.isEmpty()) {
            result = calc(result, cQue.poll(), nQue.poll());
//            sb.append(result).append(' ');
        }
//        System.out.println(sb.toString());
        max = Math.max(max, result);
        if (count >= (N / 2 + 1) / 2) {
            return;
        }
        for (int j = start; j < N - 2; j += 2) {
            if ((flag & 1 << j) == 0) {
                dfs(j + 4, count + 1, flag | 1 << j);
            }
        }
    }

    private static long calc(long a, char c, long b) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 0;
    }
}
