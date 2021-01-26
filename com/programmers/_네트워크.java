package programmers;

import java.util.HashSet;
import java.util.Set;

public class _네트워크 {

	public static void main(String[] args) {
		int n = 4;
		int[][] computers = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 1, 1, 0, 1 } };
		System.out.println(solution(n, computers));
	}

	static int[] parent, rank;

	public static int solution(int n, int[][] computers) {
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
		int pNode;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == i || computers[i][j] == 0)
					continue;
				union(i, j);
			}
		}
		Set<Integer> networks = new HashSet<>();
		for (int node : parent) {
			networks.add(findParent(node));
		}

		return networks.size();
	}

	private static int findParent(int node) {
		if (parent[node] == node) {
			return node;
		} else {
			return parent[node] = findParent(parent[node]);
		}
	}

	private static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);

		if (x == y)
			return;
		if (rank[x] < rank[y]) {
			parent[x] = y;
		} else {
			parent[y] = x;
			if (rank[x] == rank[y]) {
				++rank[x];
			}
		}
	}
}
