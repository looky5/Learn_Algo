package com.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _0913_line04 {

    public static void main(String[] args) {
        int[][] maze = {{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}};
        System.out.println(solution(maze));
    }

    //    0 : 위, 1 : 오른쪽, 2 : 아래, 3 : 왼쪽
    static int[] curLeftY = {0, -1, 0, 1};
    static int[] curLeftX = {-1, 0, 1, 0};
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static int solution(int[][] maze) {
        int answer = 0;
        int N = maze.length;
        int[][] map = new int[N + 2][N + 2];
        Arrays.fill(map[0], 1);
        Arrays.fill(map[N + 1], 1);
        for (int i = 1; i < N + 1; i++) {
            map[i][0] = 1;
            map[i][N + 1] = 1;
            System.arraycopy(maze[i - 1], 0, map[i], 1, N);
        }
        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < N + 2; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{1, 1, 1});
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cur[0] == N && cur[1] == N) break;
            answer++;
            int dir = cur[2];
            for (int d = 0; d < 4; d++) {
                int leftY = cur[0] + curLeftY[dir];
                int leftX = cur[1] + curLeftX[dir];
                if (map[leftY][leftX] == 1) {
                    int nextY = cur[0] + dy[dir];
                    int nextX = cur[1] + dx[dir];
                    if (map[nextY][nextX] == 0) {
                        que.add(new int[]{nextY, nextX, dir});
                        break;
                    } else {
                        if(++dir > 3){
                            dir = 0;
                        }
                    }
                } else {
                    if (--dir < 0) {
                        dir = 3;
                    }
                    int nextY = cur[0] + dy[dir];
                    int nextX = cur[1] + dx[dir];
                    que.add(new int[]{nextY, nextX, dir});
                    break;
                }
            }
        }
        return answer;
    }
}
