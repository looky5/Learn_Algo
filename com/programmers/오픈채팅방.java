package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// ä�ù濡 ������ ������ ���� �޼��� ���
// ä�ù濡�� ������ ������ ���� �޼��� ���
// �г����� �����ϴ� ����� ä�ù��� ���� ��, ���ο� �г������� �ٽ� ���� or ä�ù濡�� �г��� ����
// �г����� ������ ���� ������ ä�ù濡 �ִ� �޽����� �г��ӵ� ���� ����

public class ����ä�ù� {

	static final String[] words = { "���� ���Խ��ϴ�.", "���� �������ϴ�." };

	private static class Log {
		private String uid;
		private String status;

		public Log(String uid, char ch) {
			super();
			this.uid = uid;
			switch (ch) {
			case 'E':
				this.status = words[0];
				break;
			case 'L':
				this.status = words[1];
			}
		}

		@Override
		public String toString() {
			return user.get(uid) + status;
		}

	}

	static Map<String, String> user;

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));
	}

	private static String[] solution(String[] record) {
		int len = record.length;
		user = new HashMap<String, String>();
		ArrayList<Log> logList = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			String[] tmp = record[i].split(" ");
			switch (tmp[0].charAt(0)) {
			case 'E':
				user.put(tmp[1], tmp[2]);
				logList.add(new Log(tmp[1], 'E'));
				break;
			case 'L':
				logList.add(new Log(tmp[1], 'L'));
				break;
			case 'C':
				user.put(tmp[1], tmp[2]);
			}
		}

		String[] answer = new String[logList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = logList.get(i).toString();
		}

		return answer;
	}
}
