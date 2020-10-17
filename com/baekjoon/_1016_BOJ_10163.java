import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1016_BOJ_10163 {

    static final int[] dy = {0, 1};
    static final int[] dx = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N + 1];
        int[][] board = new int[101][101];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            answer[i] = w * h;
            Queue<int[]> que = new LinkedList<>();
            que.add(new int[]{y, x});
            answer[board[y][x]]--;
            board[y][x] = i;
            while (!que.isEmpty()) {
                int[] now = que.poll();
                for (int d = 0; d < 2; d++) {
                    int ny = now[0] + dy[d];
                    int nx = now[1] + dx[d];
                    if (ny > 100 || nx > 100 || ny >= y + h || nx >= x + w || board[ny][nx] == i)
                        continue;
                    que.add(new int[]{ny, nx});
                    answer[board[ny][nx]]--;
                    board[ny][nx] = i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 1; j <= N; j++) {
            sb.append(answer[j]).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb.toString());
    }


}
