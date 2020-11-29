package com.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1018_BOJ_4485 {

    private static class point implements Comparable<point> {
        int y;
        int x;
        int sum;

        public point(int y, int x, int sum) {
            this.y = y;
            this.x = x;
            this.sum = sum;
        }

        @Override
        public int compareTo(point o) {
            return this.sum - o.sum;
        }
    }

    static int[][] map;
    static boolean[][] visited;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static final int oo = (int) 2e9;
    static int N;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int tc = 0;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            map = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = oo;
            PriorityQueue<point> pq = new PriorityQueue<>();
            pq.add(new point(0, 0, map[0][0]));
            visited[0][0] = true;
            while (!pq.isEmpty()) {
                point now = pq.poll();
                for(int d = 0; d < 4; d++) {
                    int ny = now.y + dy[d];
                    int nx = now.x + dx[d];
                    if(!isOk(ny, nx) || visited[ny][nx] || now.sum + map[ny][nx] > answer)
                        continue;
                    if(ny == N - 1 && nx == N - 1) {
                        answer = Math.min(answer, now.sum + map[ny][nx]);
                        continue;
                    }
                    pq.add(new point(ny, nx, now.sum + map[ny][nx]));
                    visited[ny][nx] = true;
                }
            }
            sb.append("Problem ").append(++tc).append(": ").append(answer).append('\n');
        }
        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.toString());
    }

    private static boolean isOk(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}
