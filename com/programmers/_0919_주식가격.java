import java.util.Arrays;

public class _0919_주식가격 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];
        answer[size - 1] = 0;
        for(int i = 0; i < size - 1; i++) {
            for(int j = i + 1; j < size; j++) {
                if(prices[i] > prices[j]) {
                    answer[i] = j - i;
                    break;
                }
            }
            if(answer[i] == 0) {
                answer[i] = size - 1 - i;
            }
        }

        return answer;
    }
}
