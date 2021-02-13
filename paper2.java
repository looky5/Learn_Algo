
public class paper2 {

	public static void main(String[] args) {
		System.out.println(Recursive(5));
		System.out.println(Tail_Recursive(5, 1));
	}
	private static int Recursive(int n) {
		if(n == 1) return 1;
		return n + Recursive(n - 1);
	}
	private static int Tail_Recursive(int n, int acc) {
		if(n == 1) return acc;
		int res = Tail_Recursive(n - 1, n + acc);
		return res;
	}
}
