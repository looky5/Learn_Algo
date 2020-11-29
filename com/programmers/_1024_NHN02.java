package com.programmers;
public class _1024_NHN02 {
    public static void main(String[] args) {
        int day = 2;
        int width = 6;
        int[][] blocks = {{6, 2, 11, 0, 3, 5}, {6, 3, 0, 9, 0, 5}};
        solution(day, width, blocks);
    }

    private static void solution(int day, int width, int[][] blocks) {
        int today = 0;
        int[] map = new int[width];
        int cement = 0;

        while (today < day) {
            map[0] += blocks[today][0];
            map[width - 1] += blocks[today][width - 1];
            for(int i = 1; i < width - 1; i++) {
                map[i] += blocks[today][i];
            }
            int[][] max = new int[width][2];
            max[0][0] = map[0];
            max[width - 1][1] = map[width - 1];
            for (int i = 1; i < width - 1; i++) {
                max[i][0] = Math.max(max[i - 1][0], map[i - 1]);
            }
            for (int i = width - 2; i >= 1; i--) {
                max[i][1] = Math.max(max[i + 1][1], map[i + 1]);
            }
            for (int i = 1; i < width - 1; i++) {
                if(max[i][0] > map[i] && max[i][1] > map[i]) {
                    int pour = Math.min(max[i][0], max[i][1]) - map[i];
                    map[i] += pour;
                    cement += pour;
                }
            }
            today++;
        }
        System.out.println(cement);
    }
}
