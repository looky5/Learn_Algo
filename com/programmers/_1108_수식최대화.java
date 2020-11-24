import java.util.ArrayList;

public class _1108_수식최대화 {
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
//        String expression = "2-990-5+2+3*2";
//        String expression = "50*6-3*2";
        System.out.println(solution(expression));
    }

    static ArrayList<String> numStringList;
    static ArrayList<Character> operList;
    static char[] ops = {'*', '+', '-'};
    static long calcResult;

    public static long solution(String expression) {
        calcResult = 0;
        numStringList = new ArrayList<String>();
        operList = new ArrayList<Character>();
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == '*' || c == '+' || c == '-') operList.add(c);
        }
        expression = expression.replaceAll("[*+-]", " ");
        String[] arr = expression.split(" ");
        for(String str : arr) {
            numStringList.add(str);
        }

        perm(0, 0, new char[3]);
        long answer = calcResult;
        return answer;
    }

    private static void perm(int flag, int count, char[] order) {
        if(count == 3) {
            calcResult = Math.max(calcResult, strCalc(order));
            return;
        }
        for(int i = 0; i < 3; i++) {
            if((flag & 1 << i) == 0) {
                order[count] = ops[i];
                perm(flag | 1 << i, count + 1, order);
            }
        }
    }

    private static long strCalc(char[] order) {
        ArrayList<String> numTemp = new ArrayList<>(numStringList);
        ArrayList<Character> operTmp = new ArrayList<>(operList);
        for(int i = 0; i < 3; i++) {
            char operator = order[i];
            for(int j = 0; j < operTmp.size(); j++) {
                char c = operTmp.get(j);
                if(c != operator) continue;
                long calcNum = calc(c, Long.parseLong(numTemp.remove(j)), Long.parseLong(numTemp.remove(j)));
                numTemp.add(j, Long.toString(calcNum));
                operTmp.remove(j--);
            }
        }
        return Math.abs(Long.parseLong(numTemp.get(0)));
    }

//    private static long strCalc(String expression, char[] order) {
//        StringBuilder sb = new StringBuilder(expression);
//        for(int i = 0; i < 3; i++) {
//            char operator = order[i];
//            for(int j = 0; j < sb.length(); j++) {
//                if(sb.charAt(j) != operator) continue;
//                int left = j - 1;
//                if(left < 0) continue;
//                if(sb.charAt(left) == '*' || sb.charAt(left) == '+') continue;
//                int right = j + 1;
//                StringBuilder[] num = new StringBuilder[2];
//                num[0] = new StringBuilder();
//                num[1] = new StringBuilder();
//                while(left >= 0 && sb.charAt(left) >= '0' && sb.charAt(left) <= '9') {
//                    num[0].append(sb.charAt(left));
//                    left--;
//                }
//                if(left == 0 && sb.charAt(left) == '-') {
//                    num[0].append(sb.charAt(left));
//                    left--;
//                }
//                if(sb.charAt(right) == '+' || sb.charAt(right) == '-') {
//                    num[1].append(sb.charAt(right));
//                    right++;
//                }
//                while(right < sb.length() && sb.charAt(right) >= '0' && sb.charAt(right) <= '9') {
//                    num[1].append(sb.charAt(right));
//                    right++;
//                }
//                long calcResult = calc(operator, Long.parseLong(num[0].reverse().toString())
//                        , Long.parseLong(num[1].toString()));
//                sb.replace(left + 1, right, Long.toString(calcResult));
//                j = -1;
//            }
//        }
//        return Math.abs(Long.parseLong(sb.toString()));
//    }

    private static long calc(char operator, long a, long b) {
        switch (operator) {
            case '*':
                return a * b;
            case '+':
                return a + b;
            case '-':
                return a - b;
        }
        return 0;
    }
}
