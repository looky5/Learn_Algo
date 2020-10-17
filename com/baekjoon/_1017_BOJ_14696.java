import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1017_BOJ_14696 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[][] kid1 = new int[N][5];
        int[][] kid2 = new int[N][5];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            for(; j > 0; j--) {
                kid1[i][Integer.parseInt(st.nextToken())]++;
            }
            st = new StringTokenizer(br.readLine());
            j = Integer.parseInt(st.nextToken());
            for(; j > 0; j--) {
                kid2[i][Integer.parseInt(st.nextToken())]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 4; j >= 1; j--) {
                if(kid1[i][j] > kid2[i][j]) {
                    sb.append('A').append('\n');
                    break;
                } else if(kid1[i][j] < kid2[i][j]) {
                    sb.append('B').append('\n');
                    break;
                }
                if(j == 1) sb.append('D').append('\n');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
