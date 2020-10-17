import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1016_BOJ_13300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[7][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            arr[grade][student]++;
        }
        System.out.println(solution(N, K, arr));
    }

    public static int solution(int N, int K, int[][] arr) {
        int answer = 0;

        for(int i = 1; i <= 6; i++) {
            for(int j = 0; j < 2; j++) {
                if(arr[i][j] % K == 0) {
                    answer += arr[i][j] / K;
                } else {
                    answer += arr[i][j] / K + 1;
                }
            }
        }

        return answer;
    }
}
