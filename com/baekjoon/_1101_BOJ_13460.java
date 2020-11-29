package com.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1101_BOJ_13460 {

    private static class point {
        int[] red;
        int[] blue;
        int dir;
        int times;

        public point(int[] red, int[] blue, int dir, int times) {
            this.red = red;
            this.blue = blue;
            this.dir = dir;
            this.times = times;
        }

        @Override
        public String toString() {
            return "point{" +
                    "red=" + Arrays.toString(red) +
                    ", blue=" + Arrays.toString(blue) +
                    ", dir=" + dir +
                    ", times=" + times +
                    '}';
        }
    }

    static int N, M, answer;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int[] red = null;
        int[] blue = null;
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == 'R') {
                    map[i][j] = '.';
                    red = new int[]{i, j};
                } else if (map[i][j] == 'B') {
                    map[i][j] = '.';
                    blue = new int[]{i, j};
                }
            }
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println("red: " + Arrays.toString(red) + " | blue: " + Arrays.toString(blue));
        answer = 11;
        solution(red, blue);
        System.out.println(answer > 10 ? -1 : answer);
    }

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static final int[] reverse = {2, 3, 0, 1};

    private static void solution(int[] red, int[] blue) {
        Queue<point> que = new LinkedList<>();
        for (int d = 0; d < 4; d++) {
            int ny = red[0] + dy[d];
            int nx = red[1] + dx[d];
            if (!isOk(ny, nx)) continue;
            if (map[ny][nx] != '#' && !(ny == blue[0] && nx == blue[1])) {
                que.add(new point(red, blue, d, 1));
                continue;
            }
            int by = blue[0] + dy[d];
            int bx = blue[1] + dx[d];
            if (!isOk(by, bx)) continue;
            if (map[by][bx] == '.') {
                que.add(new point(red, blue, d, 1));
            }
        }
//        Iterator it = que.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next().toString());
//        }
        while (!que.isEmpty()) {
            point now = que.poll();
//            System.out.println("red: " + Arrays.toString(now.red));
//            System.out.println("blue: " + Arrays.toString(now.blue));
//            System.out.println("direction: " + now.dir);
            if (now.times >= answer) return;
            boolean trigger1 = false;
            boolean trigger2 = false;
            int[] nextRed = new int[]{now.red[0], now.red[1]};
            int[] nextBlue = new int[]{now.blue[0], now.blue[1]};
            if (whichFirst(now.dir, now.red, now.blue) == 1) { // red 먼저 이동
//                System.out.println("red 먼저 이동");
//                System.out.println("--------------------------------");
                // red 이동
                int ry = now.red[0] + dy[now.dir];
                int rx = now.red[1] + dx[now.dir];
                if (isOk(ry, rx) && map[ry][rx] != '#') {
                    while (map[ry][rx] == '.') {
                        ry += dy[now.dir];
                        rx += dx[now.dir];
                    }
                    if (map[ry][rx] == 'O') {
                        trigger2 = true;
                    }
                    nextRed[0] = ry - dy[now.dir];
                    nextRed[1] = rx - dx[now.dir];
                    trigger1 = true;
                }
                // blue 이동
                int by = now.blue[0] + dy[now.dir];
                int bx = now.blue[1] + dx[now.dir];
                if (isOk(by, bx) && map[by][bx] != '#') {
                    while (map[by][bx] == '.') {
                        by += dy[now.dir];
                        bx += dx[now.dir];
                    }
                    if (map[by][bx] == 'O') {
                        continue;
                    }
                    nextBlue[0] = by - dy[now.dir];
                    nextBlue[1] = bx - dx[now.dir];
                    if (nextBlue[0] == nextRed[0] && nextBlue[1] == nextRed[1]) {
                        nextBlue[0] -= dy[now.dir];
                        nextBlue[1] -= dx[now.dir];
                    }
                    trigger1 = true;
                }
                if (trigger2) {
                    answer = Math.min(now.times, answer);
                    continue;
                }
            } else { // blue 먼저 이동
//                System.out.println("blue 먼저 이동");
//                System.out.println("--------------------------------");
                // blue 이동
                int by = now.blue[0] + dy[now.dir];
                int bx = now.blue[1] + dx[now.dir];
                if (isOk(by, bx) && map[by][bx] != '#') {
                    while (map[by][bx] == '.') {
                        by += dy[now.dir];
                        bx += dx[now.dir];
                    }
                    if (map[by][bx] == 'O') {
                        continue;
                    }
                    nextBlue[0] = by - dy[now.dir];
                    nextBlue[1] = bx - dx[now.dir];
                    trigger1 = true;
                }
                // red 이동
                int ry = now.red[0] + dy[now.dir];
                int rx = now.red[1] + dx[now.dir];
                if (isOk(ry, rx) && map[ry][rx] != '#') {
                    while (map[ry][rx] == '.') {
                        ry += dy[now.dir];
                        rx += dx[now.dir];
                    }
                    if (map[ry][rx] == 'O') {
                        answer = Math.min(now.times, answer);
                        continue;
                    }
                    nextRed[0] = ry - dy[now.dir];
                    nextRed[1] = rx - dx[now.dir];
                    if (nextRed[0] == nextBlue[0] && nextRed[1] == nextBlue[1]) {
                        nextRed[0] -= dy[now.dir];
                        nextRed[1] -= dx[now.dir];
                    }
                    trigger1 = true;
                }
            }
            if (trigger1) {
                for (int d = 0; d < 4; d++) {
                    if (d == reverse[now.dir] || d == now.dir) continue;
                    int ny = nextRed[0] + dy[d];
                    int nx = nextRed[1] + dx[d];
                    if (!isOk(ny, nx)) continue;
                    if (map[ny][nx] != '#' && !(ny == nextBlue[0] && nx == nextBlue[1])) {
                        que.add(new point(nextRed, nextBlue, d, now.times + 1));
                        continue;
                    }
                    int by = nextBlue[0] + dy[d];
                    int bx = nextBlue[1] + dx[d];
                    if (!isOk(by, bx)) continue;
                    if (map[by][bx] == '.') {
                        que.add(new point(nextRed, nextBlue, d, now.times + 1));
                    }
                }
            }
        }
    }

    private static int whichFirst(int direction, int[] red, int[] blue) { // 1이면 R, 2면 B
        int result = 1;

        switch (direction) {
            case 0:
                if (red[0] > blue[0]) result = 2;
                break;
            case 1:
                if (red[1] < blue[1]) result = 2;
                break;
            case 2:
                if (red[0] < blue[0]) result = 2;
                break;
            case 3:
                if (red[1] > blue[1]) result = 2;
        }

        return result;
    }

    private static boolean isOk(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
