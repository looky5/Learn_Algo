import java.util.HashSet;
import java.util.Set;

public class _1021_폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int count = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        int kinds = set.size();
        answer = count < kinds ? count : kinds;

        return answer;
    }
}
