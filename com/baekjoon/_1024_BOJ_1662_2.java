import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1024_BOJ_1662_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        Stack<Integer> stack = new Stack<>();
        int[] section = new int[50];
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) == ')') {
                stack.push(i);
            } else if (str.charAt(i) == '(') {
                section[i] = stack.pop();
            }
        }
        System.out.println(dfs(str, section, 0, len));
    }

    private static int dfs(String str, int[] section, int start, int end) {
        int answer = 0;
        for (int i = start; i < end; i++) {
            if (str.charAt(i) == '(') {
                int n = str.charAt(i - 1) - '0';
                answer += n * dfs(str, section, i + 1, section[i]) - 1;
                i = section[i];
            } else {
                answer++;
            }
        }
        return answer;
    }
}
