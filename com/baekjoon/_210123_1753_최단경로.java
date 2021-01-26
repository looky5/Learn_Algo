package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _210123_1753_최단경로 {

	private static class Edge implements Comparable<Edge> {
		int end;
		int dist;

		public Edge(int end, int dist) {
			super();
			this.end = end;
			this.dist = dist;
		}

		public int getEnd() {
			return end;
		}

		public int getDist() {
			return dist;
		}

		@Override
		public int compareTo(Edge o) {
			return this.getDist() - o.getDist();
		}

	}

	static final int oo = (int) 1e9;
	static final String INF = "INF";
	static int V, E, K;
	static int[] minDist, parent;
	static boolean[] visited;
	static ArrayList<Edge>[] edge_list;
	static PriorityQueue<Edge> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		minDist = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			minDist[i] = oo;
		}
		parent = new int[V + 1];
		visited = new boolean[V + 1];
		pq = new PriorityQueue<>();
		edge_list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			edge_list[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edge_list[Integer.parseInt(st.nextToken())]
					.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		pq.add(new Edge(K, 0));
		minDist[K] = 0;
		Edge cur;
		int curEnd, tmpEnd, tmpDist;
		while (!pq.isEmpty()) {
			cur = pq.poll();
			curEnd = cur.getEnd();
			if (visited[curEnd])
				continue;
			for (Edge tmp : edge_list[curEnd]) {
				tmpEnd = tmp.getEnd();
				tmpDist = tmp.getDist();
				if (minDist[tmpEnd] > minDist[curEnd] + tmpDist) {
					minDist[tmpEnd] = minDist[curEnd] + tmpDist;
					pq.add(new Edge(tmpEnd, 0));
					parent[tmpEnd] = curEnd;
				}
			}
			visited[cur.getEnd()] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(minDist[i] == oo ? INF : minDist[i]).append('\n');
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= V; i++) {
			stack.clear();
			sb.append(1).append(" to ").append(i).append(" : ");
			if (minDist[i] != oo) {
				int j = i;
				while (j != 1) {
					stack.add(j);
					j = parent[j];
				}
				stack.add(j);
				while (!stack.isEmpty()) {
					sb.append(stack.pop()).append(' ');
				}
				sb.append("/ ").append(minDist[i]).append('\n');
			} else {
				sb.append("Impossible");
			}
		}
		System.out.println(sb.toString());
	}

}
