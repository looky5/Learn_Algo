package programmers;

// ���⼭ Ư����ȣ�� �ҹ����̴�.
// ��Ģ 1. Ư�� �ܾ �����Ͽ� ���� ���̸��� ���� ��ȣ�� �ִ´�. ex) HELLO -> HaEaLaLaO
// ��Ģ 2. Ư�� �ܾ �����Ͽ� �ܾ� �յڿ� ���� ��ȣ�� �ִ´�. ex) WORLD -> bWORLDb
// �� �ΰ��� ��Ģ�� �� �ܾ ��� ����� �� ������ ���� ��Ģ�� �� �� ����� �� ����.
// �� �� ���� Ư����ȣ�� �ٽ� ���� �� ����.
// ���������� ���� ������ �ֶ� ������ �����Ѵ�.

public class ����̾��ǰ�� {

	static final String INVALID = "invalid";
	static int len;
	static boolean[] used;

	public static void main(String[] args) {
//		String sentence = "HaEaLaLaObWORLDb";
		String sentence = "SpIpGpOpNpGJqOqA";
		System.out.println(solution(sentence));
	}

	private static String solution(String sentence) {
		String answer = "";
		used = new boolean[26];
		StringBuilder sb = new StringBuilder(sentence);
		StringBuilder sbsb = new StringBuilder();
		int idx = 0;
		char picked = 0;
		for(int i = 0; i < sb.length(); i++) {
			if(isLowercase(sb.charAt(i))) {
				picked = sb.charAt(i);
				break;
			}
		}
		for(int i = 0; i < sb.length(); i++) {
			
		}
		
		
		return answer;
	}

	private static boolean isSafe(int first, int end) {
		return first >= 0 && end < len && first <= end;
	}

	private static boolean isUppercase(char c) {
		return c >= 'A' && c <= 'Z';
	}
	
	private static boolean isLowercase(char c) {
		return c >= 'a' && c <= 'z';
	}
}
