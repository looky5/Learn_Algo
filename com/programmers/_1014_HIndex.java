import java.util.Arrays;

public class _1014_HIndex {

    public static void main(String[] args) {
        int[] citations = {1, 1, 4, 9, 10};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        if(citations[0] >= n) {
            answer = n;
        } else {
            int h = 0;
            int pre = -1;
            for (int i = 0; i < n; i++) {
                if (pre == citations[i]) continue;
                h = citations[i];
                if (n - i >= h) answer = h;
                else {
                    answer = n - i;
                    break;
                }
                pre = citations[i];
            }
        }
        return answer;
    }
}
