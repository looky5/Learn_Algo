package programmers;

public class _2xn≈∏¿œ∏µ {
	
	static final int LIMIT = 1000000007;

	public static void main(String[] args) {
		int n = 5;
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int[] arr = new int[2];
		arr[0] = 1;
		arr[1] = 2;
		int idx = n == 1 ? 0 : 1;
		int m = 2;
		
		while(m < n) {
			++m;
			idx = idx == 0 ? 1 : 0;
			arr[idx] = (arr[0] + arr[1]) % LIMIT;
		}
		
		return arr[idx];
	}
}
