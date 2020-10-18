import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1018_BOJ_14500 {

    static int[][] map;
    static int N, M, answer;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        check = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                check[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                check[i][j] = false;
                anotherOne(i, j, map[i][j]);
            }
        }
        System.out.println(answer);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    private static void anotherOne (int y, int x, int sum) {
        int init = sum;
        for(int i = 0; i < 4; i++) {
            boolean trigger = true;
            sum = init;
            for(int d = 0; d < 4; d++) {
                if(d == i) continue;
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(!isOk(ny, nx)) {
                    trigger = false;
                    break;
                }
                sum += map[ny][nx];
            }
            if(trigger) answer = Math.max(answer, sum);
        }
    }

    private static void dfs(int y, int x, int cnt, int sum) {
        if(cnt == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        for(int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(!isOk(ny, nx) || check[ny][nx]) continue;
            check[ny][nx] = true;
            dfs(ny, nx, cnt + 1, sum + map[ny][nx]);
            check[ny][nx] = false;
        }
    }

    private static boolean isOk(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
