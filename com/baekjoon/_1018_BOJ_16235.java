package com.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1018_BOJ_16235 {

    private static class tree {
        int y;
        int x;
        int age;

        public tree(int y, int x, int age) {
            this.y = y;
            this.x = x;
            this.age = age;
        }

        @Override
        public String toString() {
            return "tree{" +
                    "y=" + y +
                    ", x=" + x +
                    ", age=" + age +
                    '}';
        }
    }

    static int N, M, K;
    static int[][] map, A;
    static final int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static final int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        A = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }
        PriorityQueue<tree> trees = new PriorityQueue<>(new Comparator<tree>() {
            @Override
            public int compare(tree o1, tree o2) {
                return o1.age - o2.age;
            }
        });
        Queue<tree> tmp = new LinkedList<>();
        Queue<tree> deadTrees = new LinkedList<>();
        Queue<tree> breeding = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            trees.add(new tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken())));
        }

        while (K > 0) {
            while (!trees.isEmpty()) { // 봄
                tree now = trees.poll();
                if (map[now.y][now.x] < now.age) { // 나무가 죽는 경우
                    deadTrees.add(new tree(now.y, now.x, now.age));
                } else { // 나무가 사는 경우
                    map[now.y][now.x] -= now.age;
                    now.age++;
                    if (now.age % 5 == 0) breeding.add(new tree(now.y, now.x, now.age));
                    else tmp.add(new tree(now.y, now.x, now.age));
                }
            }
            while (!deadTrees.isEmpty()) { // 여름
                tree now = deadTrees.poll();
                map[now.y][now.x] += now.age / 2;
            }
            while (!breeding.isEmpty()) { // 가을
                tree now = breeding.poll();
                for (int d = 0; d < 8; d++) {
                    int ny = now.y + dy[d];
                    int nx = now.x + dx[d];
                    if (ny < 1 || ny > N || nx < 1 || nx > N) continue;
                    tmp.add(new tree(ny, nx, 1));
                }
                tmp.add(new tree(now.y, now.x, now.age));
            }
            while (!tmp.isEmpty()) {
                trees.add(tmp.poll());
            }
            for (int i = 1; i <= N; i++) { // 겨울
                for (int j = 1; j <= N; j++) {
                    map[i][j] += A[i][j];
                }
            }
            K--;
        } // end of while()
        System.out.println(trees.size());
    } // end of main
} // end of mainClass
