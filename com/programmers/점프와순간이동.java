package programmers;

// �� ���� K ĭ��ŭ ������ �����ϰų� ������� �� �Ÿ� x 2�� �ش��ϴ� ��ġ�� �����̵�
// K ĭ�� �����ϸ� K��ŭ �������� �Ҹ��
// N��ŭ ������ ��ҷ� ������
// ������ ��뷮�� ���̱� ���� ������ �̵��ϴ� ���� �ּҷ� �Ϸ��� ��
// ����ؾ� �ϴ� ������ ��뷮�� �ּڰ��� ���϶�

public class �����ͼ����̵� {

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
