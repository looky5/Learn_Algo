import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1017_BOJ_16987 {

    static int N, answer;
    static int[][] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        eggs = new int[N + 1][2];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
        solution(1);
        System.out.println(answer);
    }
//    내구도, 무게
    private static void solution(int start) {
        if(start == N + 1) {
            getMax();
            return;
        }
        if(eggs[start][0] <= 0) {
            solution(start + 1);
        } else {
            for (int i = 1; i <= N; i++) {
                if (eggs[i][0] <= 0 || start == i) continue;
                eggs[start][0] -= eggs[i][1];
                eggs[i][0] -= eggs[start][1];
                solution(start + 1);
                eggs[start][0] += eggs[i][1];
                eggs[i][0] += eggs[start][1];
            }
            getMax();
        }
    }

    private static void getMax() {
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(eggs[i][0] <= 0) cnt++;
        }
        answer = Math.max(answer, cnt);
    }
}
