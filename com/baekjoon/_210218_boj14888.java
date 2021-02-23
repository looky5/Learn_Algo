import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210218_boj14888 {

    static int N, min, max;
    static int[] A;
    static int[] opt;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        opt = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            opt[i] = Integer.parseInt(st.nextToken());
        }
        sb = new StringBuilder();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs(0);
        sb.setLength(0);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }

    public static void dfs(int idx) {
        if (idx == N - 1) {
            calc();
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (opt[i] > 0) {
                --opt[i];
                sb.append(i);
                dfs(idx + 1);
                sb.deleteCharAt(sb.length() - 1);
                ++opt[i];
            }
        }
    }

    public static void calc() {
        int result = A[0];
        for (int i = 0; i < N - 1; i++) {
            switch (sb.charAt(i)) {
                case '0':
                    result += A[i + 1];
                    break;
                case '1':
                    result -= A[i + 1];
                    break;
                case '2':
                    result *= A[i + 1];
                    break;
                case '3':
                    if (result < 0) {
                        result *= -1;
                        result /= A[i + 1];
                        result *= -1;
                    } else result /= A[i + 1];
            }
        }
        if (result < min) min = result;
        if (result > max) max = result;
    }
}
