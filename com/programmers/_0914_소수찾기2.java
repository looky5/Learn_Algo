import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _0914_소수찾기2 {

    public static void main(String[] args) {
        String numbers = "0111111";
        System.out.println(solution(numbers));
    }

    static char[] num;
    static Set<Integer> set;
    static int totalCnt;

    public static int solution(String numbers) {
        num = numbers.toCharArray();
        set = new HashSet<Integer>();
        dfs(0, 0, new String());
        System.out.println(totalCnt);
        return set.size();
    }

    private static void dfs(int flag, int count, String str) {
        if (count > num.length) {
            return;
        }
        if (count > 0 && count <= num.length) {
            totalCnt++;
            int n = Integer.parseInt(str);
            if (isPrime(n)) {
                set.add(n);
            }
        }

        for (int i = 0; i < num.length; i++) {
            if ((flag & (1 << i)) != 0) {
                continue;
            }
            dfs(flag | 1 << i, count + 1, str + num[i]);
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
