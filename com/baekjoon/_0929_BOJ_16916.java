package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0929_BOJ_16916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        int[] pi = getPi(P);
        System.out.println(KMP(pi, S, P));
    }

    private static int KMP(int[] pi, String s, String p) {
        int SLen = s.length();
        int PLen = p.length();
        int j = 0;

        for(int i = 0; i < SLen; i++) {
            while(j > 0 && s.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if(s.charAt(i) == p.charAt(j)) {
                if(j++ == PLen - 1) return 1;
            }
        }

        return 0;
    }

    private static int[] getPi(String p) {
        int len = p.length();
        int[] pi = new int[len];
        int j = 0;

        for(int i = 1; i < len; i++) {
            while(j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if(p.charAt(i) == p.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
