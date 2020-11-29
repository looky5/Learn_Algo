package com.programmers;
import java.util.Arrays;
import java.util.Comparator;

public class _1106_최댓값과최솟값 {
    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        System.out.println(solution(s));
    }
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });
        sb.append(arr[0]).append(' ').append(arr[arr.length - 1]);
        return sb.toString();
    }
}
