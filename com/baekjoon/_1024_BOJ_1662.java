import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1024_BOJ_1662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            String s = sb.toString();
            int len = s.length();
            int end = -1;
            int start = -1;
            for (int i = len - 1; i >= 0; i--) {
                if (s.charAt(i) == ')') {
                    end = i;
                } else if (s.charAt(i) == '(') {
                    start = i;
                    break;
                }
            }
            if (start == -1 && end == -1) break;
            String t = s.substring(start + 1, end);
            int n = s.charAt(start - 1) - '0';
            if (n < 0 || n > 9) {
                sb.replace(start, end + 1, t);
                continue;
            }
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < n; i++) {
                tmp.append(t);
            }
            sb.replace(start - 1, end + 1, tmp.toString());
        }
        System.out.println(sb.toString());
    }
}
