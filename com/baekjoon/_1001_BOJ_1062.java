import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1001_BOJ_1062 {

    static String[] words;
    static int N, K, max;
    static long alphabet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 5; // K - "antic"
        int[] antic = {0, 2, 8, 13, 19};
        alphabet = 0;
        for (int i : antic) {
            alphabet |= 1 << i;
        }
        long flag = alphabet;
        words = new String[N];
        int size = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            words[i] = s.substring(4, s.length() - 4);
            int len = words[i].length();
            for (int j = 0; j < len; j++) {
                if ((alphabet & 1 << words[i].charAt(j) - 'a') == 0) {
                    alphabet |= 1 << words[i].charAt(j) - 'a';
                    size++;
                }
            }
        }
        max = 0;
        if (K >= size) {
            System.out.println(N);
        } else {
            Combi(0, 0, flag);
            System.out.println(max);
        }
    }

    private static void Combi(int count, int start, long flag) {
        if (count == K) {
            int cnt = 0;
            for (String s : words) {
                for (int i = 0; i < s.length(); i++) {
                    if ((flag & 1 << (s.charAt(i) - 'a')) == 0) {
                        cnt--;
                        break;
                    }
                }
                cnt++;
            }
            max = Math.max(max, cnt);
            return;
        }
        for (int i = start; i < 26; i++) {
            if ((alphabet & 1 << i) != 0 && (flag & 1 << i) == 0) {
                Combi(count + 1, i + 1, flag | 1 << i);
            }
        }
    }
}
