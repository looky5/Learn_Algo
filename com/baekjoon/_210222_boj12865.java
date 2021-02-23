import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210222_boj12865 {

    private static class Stuff {
        int weight;
        int price;

        public Stuff(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    static int N, K, weight_all, price_all;
    static Stuff[] goods;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        goods = new Stuff[N + 1];
        board = new int[N + 1][K + 1];
        weight_all = 0;
        price_all = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            goods[i] = new Stuff(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            weight_all += goods[i].weight;
            price_all += goods[i].price;
        }
        if (weight_all <= K) {
            System.out.println(price_all);
            return;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                board[i][j] = board[i - 1][j];
                if (j < goods[i].weight) continue;
                board[i][j] = board[i][j] < board[i - 1][j - goods[i].weight] + goods[i].price ? board[i - 1][j - goods[i].weight] + goods[i].price : board[i][j];
            }
        }
        System.out.println(board[N][K]);
    }
}
