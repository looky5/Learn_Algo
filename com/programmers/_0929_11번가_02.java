import java.util.Arrays;

public class _0929_11번가_02 {

    public static void main(String[] args) {
        String[] S1 = {"abc", "bca", "dbe"};
        String[] S2 = {"gr", "sd", "rg"};
        System.out.println(Arrays.toString(solution(S2)));
    }

    public static int[] solution(String[] S) {
        int N = S.length;
        int M = S[0].length();

        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                for(int r = 0; r < M; r++) {
                    if(S[i].charAt(r) == S[j].charAt(r)) {
                        return new int[]{i, j, r};
                    }
                }
            }
        }

        return new int[]{};
    }
}
