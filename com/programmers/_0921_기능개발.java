import java.util.*;

public class _0921_기능개발 {

    public static void main(String[] args) {
        int[] progresses = {99, 99, 99};
        int[] speeds = {3, 3, 3};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> al = new ArrayList<>();
        int days = 0;
        int cnt = 0;
        for (int i = 0; i < progresses.length; i++) {
            if (progresses[i] + days * speeds[i] >= 100) {
                cnt++;
                continue;
            }
            if (cnt == 0) {
                days += (int) Math.ceil(1.0 * (100 - progresses[i] - speeds[i] * days) / speeds[i]);
                cnt++;
            } else {
                al.add(cnt);
                cnt = 0;
                i--;
            }
        }
        if(cnt > 0) al.add(cnt);
        int[] answer = new int[al.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = al.get(i);
        }
        return answer;
    }
}
