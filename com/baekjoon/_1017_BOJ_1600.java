package com.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1017_BOJ_1600 {

    private static class point {
        int y;
        int x;
        int horseMode;
        int moveCnt;

        public point(int y, int x, int horseMode, int moveCnt) {
            this.y = y;
            this.x = x;
            this.horseMode = horseMode;
            this.moveCnt = moveCnt;
        }
    }

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static final int[] horseY = {-1, -2, -2, -1, 1, 2, 2, 1};
    static final int[] horseX = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] map = new int[H][W];
        boolean[][][] visited = new boolean[H][W][31];

        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<point> que = new LinkedList<>();
        que.add(new point(0, 0, K, 0));
        for(int p = 0; p < 31; p++) {
            visited[0][0][p] = true;
        }
        while(!que.isEmpty()) {
            point now = que.poll();
            if(now.y == H - 1 && now.x == W - 1) {
                System.out.println(now.moveCnt);
                return;
            }
            if(now.horseMode > 0) {
                for (int d = 0; d < 8; d++) {
                    int ny = now.y + horseY[d];
                    int nx = now.x + horseX[d];
                    if (ny < 0 || ny >= H || nx < 0 || nx >= W || map[ny][nx] == 1 || visited[ny][nx][now.horseMode - 1])
                        continue;
                    que.add(new point(ny, nx, now.horseMode - 1, now.moveCnt + 1));
                    visited[ny][nx][now.horseMode - 1] = true;
                }
            }
            for(int d = 0; d < 4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];
                if (ny < 0 || ny >= H || nx < 0 || nx >= W || map[ny][nx] == 1 || visited[ny][nx][now.horseMode])
                    continue;
                que.add(new point(ny, nx, now.horseMode, now.moveCnt + 1));
                visited[ny][nx][now.horseMode] = true;
            }
        }
        System.out.println(-1);
    }
}
