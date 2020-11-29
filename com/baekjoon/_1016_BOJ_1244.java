package com.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1016_BOJ_1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] switches = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 1;
        while (st.hasMoreTokens()) {
            switches[idx++] = Integer.parseInt(st.nextToken());
        }
        int students = Integer.parseInt(br.readLine());
        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            switches = sex == 1 ? maleCase(switches, num, N) : femaleCase(switches, num, N);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(switches[i]).append(" ");
            if(i % 20 == 0) {
                sb.deleteCharAt(sb.length() - 1);
                sb.append('\n');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private static int[] maleCase(int[] switches, int num, int N) {
        int j = 2;
        for (int i = num; i <= N; i = num * j++) {
            switches[i] = switches[i] == 0 ? 1 : 0;
        }
        return switches;
    }

    private static int[] femaleCase(int[] switches, int num, int N) {
        int left = num - 1;
        int right = num + 1;
        switches[num] = switches[num] == 0 ? 1 : 0;
        for (; left >= 1 && right <= N; left--, right++) {
            if (switches[left] != switches[right]) break;
            if (switches[left] == 0) {
                switches[left] = 1;
                switches[right] = 1;
            } else {
                switches[left] = 0;
                switches[right] = 0;
            }
        }

        return switches;
    }
}
