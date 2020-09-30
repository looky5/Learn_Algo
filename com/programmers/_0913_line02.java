import java.util.*;

public class _0913_line02 {

    public static void main(String[] args) {
//        int[] ball = {1, 2, 3, 4, 5, 6};
//        int[] order = {6, 2, 5, 1, 4, 3};
        int[] ball = {11, 2, 9, 13, 24};
        int[] order = {9, 2, 13, 24, 11};
        System.out.println(Arrays.toString(solution(ball, order)));
    }

    public static int[] solution(int[] ball, int[] order) {
        int ballSize = ball.length;
        int[] answer = new int[ballSize];
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> wait = new ArrayList<>();
        for (int a : ball) {
            al.add(a);
        }
        int answerIdx = 0;
        for (int i = 0; i < order.length; i++) {
            int n = al.indexOf(order[i]);
            if (n == 0 || n == al.size() - 1) {
                al.remove(n);
                answer[answerIdx++] = order[i];
            } else {
                wait.add(order[i]);
            }
            int waitLen = wait.size();
            for (int j = 0; j < waitLen; j++) {
                if (wait.contains(al.get(0))) {
                    answer[answerIdx++] = al.get(0);
                    wait.remove(al.get(0));
                    al.remove(0);
                } else if(wait.contains(al.get(al.size() - 1))) {
                    answer[answerIdx++] = al.get(al.size() - 1);
                    wait.remove(al.get(al.size() - 1));
                    al.remove(al.size() - 1);
                }
            }
        }

        return answer;
    }
}
