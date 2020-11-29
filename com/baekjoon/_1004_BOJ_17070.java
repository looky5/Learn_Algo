package com.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class point {
    int y;
    int x;
    int position;

    public point(int y, int x, int position) {
        this.y = y;
        this.x = x;
        this.position = position;
    }
}

public class _1004_BOJ_17070 {

    static int[][] dy = {{0, 1}, {1, 1}, {0, 1, 1}};
    static int[][] dx = {{1, 1}, {0, 1}, {1, 0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        Queue<point> que = new LinkedList<>();
        que.add(new point(0, 1, 0));
        while (!que.isEmpty()) {
            point now = que.poll();
            if (now.y == N - 1 && now.x == N - 1) {
                answer++;
                continue;
            }
            int r = now.position == 2 ? 3 : 2;
            for (int d = 0; d < r; d++) {
                int ddy = dy[now.position][d];
                int ddx = dx[now.position][d];
                int ny = now.y + ddy;
                int nx = now.x + ddx;
                if (ddy == 1 && ddx == 1) {
                    if (ny < N && nx < N && map[ny][nx] != 1 && map[ny - 1][nx] != 1 && map[ny][nx - 1] != 1) {
                        que.add(new point(ny, nx, 2));
                    }
                } else {
                    if (ddy == 0 && ddx == 1) {
                        if (nx < N && map[ny][nx] != 1) {
                            que.add(new point(ny, nx, 0));
                        }
                    } else {
                        if (ny < N && map[ny][nx] != 1) {
                            que.add(new point(ny, nx, 1));
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
