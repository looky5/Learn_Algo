package com.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _0911_디스크컨트롤러 {

    public static void main(String[] args) {
//        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int[][] jobs = {{1, 9}, {2, 6}, {15, 3}};
//        int[][] jobs = {{0, 10}, {4, 10}, {5, 11}, {15, 2}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int curTime = 0;
        for (int i = 0; i < jobs.length; i++) {
            if (curTime >= jobs[i][0]) {
                pq.offer(jobs[i]);
            } else {
                if (!pq.isEmpty()) {
                    int[] task = pq.poll();
                    curTime += task[1];
                    answer += curTime - task[0];
                } else {
                    curTime = jobs[i][0];
                }
                i--;
            }
        }
        while (!pq.isEmpty()) {
            int[] task = pq.poll();
            curTime += task[1];
            answer += curTime - task[0];
        }
        return answer / jobs.length;
    }
}
