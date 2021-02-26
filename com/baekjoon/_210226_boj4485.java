import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _210226_boj4485 {

    private static class Point {
        int y;
        int x;
        int price;

        public Point(int y, int x, int price) {
            this.y = y;
            this.x = x;
            this.price = price;
        }

    }

    static int N, min;
    static PriorityQueue<Point> pq;
    static int[][] map;
    static boolean[][] visited;
    static final int[][] dyx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        map = new int[125][125];
        visited = new boolean[125][125];
        pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.price - o2.price;
            }
        });
        StringBuilder sb = new StringBuilder();
        int d, ny, nx, time = 0;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ++time;
            min = INF;
            pq.clear();
            initVisited();
            pq.offer(new Point(0, 0, map[0][0]));
            visited[0][0] = true;
            Point now;
            while (!pq.isEmpty()) {
                now = pq.poll();
                if (now.y == N - 1 && now.x == N - 1) {
                    min = now.price;
                    break;
                }
                for (d = 0; d < 4; d++) {
                    ny = now.y + dyx[d][0];
                    nx = now.x + dyx[d][1];
                    if (!checkAble(ny, nx) || visited[ny][nx]) continue;
                    pq.offer(new Point(ny, nx, now.price + map[ny][nx]));
                    visited[ny][nx] = true;
                }
            }
            sb.append("Problem ").append(time).append(": ").append(min).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        br.close();
    }

    public static void initVisited() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    public static boolean checkAble(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}
