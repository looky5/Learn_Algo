package programmers;

public class 소수만들기 {

	static int sosuCase, arrSize;
	static int[] numbers;

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(solution(nums));
	}

	private static int solution(int[] nums) {
		numbers = nums.clone();
		sosuCase = 0;
		arrSize = nums.length;
		dfs(0, 0, 0);
		int answer = sosuCase;
		return answer;
	}

	private static void dfs(int start, int count, int sum) {
		if (count == 3) {
			if (isSosu(sum)) {
				++sosuCase;
			}
			return;
		}
		for (int i = start; i < arrSize; i++) {
			dfs(i + 1, count + 1, sum + numbers[i]);
		}
	}

	private static boolean isSosu(int n) {
		int n_sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= n_sqrt; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
