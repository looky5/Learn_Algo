package programmers;

// 여기서 특수기호는 소문자이다.
// 규칙 1. 특정 단어를 선택하여 글자 사이마다 같은 기호를 넣는다. ex) HELLO -> HaEaLaLaO
// 규칙 2. 특정 단어를 선택하여 단어 앞뒤에 같은 기호를 넣는다. ex) WORLD -> bWORLDb
// 위 두가지 규칙은 한 단어에 모두 적용될 수 있지만 같은 규칙은 두 번 적용될 수 없다.
// 한 번 쓰인 특수기호는 다시 쓰일 수 없다.
// 마지막으로 원래 문구에 있떤 공백을 제거한다.

public class 브라이언의고민 {

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
