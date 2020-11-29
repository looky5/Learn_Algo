package com.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1018_BOJ_16236 {

    private static class Shark {
        int size;
        int exp;

        public Shark(int size, int exp) {
            this.size = size;
            this.exp = exp;
        }
    }

    private static class point {
        int y;
        int x;
        int dist;

        public point(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    static int[][] map;
    static Shark baby;
    static int N;
    static final int oo = (int) 2e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        point start = null;
        int fishes = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) start = new point(i, j, 0);
                if (map[i][j] > 0 && map[i][j] < 7) fishes++;
            }
        }
        if (fishes == 0) {
            System.out.println(0);
        } else if (fishes == 1) {
            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > 0 && map[i][j] < 7) {
                        result = Math.abs(start.y - i) + Math.abs(start.x - j);
                        i = N;
                        break;
                    }
                }
            }
            System.out.println(result);
        } else {
            int result = 0; // Distance Sum
            baby = new Shark(2, 0);
            while (true) {
                point current = bfs(start.y, start.x);
                if (current.dist == oo) break;
                result += current.dist;
                start.y = current.y;
                start.x = current.x;
            }
            System.out.println(result);
        }
    }

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, -1, 0, 1};

    private static point bfs(int y, int x) {
        boolean[][] visited = new boolean[N][N];
        Queue<point> que = new LinkedList<>();
        que.add(new point(y, x, 0));
        visited[y][x] = true;
        point min = new point(-1, -1, oo);

        while (!que.isEmpty()) {
            point now = que.poll();
            if (now.dist > min.dist) continue;
            for (int d = 0; d < 4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] > baby.size
                        || visited[ny][nx] || min.dist < now.dist + 1)
                    continue;
                if (map[ny][nx] > 0 && map[ny][nx] < baby.size) {
                    if (min.dist > now.dist + 1) {
                        min.y = ny;
                        min.x = nx;
                        min.dist = now.dist + 1;
                    } else {
                        if (ny < min.y) {
                            min.y = ny;
                            min.x = nx;
                        } else if (ny == min.y) {
                            if (nx < min.x) {
                                min.x = nx;
                            }
                        }
                    }
                    continue;
                }
                que.add(new point(ny, nx, now.dist + 1));
                visited[ny][nx] = true;
            }
        }
        if (min.dist == oo) {
            return min;
        }
        if (++baby.exp == baby.size) {
            baby.exp = 0;
            baby.size++;
        }
        map[y][x] = 0;
        map[min.y][min.x] = 9;
        return min;
    }
}
