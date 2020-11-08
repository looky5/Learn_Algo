public class _1107_피보나치수 {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        if(n == 1) return 1;
        int[] arr = new int[2];
        arr[1] = 1;
        int idx = 1;
        int num = 2;
        while(num <= n) {
            idx = idx == 0 ? 1 : 0;
            arr[idx] = (arr[0] + arr[1]) % 1234567;
            num++;
        }

        return arr[idx];
    }
}
