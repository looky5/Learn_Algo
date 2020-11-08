

public class _1021_올바른괄호 {
    public static void main(String[] args) {
        String s = "(())()";
        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        boolean answer = true;
        int len = s.length();

        int close = 0;
        for(int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == '(') {
                if(close == 0) {
                    answer = false;
                    break;
                }
                close--;
            } else {
                close++;
            }
        }
        if(close != 0) answer = false;
        return answer;
    }
}
