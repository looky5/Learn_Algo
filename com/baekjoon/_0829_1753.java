package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _0829_1753 {

	static final int oo = (int) 1e9;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		// node = (from, to, weight)
		int[] minWeight = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		ArrayList<ArrayList<int[]>> al = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			al.add(new ArrayList<int[]>());
		}
		Arrays.fill(minWeight, oo);
		minWeight[K] = 0;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int[] tmp = new int[3];
			for (int j = 0; j < 3; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}
			al.get(tmp[0]).add(tmp);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		pq.offer(new int[] { K, 0 });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (visited[cur[0]]) {
				continue;
			}
			for (int[] tmp : al.get(cur[0])) {
				if (minWeight[tmp[1]] > minWeight[cur[0]] + tmp[2]) {
					minWeight[tmp[1]] = minWeight[cur[0]] + tmp[2];
					pq.offer(new int[] { tmp[1], minWeight[tmp[1]] });
				}
			}
			visited[cur[0]] = true;
		}

		for (int i = 1; i <= V; i++) {
			if (minWeight[i] == oo) {
				sb.append("INF");
			} else {
				sb.append(minWeight[i]);
			}
			sb.append('\n');
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	} // end of main
} // end of class
