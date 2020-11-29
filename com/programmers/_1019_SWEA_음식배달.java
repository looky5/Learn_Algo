package com.programmers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1019_SWEA_음식배달 {

    private static class house {
        int y;
        int x;

        public house(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] map;
    static int N, cost, minCost;
    static ArrayList<house> houses;
    static ArrayList<house> restaurant;
    static final int oo = (int) 2e9;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            houses = new ArrayList<>();
            restaurant = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 0) continue;
                    else if (map[i][j] == 1) houses.add(new house(i, j));
                    else restaurant.add(new house(i, j));
                }
            }
            minCost = oo;
            dfs(0, 0, 0, restaurant.size(), 0);
            sb.append("#").append(tc).append(" ").append(minCost).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private static void dfs(int start, int flag, int count, int rtrSize, int rtrCosts) {
        if (count == rtrSize) {
            if(flag == 0) return;
            cost = rtrCosts;
            int hsSize = houses.size();
            for (int i = 0; i < hsSize; i++) {
                house H = houses.get(i);
                int minDist = oo;
                for (int j = 0; j < rtrSize; j++) {
                    if ((flag & 1 << j) == 0) continue;
                    minDist = Math.min(minDist, calc(H, restaurant.get(j)));
                }
                cost += minDist;
            }
            minCost = Math.min(minCost, cost);
            return;
        }
        for (int i = start; i < rtrSize; i++) {
            house R = restaurant.get(i);
            dfs(i + 1, flag | 1 << i, count + 1, rtrSize, rtrCosts + map[R.y][R.x]);
            dfs(i + 1, flag, count + 1, rtrSize, rtrCosts);
        }
    }

    private static int calc(house H, house R) {
        return Math.abs(H.y - R.y) + Math.abs(H.x - R.x);
    }
}
