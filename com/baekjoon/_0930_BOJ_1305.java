import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0930_BOJ_1305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();
        for(int i = 0; i < L / 2; i++) {
            char tmp = S[i];
            S[i] = S[L - 1 - i];
            S[L - 1 - i] = tmp;
        }

        int[] pi = new int[L];
        int j = 0;

        for(int i = 1; i < L; i++) {
            while(j > 0 && S[i] != S[j]) {
                j = pi[j - 1];
            }
            if(S[i] == S[j]) {
                pi[i] = ++j;
            }
        }
        System.out.println(L - pi[L - 1]);
    }
}
