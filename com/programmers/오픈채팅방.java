package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 채팅방에 누군가 들어오면 입장 메세지 출력
// 채팅방에서 누군가 나가면 퇴장 메세지 출력
// 닉네임을 변경하는 방법은 채팅방을 나간 후, 새로운 닉네임으로 다시 들어가기 or 채팅방에서 닉네임 변경
// 닉네임을 변경할 때는 기존에 채팅방에 있던 메시지의 닉네임도 전부 변경

public class 오픈채팅방 {

	static final String[] words = { "님이 들어왔습니다.", "님이 나갔습니다." };

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
