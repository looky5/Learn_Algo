import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1001_BOJ_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] wires = new int[K];

        long left = 1;
        long right = -1;
        for(int i = 0; i < K; i++) {
            wires[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, wires[i]);
        }
        long max = -1;
        while(left <= right) {
            long mid = (left + right) / 2L;
            int cnt = 0;
            for(int i = 0; i < K; i++) {
                cnt += wires[i] / mid;
            }
            if(cnt < N) {
                right = mid - 1;
            } else {
                max = Math.max(max, mid);
                left = mid + 1;
            }
        }
        System.out.println(max);
    }
}
