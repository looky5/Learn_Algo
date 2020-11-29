package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0929_BOJ_1701 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        if (S.length() == 1) System.out.println(0);
        else System.out.println(solution(S, 1, S.length() - 1));
    }

    private static int solution(String s, int left, int right) {
        int max = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid > 0) {
                if (KMP(s, mid)) {
                    left = mid + 1;
                    max = mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return max;
    }

    private static boolean KMP(String s, int mid) {
        int len = s.length();
        String str;
        for (int r = 0; r <= len - mid; r++) {
            str = s.substring(r, r + mid);
            int[] pi = getPi(str);
            int strLen = str.length();
            int j = 0;
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                while (j > 0 && s.charAt(i) != str.charAt(j)) {
                    j = pi[j - 1];
                }
                if (s.charAt(i) == str.charAt(j)) {
                    if (j == strLen - 1) {
                        if (++cnt == 2) return true;
                        j = pi[j];
                    } else j++;
                }
            }
        }
        return false;
    }

    private static int[] getPi(String p) {
        int len = p.length();
        int[] pi = new int[len];
        int j = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
