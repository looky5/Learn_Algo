import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _1013_카카오프렌즈컬러링북 {

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
//        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        System.out.println(Arrays.toString(solution(m, n, picture)));
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    int areaSize = 0;
                    Queue<int[]> que = new LinkedList<>();
                    que.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!que.isEmpty()) {
                        areaSize++;
                        int[] now = que.poll();
                        for (int d = 0; d < 4; d++) {
                            int ny = now[0] + dy[d];
                            int nx = now[1] + dx[d];
                            if (ny < 0 || ny >= m || nx < 0 || nx >= n || visited[ny][nx] || picture[ny][nx] != picture[i][j])
                                continue;
                            que.add(new int[]{ny, nx});
                            visited[ny][nx] = true;
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaSize);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
