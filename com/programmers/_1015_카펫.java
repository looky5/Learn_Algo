import java.util.Arrays;

public class _1015_카펫 {

    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        System.out.println(Arrays.toString(solution(brown, yellow)));
    }

    public static int[] solution(int brown, int yellow) {
        int w = 0;
        int h = 0;
        int YelMaxVert = (int) Math.sqrt(yellow);

        for(int i = 1; i <= YelMaxVert; i++) {
            if(yellow % i == 0) {
                int j = yellow / i;
                if(brown == (j + 2) * 2 + i * 2) {
                    w = j + 2;
                    h = i + 2;
                    break;
                }
            }
        }

        return new int[]{w, h};
    }
}
