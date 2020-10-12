import java.util.*;

public class _1009_coupang20203 {

    public static void main(String[] args) {
        int k = 3;
//        int k = 2;
        int[] score = {24, 22, 20, 10, 5, 3, 2, 1};
//        int[] score = {1300000000, 700000000, 668239490, 618239490, 568239490, 568239486, 518239486, 157658638, 157658634, 100000000, 100};
        System.out.println(solution(k, score));
    }

    private static int solution(int k, int[] score) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        Map<Integer, Integer> chaCnt = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 1; i < score.length; i++) {
            set.add(i);
            int cha = Math.abs(score[i - 1] - score[i]);
            if (!map.containsKey(cha)) {
                if(!chaCnt.containsKey(cha)) chaCnt.put(cha, 0);
                map.put(cha, new HashSet<Integer>());
            }
            chaCnt.put(cha, chaCnt.get(cha) + 1);
            map.get(cha).add(i - 1);
            map.get(cha).add(i);
        }

        for (int p : chaCnt.keySet()) {
            if (chaCnt.get(p) < k) continue;
            for (int t : map.get(p)) {
                set.remove(t);
            }
        }

        return set.size();
    }
}
