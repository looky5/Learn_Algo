public class _1021_다음큰숫자 {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        String s = Integer.toBinaryString(n);
        int len = s.length();
        int nCnt = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') nCnt++;
        }
        StringBuilder sb = new StringBuilder(s);
        if (nCnt == len) {
            sb.replace(0, 1, "0");
            sb.insert(0, '1');
            return Integer.parseInt(sb.toString(), 2);
        } else {
            for(int i = len - 1; i >= 0; i--) {
                if(sb.charAt(i) == '1') {
                    sb.replace(i, i + 1, "0");
                    boolean trigger = false;
                    int count = 0;
                    for(int j = i - 1; j >= 0; j--) {
                        if(sb.charAt(j) == '0') {
                            trigger = true;
                            sb.replace(j, j + 1, "1");
                            if(count > 0) {
                                StringBuilder sb2 = new StringBuilder();
                                for (int k = j + 1; k < len - count; k++) {
                                    sb2.append('0');
                                }
                                for (int k = 0; k < count; k++) {
                                    sb2.append('1');
                                }
                                sb.replace(j + 1, len, sb2.toString());
                            }
                            break;
                        } else {
                            count++;
                        }
                    }
                    if(!trigger) {
                        sb = new StringBuilder();
                        sb.append('1').append('0');
                        for(int m = 0; m < count; m++) sb.append('1');
                        int sbLen = sb.length();
                        for(int o = 0; o < len + 1 - sbLen; o++)
                            sb.insert(2, '0');
                    }
                    break;
                }
            }
            return Integer.parseInt(sb.toString(), 2);
        }
    }
}
