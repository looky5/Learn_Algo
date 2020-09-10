package com.programmers;

public class _0908_124나라의숫자 {

    public static void main(String[] args) {
        int n = 52;
        System.out.println(solution(n));
    }

    public static String solution(int n) {
    	StringBuffer sb = new StringBuffer();
        String[] arr = {"4", "1", "2"};
        // 3 x a + 1,2,3 => 1, 2, 4
        while(true){
            int mok = n / 3;
            int namugi = n % 3;
            if(namugi == 0){
                mok--;
            }
            n = mok;
            sb.insert(0, arr[namugi]);
            if(mok == 0){
                break;
            }
        }

        return sb.toString();
    }
}
