import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210218_boj14889v2 {

    static int N, answer;
    static int[] team1, team2;
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
        team1 = new int[N / 2];
        team2 = new int[N / 2];
        answer = Integer.MAX_VALUE;
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int count, int start, int flag) {
        if (count == N / 2) {
            assignTeam(flag);
            int score1 = 0, score2 = 0;
            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < N / 2; j++) {
                    score1 += board[team1[i]][team1[j]];
                    score2 += board[team2[i]][team2[j]];
                }
            }
            answer = Math.min(answer, Math.abs(score1 - score2));
            return;
        }
        for (int i = start; i < N; i++) {
            dfs(count + 1, i + 1, flag | 1 << i);
        }
    }

    public static void assignTeam(int flag) {
        int idx1 = 0, idx2 = 0;
        for (int i = 0; i < N; i++) {
            if ((flag & 1 << i) != 0) {
                team1[idx1++] = i;
            } else {
                team2[idx2++] = i;
            }
        }
    }
}
