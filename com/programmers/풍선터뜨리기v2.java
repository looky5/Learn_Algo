package programmers;

import java.util.HashSet;
import java.util.Set;

public class «≥º±≈Õ∂ﬂ∏Æ±‚v2 {

	static final int oo = (int) 1e9 + 1;

	public static void main(String[] args) {
		int[] a = { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 };
		System.out.println(solution(a));
	}

	private static int solution(int[] a) {
		int answer = 0;
		int len_a = a.length;
		Set<Integer> set = new HashSet<>();
		int min_left = oo, min_right = oo;
		for (int i = 0; i < len_a; i++) {
			min_left = min_left > a[i] ? a[i] : min_left;
			min_right = min_right > a[len_a - 1 - i] ? a[len_a - 1 - i] : min_right;
			set.add(min_left);
			set.add(min_right);
		}

		return set.size();
	}
}
