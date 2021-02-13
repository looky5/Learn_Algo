package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _210211_гу╫бец╫ц©Д╠щ {

	private static class Node implements Comparable<Node> {
		private int destination;
		private int cost;

		public Node(int destination, int cost) {
			super();
			this.destination = destination;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) {
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
				{ 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };
		System.out.println(solution(n, s, a, b, fares));
	}

	static ArrayList<ArrayList<Node>> al;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static boolean[][] visited;
	static int[][] minCost;
	static final int INF = (int) 2e9;

	public static int solution(int n, int s, int a, int b, int[][] fares) {
		al = new ArrayList<>();
		visited = new boolean[n + 1][n + 1];
		minCost = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			Arrays.fill(minCost[i], INF);
		}
		for (int i = 0; i <= n; i++) {
			al.add(new ArrayList<>());
		}
		int fares_len = fares.length;
		for (int i = 0; i < fares_len; i++) {
			al.get(fares[i][0]).add(new Node(fares[i][1], fares[i][2]));
			al.get(fares[i][1]).add(new Node(fares[i][0], fares[i][2]));
		}

		Dijkstra(s);
		Dijkstra(a);
		Dijkstra(b);

		int cost = minCost[s][a] + minCost[s][b];
		for (int i = 1; i <= n; i++) {
			cost = Math.min(cost, minCost[s][i] + minCost[i][a] + minCost[i][b]);
		}

		return cost;
	}

	public static void Dijkstra(int start) {
		minCost[start][start] = 0;
		pq.clear();
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (visited[start][now.destination])
				continue;
            if (now.cost > minCost[start][now.destination])
				continue;
			for (Node d : al.get(now.destination)) {
				if (now.cost + d.cost < minCost[start][d.destination]) {
					minCost[start][d.destination] = now.cost + d.cost;
					minCost[d.destination][start] = now.cost + d.cost;

					pq.add(new Node(d.destination, minCost[start][d.destination]));
				}
			}
			visited[start][now.destination] = true;
		}
	}
}
