import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0929_BOJ_1701_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        System.out.println(solution(S));
    }

    private static int solution(String s) {
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            max = Math.max(max, getPi(s.substring(i)));
        }
        return max;
    }

    private static int getPi(String p) {
        int len = p.length();
        int[] pi = new int[len];
        int j = 0;
        int max = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                pi[i] = ++j;
                max = Math.max(max, pi[i]);
            }
        }
        return max;
    }
}
