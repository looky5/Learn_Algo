package programmers;

// 한 번에 K 칸만큼 앞으로 점프하거나 현재까지 온 거리 x 2에 해당하는 위치로 순간이동
// K 칸을 점프하면 K만큼 건전지가 소모됨
// N만큼 떨어진 장소로 가야함
// 건전지 사용량을 줄이기 위해 점프로 이동하는 것은 최소로 하려고 함
// 사용해야 하는 건전지 사용량의 최솟값을 구하라

public class 점프와순간이동 {

	public static void main(String[] args) throws Exception {
		int N = 11;
		System.out.println(solution(N));
	}

	private static int solution(int N) {
		int answer = 0;
		answer = caseOdd(N, 0);
		return answer;
	}

	private static int caseOdd(int N, int answer) {
		while (N % 2 == 0 && N > 0) {
			N /= 2;
		}
		if (N == 1) {
			return 1;
		} else {
			return caseOdd(N - 1, answer) + 1;
		}
	}

}
