import java.util.*;
public class _0926_naver01 {

    public static void main(String[] args) {
        int n = 6;
        int[] p = {5, 4, 7, 2, 0, 6};
        int[] c = {4, 6, 4, 9, 2, 3};
        System.out.println(solution(n, p, c));
    }

    public static String solution(int n, int[] p, int[] c) {
        Stack<Integer> stack = new Stack<>();
        int[] prices = {100, 50, 25, 0};
        for(int i = n - 1; i >= 0; i--) {
            stack.push(p[i]);
        }
        int priceIdx = 0;
        int sum = 0;
        int days = 0;
        for(int i = 0; i < n; i++) {
            days++;
            int today = stack.pop();
            if(today < c[i]) {
                if(++priceIdx == 3) {
                    break;
                }
                if(!stack.isEmpty()) {
                    stack.push(stack.pop() + today);
                }
            } else {
                sum += prices[priceIdx] * c[i];
                if(!stack.isEmpty()) {
                    stack.push(stack.pop() + today - c[i]);
                }
                priceIdx = 0;
            }
        }

        return String.format("%.2f", 1.0 * sum / days);
    }
}
