package programmers;

public class N개의_최소공배수 {

	public static void main(String[] args) {
		int[] arr = { 3, 9, 25, 48, 53 };
		System.out.println(solution(arr));
	}

	public static int solution(int[] arr) {
		int len = arr.length;
		int answer = arr[0];
		for (int i = 1; i < len; i++) {
			int a = answer;
			int b = arr[i];
			answer = a * b / GCD(a, b);
		}

		return answer;
	}
	
	public static int GCD(int a, int b) {
		if(a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while(b % a != 0) {
			int n = b % a;
			b = a;
			a = n;
		}
		
		return a;
	}
}
