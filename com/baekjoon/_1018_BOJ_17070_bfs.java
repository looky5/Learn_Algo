import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1018_BOJ_17070_bfs {

    private static class point {
        int y;
        int x;
        int position;

        public point(int y, int x, int position) {
            this.y = y;
            this.x = x;
            this.position = position;
        }
    }

    static int[] dy = {0, 1, 1};
    static int[] dx = {1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
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
        que.add(new point(0, 1, 0)); // 가로 0, 세로 1, 대각 2
        while (!que.isEmpty()) {
            point now = que.poll();
            for (int d = 0; d < 3; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];

                if((now.position == 0 && d == 1) || (now.position == 1 && d == 0)) continue;
                if (ny >= N || nx >= N || map[ny][nx] == 1) continue;
                if (d == 2 && (map[ny - 1][nx] == 1 || map[ny][nx - 1] == 1)) continue;
                if (ny == N - 1 && nx == N - 1) {
                    answer++;
                    break;
                }
                que.add(new point(ny, nx, d));
            }
        }
        System.out.println(answer);
    }
}
