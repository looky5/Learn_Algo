import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _210224_boj16638 {

    static int N, len;
    static long max;
    static char[] expression;
    static Stack<Long> num_stack, num_stack2;
    static Stack<Character> op_stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        expression = br.readLine().toCharArray();
        len = expression.length;
        max = Long.MIN_VALUE;
        num_stack = new Stack<>();
        num_stack2 = new Stack<>();
        op_stack = new Stack<>();
        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int start_idx, int flag) {
        if (start_idx >= len >> 1) {
            num_stack.clear();
            op_stack.clear();
            for (int i = 0; i < len; i++) {
                if (i % 2 == 0) {
                    num_stack.add((long) (expression[i] - '0'));
                } else {
                    if (((flag & 1 << (i >> 1)) != 0)) {
                        num_stack.add(calc(num_stack.pop(), expression[i + 1] - '0', expression[i]));
                        ++i;
                    } else {
                        op_stack.add(expression[i]);
                    }
                }
            }
            num_stack2.clear();
            char c;
            while (!op_stack.isEmpty()) {
                c = op_stack.pop();
                if (c == '*') {
                    num_stack.add(num_stack.pop() * num_stack.pop());
                } else {
                    if (c == '-') {
                        num_stack2.add(-1 * num_stack.pop());
                    } else {
                        num_stack2.add(num_stack.pop());
                    }
                }
            }
            if (!num_stack.isEmpty()) {
                num_stack2.add(num_stack.pop());
            }
            int result = 0;
            while (!num_stack2.isEmpty()) {
                result += num_stack2.pop();
            }
            max = Math.max(max, result);
            return;
        }
        dfs(start_idx + 2, flag | 1 << start_idx);
        dfs(start_idx + 1, flag);
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
