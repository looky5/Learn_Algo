package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _0901_1726 {
	
//	private class 

	static int M, N;
	static int[][] map;
	static int[][][] minCostMap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		minCostMap = new int[M][N][5];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] init_n_Fin = new int[2][3];
		for(int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			init_n_Fin[i][0] = Integer.parseInt(st.nextToken());
			init_n_Fin[i][1] = Integer.parseInt(st.nextToken());
			init_n_Fin[i][2] = Integer.parseInt(st.nextToken());
		}
		System.out.println(bfs(init_n_Fin[0], init_n_Fin[1]));
		
	} // end of main
	
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
	
	private static int bfs(int[] start, int[] fin) {
		map[fin[0]][fin[1]] = 3;
		int answer = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{start[2], 3, 0});
		while(!q.isEmpty()) {
		}
		
		return answer;
	}
} // end of class
