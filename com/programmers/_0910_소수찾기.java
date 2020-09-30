public class _0910_소수찾기 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        boolean[] arr = new boolean[n + 1];
        for(int i = 2; i <= n; i++){
            if(arr[i] == true) continue;
            answer++;
            for(int j = i; j <= n; j += i){
                arr[j] = true;
            }
        }

        return answer;
    }
}
