package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class player {
    char who;
    int y;
    int x;

    public player(char who, int y, int x) {
        this.who = who;
        this.y = y;
        this.x = x;
    }
}

public class _1001_BOJ_20005 {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[][] map = new char[M][N];
        boolean[][][] visited = new boolean[M][N][P];
        int[][] location = new int[P][2];
        int[] damage = new int[P];
        int[] boss = new int[2];
        Queue<player> que = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            map[i] = s.toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'B') {
                    boss[0] = i;
                    boss[1] = j;
                } else if (map[i][j] != '.' && map[i][j] != 'X') {
                    location[map[i][j] - 'a'][0] = i;
                    location[map[i][j] - 'a'][1] = j;
                }
            }
        }
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            char playerId = st.nextToken().charAt(0);
            damage[playerId - 'a'] = Integer.parseInt(st.nextToken());
            int[] loc = location[playerId - 'a'];
            que.add(new player(playerId, loc[0], loc[1]));
            visited[loc[0]][loc[1]][playerId - 'a'] = true;
        }
        int bossHP = Integer.parseInt(br.readLine());

        boolean[] arrive = new boolean[P];
        while (bossHP > 0) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                player now = que.poll();
                if (boss[0] == now.y && boss[1] == now.x) {
                    bossHP -= damage[now.who - 'a'];
                    if (!arrive[now.who - 'a']) {
                        answer++;
                        arrive[now.who - 'a'] = true;
                    }
                    que.add(now);
                    continue;
                }
                if (arrive[now.who - 'a']) continue;
                for (int d = 0; d < 4; d++) {
                    int ny = now.y + dy[d];
                    int nx = now.x + dx[d];
                    if (ny < 0 || ny >= M || nx < 0 || nx >= N || map[ny][nx] == 'X' || visited[ny][nx][now.who - 'a'])
                        continue;
                    que.add(new player(now.who, ny, nx));
                    visited[ny][nx][now.who - 'a'] = true;
                }
            }
        }
        System.out.println(answer);
    }
}
