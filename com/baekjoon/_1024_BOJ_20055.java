package com.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1024_BOJ_20055 {

    private static class belt {
        int durability;
        boolean haveRobot;

        public belt(int durability, boolean haveRobot) {
            this.durability = durability;
            this.haveRobot = haveRobot;
        }

        public boolean isOk() {
            return durability > 0 && !haveRobot;
        }

        public void clean() {
            haveRobot = false;
        }

        @Override
        public String toString() {
            return "{" +
                    durability +
                    " , " + haveRobot +
                    '}';
        }
    }

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt[] conveyor = new belt[2 * N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < 2 * N + 1; i++) {
            conveyor[i] = new belt(Integer.parseInt(st.nextToken()), false);
        }
        int step = 0;
        int broken = 0;
        int startPoint = 1;
        while (broken < K) {
            step++;
            startPoint = startPoint < 2 ? 2 * N : startPoint - 1; // 한 칸 회전
            int namuzi = startPoint - 1 > N ? startPoint - N - 1 : 0; // 컨베이어 범위
            if (namuzi == 0) {
                int endPoint = startPoint + N - 1;
                conveyor[endPoint].clean();
                if (conveyor[endPoint].isOk() && conveyor[endPoint - 1].haveRobot) {
                    if (--conveyor[endPoint].durability == 0) broken++;
                    conveyor[endPoint - 1].haveRobot = false;
                }
                for (int i = endPoint - 1; i > startPoint; i--) {
                    if (conveyor[i].isOk() && conveyor[i - 1].haveRobot) {
                        if (--conveyor[i].durability == 0) broken++;
                        conveyor[i].haveRobot = true;
                        conveyor[i - 1].haveRobot = false;
                    }
                }
            } else {
                conveyor[namuzi].clean();
                int before = namuzi == 1 ? 2 * N : namuzi - 1;
                if (conveyor[namuzi].isOk() && conveyor[before].haveRobot) {
                    if (--conveyor[namuzi].durability == 0) broken++;
                    conveyor[before].haveRobot = false;
                }
                if (before == 2 * N) {
                    for (int i = before; i > startPoint; i--) {
                        if (conveyor[i].isOk() && conveyor[i - 1].haveRobot) {
                            if (--conveyor[i].durability == 0) broken++;
                            conveyor[i].haveRobot = true;
                            conveyor[i - 1].haveRobot = false;
                        }
                    }
                } else {
                    for (int i = before; i > 1; i--) {
                        if (conveyor[i].isOk() && conveyor[i - 1].haveRobot) {
                            if (--conveyor[i].durability == 0) broken++;
                            conveyor[i].haveRobot = true;
                            conveyor[i - 1].haveRobot = false;
                        }
                    }
                    if (conveyor[1].isOk() && conveyor[2 * N].haveRobot) {
                        if (--conveyor[1].durability == 0) broken++;
                        conveyor[1].haveRobot = true;
                        conveyor[2 * N].haveRobot = false;
                    }
                    for (int i = 2 * N; i > startPoint; i--) {
                        if (conveyor[i].isOk() && conveyor[i - 1].haveRobot) {
                            if (--conveyor[i].durability == 0) broken++;
                            conveyor[i].haveRobot = true;
                            conveyor[i - 1].haveRobot = false;
                        }
                    }
                }
            }
            if (conveyor[startPoint].isOk()) {
                if (--conveyor[startPoint].durability == 0) broken++;
                conveyor[startPoint].haveRobot = true;
            }
        } // end of loop
        System.out.println(step);
    } // end of main
}
