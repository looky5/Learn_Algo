import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210217_boj13460_구슬탈출2 {

    private static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Point{" +
                    y + ", " + x
                    + '}';
        }
    }

    static int N, M, ny, nx;
    static char[][] board;
    static final int[][] dyx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 11;
        board = new char[N][M];
        StringBuilder sb = new StringBuilder();
        Point Red = null, Blue = null;
        for (int i = 0; i < N; i++) {
            sb.setLength(0);
            sb.append(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = sb.charAt(j);
                if (board[i][j] == 'B') {
                    Blue = new Point(i, j);
                } else if (board[i][j] == 'R') {
                    Red = new Point(i, j);
                }
            }
        }
        if (Red == null || Blue == null) {
            System.out.println("Red or Blue is Null!!");
            return;
        }

        for (int d = 0; d < 4; d++) {
            dfs(Red, Blue, 0, d);
        }
        answer = answer > 10 ? -1 : answer;
        System.out.println(answer);
    }

    public static void dfs(Point Red, Point Blue, int times, int dir) {
        if (times >= answer) {
            return;
        }
        Point nextRed = new Point(Red.y, Red.x);
        Point nextBlue = new Point(Blue.y, Blue.x);
        while (true) {
            ny = nextBlue.y + dyx[dir][0];
            nx = nextBlue.x + dyx[dir][1];
            if (checkOverLimit(ny, nx)) break;
            if (board[ny][nx] == 'O') return;
            nextBlue.y = ny;
            nextBlue.x = nx;
        }
        while (true) {
            ny = nextRed.y + dyx[dir][0];
            nx = nextRed.x + dyx[dir][1];
            if (checkOverLimit(ny, nx)) break;
            if (board[ny][nx] == 'O') {
                answer = Math.min(answer, times + 1);
                return;
            }
            nextRed.y = ny;
            nextRed.x = nx;
        }
        if (checkNotMove(Red, nextRed, Blue, nextBlue)) return;
        if (checkOverlap(nextRed, nextBlue)) {
            switch (dir) {
                case 0:
                    if (Red.y < Blue.y) {
                        ++nextBlue.y;
                    } else {
                        ++nextRed.y;
                    }
                    break;
                case 1:
                    if (Red.x > Blue.x) {
                        --nextBlue.x;
                    } else {
                        --nextRed.x;
                    }
                    break;
                case 2:
                    if (Red.y > Blue.y) {
                        --nextBlue.y;
                    } else {
                        --nextRed.y;
                    }
                    break;
                case 3:
                    if (Red.x < Blue.x) {
                        ++nextBlue.x;
                    } else {
                        ++nextRed.x;
                    }
            }
        }
        for (int d = 0; d < 4; d++) {
            dfs(nextRed, nextBlue, times + 1, d);
        }
    }

    public static boolean checkOverlap(Point Red, Point Blue) {
        return Red.y == Blue.y && Red.x == Blue.x;
    }

    public static boolean checkNotMove(Point Red, Point nextRed, Point Blue, Point nextBlue) {
        return Red.y == nextRed.y && Red.x == nextRed.x && Blue.y == nextBlue.y && Blue.x == nextBlue.x;
    }

    public static boolean checkOverLimit(int y, int x) {
        return board[y][x] == '#';
    }
}
