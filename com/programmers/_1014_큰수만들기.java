package com.programmers;

public class _1014_큰수만들기 {

    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
        System.out.println(solution(number, k));
    }

    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        while(k > 0) {
            boolean trigger = false;
            int len = sb.length();
            for(int i = 1; i < len; i++) {
                if(sb.charAt(i) > sb.charAt(i - 1)) {
                    sb.deleteCharAt(i - 1);
                    k--;
                    trigger = true;
                    break;
                }
            }
            if(trigger) continue;
            sb.deleteCharAt(len - 1);
            k--;
        }

        return sb.toString();
    }
}
