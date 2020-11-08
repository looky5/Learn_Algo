

public class _1020_단체사진찍기 {
    public static void main(String[] args) {
        int n = 2;
//        String[] data = {"N~F=0", "R~T>2"};
        String[] data = {"M~C<2", "C~M>1"};
        System.out.println(solution(n, data));
    }

    static int result;
    static char[] arr;
    static final char[] kakao = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

    public static int solution(int n, String[] data) {
        result = 0;
        arr = new char[8];
        dfs(n, data, 0, 0);
        int answer = result;
        return answer;
    }

    private static void dfs(int n, String[] data, int flag, int count) {
        if (count == 8) {
            if (check(n, data)) result++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if ((flag & 1 << i) == 0) {
                arr[count] = kakao[i];
                dfs(n, data, flag | 1 << i, count + 1);
            }
        }
    }

    private static boolean check(int n, String[] data) {
        for (String s : data) {
            char c1 = s.charAt(0);
            char c2 = s.charAt(2);
            char operator = s.charAt(3);
            int opNum = s.charAt(4) - '0';
            int c1Idx = 0;
            int c2Idx = 0;

            for (int i = 0; i < 8; i++) {
                if (arr[i] == c1) c1Idx = i;
                if (arr[i] == c2) c2Idx = i;
            }
            int gap = Math.abs(c1Idx - c2Idx) - 1;
            switch (operator) {
                case '=':
                    if (gap != opNum) return false;
                    break;
                case '<':
                    if (gap >= opNum) return false;
                    break;
                case '>':
                    if (gap <= opNum) return false;
            }
        }
        return true;
    }
}
