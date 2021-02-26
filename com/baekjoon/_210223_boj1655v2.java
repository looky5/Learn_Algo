import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _210223_boj1655v2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int n, a, b;
        for (int i = 0; i < N; ++i) {
            n = Integer.parseInt(br.readLine());
            if (maxHeap.size() == minHeap.size()) maxHeap.offer(n);
            else minHeap.offer(n);
            if (!maxHeap.isEmpty() && !minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                a = minHeap.poll();
                b = maxHeap.poll();
                maxHeap.offer(a);
                minHeap.offer(b);
            }
            sb.append(maxHeap.peek()).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

}
