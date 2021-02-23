import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _210217_boj13460_구슬탈출v2 {

    private static class Balls implements Comparable<Balls> {
        int red_y;
        int red_x;
        int blue_y;
        int blue_x;
        int times;

        public Balls() {
        }

        public Balls(int red_y, int red_x, int blue_y, int blue_x, int times) {
            this.red_y = red_y;
            this.red_x = red_x;
            this.blue_y = blue_y;
            this.blue_x = blue_x;
            this.times = times;
        }

        @Override
        public int compareTo(Balls o) {
            return this.times - o.times;
        }
    }

    static int N, M, red_ny, red_nx, blue_ny, blue_nx;
    static char[][] board;
    static boolean[][][][] visited;
    static final int[][] dyx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 11;
        board = new char[N][M];
        visited = new boolean[N][M][N][M];
        StringBuilder sb = new StringBuilder();
        Balls initBalls = new Balls();
        for (int i = 0; i < N; i++) {
            sb.setLength(0);
            sb.append(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = sb.charAt(j);
                if (board[i][j] == 'B') {
                    board[i][j] = '.';
                    initBalls.blue_y = i;
                    initBalls.blue_x = j;
                } else if (board[i][j] == 'R') {
                    board[i][j] = '.';
                    initBalls.red_y = i;
                    initBalls.red_x = j;
                }
            }
        }
        bfs(initBalls);

        answer = answer > 10 ? -1 : answer;
        System.out.println(answer);
    }

    public static void bfs(Balls start) {
        Queue<Balls> pq = new LinkedList<>();
        start.times = 1;
        pq.add(start);
        Balls now = null;
        while (!pq.isEmpty()) {
            now = pq.poll();
            if (now.times >= answer) continue;
            visited[now.red_y][now.red_x][now.blue_y][now.blue_x] = true;
            for (int d = 0; d < 4; d++) {
                blue_ny = now.blue_y;
                blue_nx = now.blue_x;
                while (board[blue_ny][blue_nx] == '.') {
                    blue_ny += dyx[d][0];
                    blue_nx += dyx[d][1];
                }
                if (board[blue_ny][blue_nx] == 'O') continue;
                blue_ny -= dyx[d][0];
                blue_nx -= dyx[d][1];
                red_ny = now.red_y;
                red_nx = now.red_x;
                while (board[red_ny][red_nx] == '.') {
                    red_ny += dyx[d][0];
                    red_nx += dyx[d][1];
                }
                if (board[red_ny][red_nx] == 'O') {
                    answer = now.times;
                    return;
                }
                red_ny -= dyx[d][0];
                red_nx -= dyx[d][1];
                if (checkOverlap(red_ny, red_nx, blue_ny, blue_nx)) {
                    switch (d) {
                        case 0:
                            if (now.red_y < now.blue_y) {
                                ++blue_ny;
                            } else {
                                ++red_ny;
                            }
                            break;
                        case 1:
                            if (now.red_x > now.blue_x) {
                                --blue_nx;
                            } else {
                                --red_nx;
                            }
                            break;
                        case 2:
                            if (now.red_y > now.blue_y) {
                                --blue_ny;
                            } else {
                                --red_ny;
                            }
                            break;
                        case 3:
                            if (now.red_x < now.blue_x) {
                                ++blue_nx;
                            } else {
                                ++red_nx;
                            }
                    }
                }
                if (!visited[red_ny][red_nx][blue_ny][blue_nx]) {
                    pq.add(new Balls(red_ny, red_nx, blue_ny, blue_nx, now.times + 1));
                }
            }
        }
    }

    public static boolean checkOverlap(int red_y, int red_x, int blue_y, int blue_x) {
        return red_y == blue_y && red_x == blue_x;
    }
}
