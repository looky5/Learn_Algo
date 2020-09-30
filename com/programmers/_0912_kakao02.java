import java.util.ArrayList;
import java.util.Arrays;

public class _0912_kakao02 {

    public static void main(String[] args) {
//        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 4};
        System.out.println(Arrays.toString(solution(orders, course)));
    }

    public static String[] solution(String[] orders, int[] course) {
        int[] ctmPick = new int[orders.length];
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < orders[i].length(); j++) {
                ctmPick[i] |= 1 << orders[i].charAt(j) - 'A';
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < ctmPick.length - 1; i++) {
            for (int j = i + 1; j < ctmPick.length; j++) {
                int n = ctmPick[i] & ctmPick[j];
                if (n == 0 || al.contains(n) || (n & (n - 1)) == 0) continue;
                al.add(n);
            }
        }

        StringBuilder sb;
        ArrayList<String> alStr = new ArrayList<>();

        for (int n : al) {
            sb = new StringBuilder();
            String s = Integer.toBinaryString(n);
            for (int k = s.length() - 1; k >= 0; k--) {
                if(s.charAt(k) == '1') {
                    int idx = s.length() - 1 - k;
                    sb.append((char) ('A' + idx));
                }
            }
            for (int l = 0; l < course.length; l++) {
                if (sb.length() == course[l]) {
                    alStr.add(sb.toString());
                    break;
                }
            }
        }
        String[] answer = new String[alStr.size()];
        alStr.toArray(answer);
        Arrays.sort(answer);
        return answer;
    }
}
