import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210218_boj14889 {

    static int N, answer, team1, team2;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = Integer.MAX_VALUE;
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int count, int start, int team) {
        if (count == N / 2) {
            team1 = 0;
            team2 = 0;
            getTeam1Stats(0, 0, 0, 0, team);
            getTeam2Stats(0, 0, 0, 0, team);
            answer = Math.min(answer, Math.abs(team1 - team2));
            return;
        }
        for (int i = start; i < N; i++) {
            dfs(count + 1, i + 1, team | 1 << i);
        }
    }

    public static void getTeam1Stats(int count, int start, int i, int j, int team) {
        if (count == 2) {
            team1 += board[i][j];
            team1 += board[j][i];
            return;
        }
        for (int k = start; k < N; k++) {
            if ((team & 1 << k) != 0) {
                if (count == 0) {
                    i = k;
                } else {
                    j = k;
                }
                getTeam1Stats(count + 1, k + 1, i, j, team);
            }
        }
    }

    public static void getTeam2Stats(int count, int start, int i, int j, int team) {
        if (count == 2) {
            team2 += board[i][j];
            team2 += board[j][i];
            return;
        }
        for (int k = start; k < N; k++) {
            if ((team & 1 << k) == 0) {
                if (count == 0) {
                    i = k;
                } else {
                    j = k;
                }
                getTeam2Stats(count + 1, k + 1, i, j, team);
            }
        }
    }
}
