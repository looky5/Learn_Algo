import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210222_boj12865v2 {

    private static class Stuff {
        int weight;
        int price;

        public Stuff(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    static int N, K;
    static Stuff[] goods;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        goods = new Stuff[N + 1];
        board = new int[K + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            goods[i] = new Stuff(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int f = K; f >= goods[i].weight; f--) {
                board[f] = board[f] < board[f - goods[i].weight] + goods[i].price ? board[f - goods[i].weight] + goods[i].price : board[f];
            }
        }
        System.out.println(board[K]);
    }
}
