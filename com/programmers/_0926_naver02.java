import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _0926_naver02 {

    public static void main(String[] args) {
        int n = 9; // [2, 5]
        int[][] edges = {{1, 2}, {1, 3}, {3, 4}, {4, 6}, {4, 7}, {6, 5}, {6, 8}, {7, 0}};
//        int[][] edges = {{0, 2}, {2, 1}, {2, 4}, {3, 5}, {5, 4}, {5, 7}, {7, 6}, {6, 8}};
//        int[][] edges = {{1, 2}, {2, 0}, {0, 3}, {5, 3}, {4, 5}, {5, 6}, {6, 7}, {8, 6}};
        System.out.println(Arrays.toString(solution(n, edges)));
    }

    public static int[] solution(int n, int[][] edges) {
        answer = new int[]{-1, -1};
        int[] check = new int[]{-1, -1};
        combi(n, edges, check, 0, 0);
        return answer;
    }

    static boolean trigger;
    static int[] answer;

    private static void combi(int n, int[][] edges, int[] check, int start, int count) {
        if (trigger) return;
        if (count == 2) {
            if (isThree(n, edges, check)) {
                answer[0] = check[0];
                answer[1] = check[1];
                trigger = true;
            }
            return;
        }
        for (int i = start; i < n - 1; i++) {
            check[count] = i;
            combi(n, edges, check, i + 1, count + 1);
            check[count] = -1;
        }
    }

    private static boolean isThree(int n, int[][] edges, int[] check) {
        boolean[] visited = new boolean[n];
        ArrayList<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            if (i == check[0] || i == check[1]) continue;
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        int[] trees = new int[3];
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                idx++;
                Queue<Integer> que = new LinkedList<>();
                que.offer(i);
                while(!que.isEmpty()) {
                    int node = que.poll();
                    if(visited[node]) continue;
                    visited[node] = true;
                    trees[idx]++;
                    int size = list[node].size();
                    for(int j = 0; j < size; j++) {
                        que.offer(list[node].get(j));
                    }
                }
            }
        }
        System.out.println(Arrays.toString(trees));
        for(int i = 0; i < 3; i++) {
            if(trees[i] != n / 3) return false;
        }
        return true;
    }
}
