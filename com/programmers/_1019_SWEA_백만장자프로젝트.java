import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1019_SWEA_백만장자프로젝트 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int maxNum = 0;
            long answer = 0;
            for(int i = N - 1; i >= 0; i--) {
                if(maxNum <= arr[i]) {
                    maxNum = arr[i];
                } else {
                    answer += maxNum - arr[i];
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
