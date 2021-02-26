import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _210223_boj1655 {

    static int N;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int n;
        for (int i = 0; i < N; ++i) {
            n = Integer.parseInt(br.readLine());
            putNum(n, i);
            sb.append(getMiddleNum()).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private static void putNum(int num, int end) {
        int left = 0, right = end, mid = 0;
        while (left < right) {
            mid = (left + right) >> 1;
            if (num < list.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        list.add(left, num);
    }

    private static int getMiddleNum() {
        int size = list.size();
        if (size % 2 == 0) {
            return list.get((size >> 1) - 1);
        } else {
            return list.get(size >> 1);
        }
    }
}
