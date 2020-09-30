import java.util.HashSet;
import java.util.Set;

public class _0913_line01 {

    public static void main(String[] args) {
//        int[][] boxes = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
        int[][] boxes = {{1, 1}, {2, 2}, {3, 3}, {4, 5}};
        System.out.println(solution(boxes));
    }

    public static int solution(int[][] boxes) {
        int answer = -1;
        int boxCnt = boxes.length;
        Set<Integer> set = new HashSet<>();
        for (int[] a : boxes) {
            for (int i = 0; i < 2; i++) {
                if (set.contains(a[i])) {
                    set.remove(a[i]);
                    boxCnt--;
                } else {
                    set.add(a[i]);
                }
            }
        }
        if(boxCnt == 0) {
            answer = 0;
        } else {
            if(set.size() >= boxCnt){
                answer = boxCnt;
            } else {
                answer += (boxCnt - set.size()) * 2;
                answer += set.size();
            }
        }

        return answer;
    }
}
