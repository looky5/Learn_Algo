import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _210224_boj3197 {

    private static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int R, C;
    static char[][] map;
    static final int[][] dyx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static Queue<Point> que, que_water;
    static boolean[][] visited;
    static Point[] swan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        que = new LinkedList<>();
        que_water = new LinkedList<>();
        swan = new Point[2];
        StringBuilder sb = new StringBuilder();
        int swan_idx = 0;
        for (int i = 0; i < R; i++) {
            sb.setLength(0);
            sb.append(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = sb.charAt(j);
                if (map[i][j] == 'L' || map[i][j] == '.') {
                    if (map[i][j] == 'L') swan[swan_idx++] = new Point(i, j);
                    que_water.offer(new Point(i, j));
                }
            }
        }
        int day = 0;
        while (!checkCanMeet()) {
            checkMelting();
            ++day;
        }
        System.out.println(day);
    }

    public static void checkMelting() {
        int d, ny, nx, size = que_water.size();
        Point now;
        for (int f = 0; f < size; f++) {
            now = que_water.poll();
            for (d = 0; d < 4; d++) {
                ny = now.y + dyx[d][0];
                nx = now.x + dyx[d][1];
                if (!checkAble(ny, nx)) continue;
                if (map[ny][nx] == 'X') {
                    map[ny][nx] = '.';
                    que_water.offer(new Point(ny, nx));
                }
            }
        }
    }

    public static boolean checkCanMeet() {
        Queue<Point> que_next = new LinkedList<>();
        que.add(new Point(swan[0].y, swan[0].x));
        visited[swan[0].y][swan[0].x] = true;
        Point now;
        int ny, nx, d;
        while (!que.isEmpty()) {
            now = que.poll();
            for (d = 0; d < 4; d++) {
                ny = now.y + dyx[d][0];
                nx = now.x + dyx[d][1];
                if (!checkAble(ny, nx) || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                if (map[ny][nx] == 'X') {
                    que_next.offer(new Point(ny, nx));
                    continue;
                }
                if (ny == swan[1].y && nx == swan[1].x) return true;
                que.offer(new Point(ny, nx));
            }
        }
        que = que_next;
        return false;
    }

    public static boolean checkAble(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }
}
