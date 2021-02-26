import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _210224_boj16639 {

    static int N, len;
    static long max;
    static int[] nums;
    static char[] ops;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[] expression = br.readLine().toCharArray();
        len = expression.length >> 1;
        nums = new int[len + 1];
        ops = new char[len];
        int nums_idx = 0, ops_idx = 0;
        for (int i = 0; i < expression.length; i++) {
            if (i % 2 == 0) nums[nums_idx++] = expression[i] - '0';
            else ops[ops_idx++] = expression[i];
        }
        max = Long.MIN_VALUE;
        dfs(0, nums[0]);
        System.out.println(max);
    }

    public static void dfs(int start_idx, long value) {
        if (start_idx == len) {
            max = Math.max(max, value);
            return;
        }
        dfs(start_idx + 1, calc(value, nums[start_idx + 1], ops[start_idx]));
        if (start_idx + 1 < len) {
            dfs(start_idx + 2, calc(value, calc(nums[start_idx + 1], nums[start_idx + 2], ops[start_idx + 1]), ops[start_idx]));
        }
    }

    public static long calc(long a, long b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 0;
    }
}
