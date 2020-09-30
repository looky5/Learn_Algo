import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class location {
    int y;
    int x;
    int distance;
    boolean chance;

    public location(int y, int x, int distance, boolean chance) {
        this.y = y;
        this.x = x;
        this.distance = distance;
        this.chance = chance;
    }
}

public class _0928_BOJ_2206 {

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static final int oo = (int) 2e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int answer = bfs();
        System.out.println(answer == oo ? -1 : answer);

    }

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    private static int bfs() {
        Queue<location> que = new LinkedList<>();
        que.add(new location(0, 0, 1, true));
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        while (!que.isEmpty()) {
            location now = que.poll();
            if(now.y == N - 1 && now.x == M - 1) {
                return now.distance;
            }
            for(int d = 0; d < 4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(map[ny][nx] == 1) {
                    if(!visited[ny][nx][1] && now.chance) {
                        visited[ny][nx][1] = true;
                        que.add(new location(ny, nx, now.distance + 1, false));
                    }
                } else {
                    int n = now.chance ? 1 : 0;
                    if(!visited[ny][nx][n]) {
                        visited[ny][nx][n] = true;
                        que.add(new location(ny, nx, now.distance + 1, now.chance));
                    }
                }
            }
        }

        return oo;
    }
}
