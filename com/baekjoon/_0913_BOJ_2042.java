package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _0913_BOJ_2042 {

    static int N, M, K;
    static int[] arr;
    static long[] SegmentTree;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        SegmentTree = new long[N * 4];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(0, N - 1, 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 2) {
                sb.append(sum(0, N - 1, Integer.parseInt(st.nextToken()) - 1,
                        Integer.parseInt(st.nextToken()) - 1, 1)).append('\n');
            } else {
                int index = Integer.parseInt(st.nextToken()) - 1;
                int num = Integer.parseInt(st.nextToken());
                int dif = num - arr[index];
                arr[index] = num;
                update(0, N - 1, 1, index, dif);
            }
        }
        if (sb.length() != 0)
            sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private static long init(int left, int right, int node) {
        if (left == right) {
            SegmentTree[node] = arr[left];
            return SegmentTree[node];
        }
        int mid = (left + right) / 2;

        SegmentTree[node] += init(left, mid, node * 2);
        SegmentTree[node] += init(mid + 1, right, node * 2 + 1);
        return SegmentTree[node];
    }

    private static long sum(int left, int right, int start, int end, int node) {
        if (start > right || end < left) {
            return 0;
        }
        if (left >= start && right <= end) {
            return SegmentTree[node];
        }
        int mid = (left + right) / 2;
        return sum(left, mid, start, end, node * 2)
                + sum(mid + 1, right, start, end, node * 2 + 1);
    }

    private static void update(int left, int right, int node, int index, int dif) {
        if (index < left || index > right) {
            return;
        }
        SegmentTree[node] += dif * 1L;
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        update(left, mid, node * 2, index, dif);
        update(mid + 1, right, node * 2 + 1, index, dif);
    }
}
