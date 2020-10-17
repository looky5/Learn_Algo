public class _1012_3진법뒤집기 {

    public static void main(String[] args) {
        int n = 100000000;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        int mok = n;
        while (mok > 0) {
            sb.append(mok % 3);
            mok /= 3;
        }

        String s = sb.toString();
        int len = s.length();
        int k = 1;
        for (int i = len - 1; i >= 0; i--) {
            answer += (s.charAt(i) - '0') * k;
            k *= 3;
        }

        return answer;
    }
}
