import java.util.Arrays;

public class _1106_이진변환반복하기 {
    public static void main(String[] args) {
        String s = "110010101001";
        System.out.println(Arrays.toString(solution(s)));
    }

    private static int[] solution(String s) {
        int count = 0;
        int zeroCnt = 0;
        int preLen = s.length();

        while(preLen > 1) {
            s = s.replaceAll("0", "");
            int c = s.length();
            count++;
            zeroCnt += preLen - c;
            s = Integer.toBinaryString(c);
            preLen = s.length();
        }
        return new int[]{count, zeroCnt};
    }
}
