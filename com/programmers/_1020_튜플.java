package com.programmers;
import java.util.*;

public class _1020_튜플 {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] strArr = s.split("},\\{");
        Map<Integer, Integer> map = new LinkedHashMap<>();
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int cnt = 0;
        for (String str : strArr) {
            String[] tmp = str.split(",");
            int len = tmp.length;
            int num = 0;
            for (int i = 0; i < len; i++) {
                num = Integer.parseInt(tmp[i]);
                if (!map.containsKey(num)) {
                    map.put(num, num);
                    cnt++;
                    break;
                }
            }
        }

        int[] answer = new int[cnt];
        int idx = 0;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            answer[idx++] = (int) it.next();
        }

        return answer;
    }
}
