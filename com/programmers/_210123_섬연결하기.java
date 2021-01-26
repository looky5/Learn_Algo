package programmers;

import java.util.PriorityQueue;

public class _210123_º∂ø¨∞·«œ±‚ {

	private static class Vector implements Comparable<Vector> {
		private int node;
		private int destination;
		private int distance;

		public Vector(int node, int destination, int distance) {
			super();
			this.node = node;
			this.destination = destination;
			this.distance = distance;
		}

		public int getNode() {
			return node;
		}

		public void setNode(int node) {
			this.node = node;
		}

		public int getDestination() {
			return destination;
		}

		public void setDestination(int destination) {
			this.destination = destination;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		@Override
		public int compareTo(Vector o) {
			return this.getDistance() - o.getDistance();
		}

	}

	static int[] parent, rank;

	public static void main(String[] args) {
		int n = 4;
		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
		System.out.println(solution(n, costs));
	}

	public static int solution(int n, int[][] costs) {
		int answer = 0;
		int costs_count = costs.length;
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		rank = new int[n];
		PriorityQueue<Vector> pq = new PriorityQueue<>();
		for (int i = 0; i < costs_count; i++) {
			pq.add(new Vector(costs[i][0], costs[i][1], costs[i][2]));
		}
		
		Vector curVector;
		for(int i = 0; i < costs_count; i++) {
			curVector = pq.poll();
			if(findParent(curVector.getNode()) == findParent(curVector.getDestination())) {
				continue;
			}
			union(curVector.getNode(), curVector.getDestination());
			answer += curVector.getDistance();
		}

		return answer;
	}

	private static int findParent(int node) {
		if (parent[node] == node) {
			return node;
		} else {
			return parent[node] = findParent(parent[node]);
		}
	}

	private static void union(int node1, int node2) {
		int node1_parent = findParent(node1);
		int node2_parent = findParent(node2);

		if (node1_parent == node2_parent) {
			return;
		}
		if (rank[node1_parent] < rank[node2_parent]) {
			parent[node1_parent] = node2_parent;
		} else {
			parent[node2_parent] = node1_parent;
			if (rank[node1_parent] == rank[node2_parent]) {
				++rank[node1_parent];
			}
		}
	}
}
