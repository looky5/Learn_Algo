package com.programmers;
import java.util.*;

public class _1015_위장 {

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String[] arr : clothes) {
            if(map.containsKey(arr[1])) {
                map.get(arr[1]).add(arr[0]);
            } else {
                ArrayList<String> al = new ArrayList<>();
                al.add(arr[0]);
                map.put(arr[1], al);
            }
        }
        Set set = map.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()) {
            answer *= map.get(it.next()).size() + 1;
        }

        return answer - 1;
    }
}
