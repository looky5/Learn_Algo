import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1002_BOJ_19948 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        char[] arr = br.readLine().toCharArray();
        int spacebar = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] alphabet = new int[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = Integer.parseInt(st.nextToken());
        }
        int len = arr.length;
        sb.append(arr[0]);
        int idx = arr[0] - 'A';
        if (idx >= 32) { // Lower
            if (--alphabet[idx - 32] < 0) flag = false;
        } else { // Upper
            if (--alphabet[idx] < 0) flag = false;
        }
//        System.out.println(Arrays.toString(alphabet));
        char pre = arr[0];
        if (flag) {
            for (int i = 1; i < len; i++) {
//                System.out.println(arr[i]);
//                System.out.println(Arrays.toString(alphabet));
                if (arr[i] == ' ') {
                    if (pre == ' ') continue;
                    pre = arr[i];
                    if (--spacebar < 0) {
                        flag = false;
                        break;
                    }
                } else {
                    if (pre == arr[i]) continue;
                    pre = arr[i];
                    if (arr[i - 1] == ' ') {
                        sb.append(arr[i]);
                    }
                    idx = arr[i] - 'A';
                    if (idx >= 32) { // Lower
                        if (--alphabet[idx - 32] < 0) {
                            flag = false;
                            break;
                        }
                    } else { // Upper
                        if (--alphabet[idx] < 0) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
        }
        String s = sb.toString().toUpperCase();
        char tPre = '.';
        for (int i = 0; i < s.length(); i++) {
            int tIdx = s.charAt(i) - 'A';
            if (tPre - 'A' == tIdx) continue;
            tPre = s.charAt(i);
            if (--alphabet[tIdx] < 0) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            System.out.println(-1);
        } else {
            System.out.println(s);
        }
    }
}
