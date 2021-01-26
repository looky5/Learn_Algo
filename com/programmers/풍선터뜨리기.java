package programmers;

public class «≥º±≈Õ∂ﬂ∏Æ±‚ {

	static final int oo = (int) 1e9 + 1;

	public static void main(String[] args) {
		int[] a = { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 };
		System.out.println(solution(a));
	}

	private static int solution(int[] a) {
		int answer = 0;
		int len_a = a.length;
		boolean[] check = new boolean[a.length];
		int min_left = oo, min_right = oo;
		for (int i = 0; i < len_a; i++) {
			if (min_left > a[i]) {
				min_left = a[i];
			} else {
				check[i] = true;
			}
		}
		for (int i = len_a - 1; i >= 0; i--) {
			if (min_right > a[i]) {
				min_right = a[i];
				++answer;
			} else if (!check[i]) {
				++answer;
			}
		}

		return answer;
	}
}
