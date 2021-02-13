import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.Soundbank;

public class paper1 {

	private static class A {
		private int id;
		private String str;

		public A(int id, String str) {
			super();
			this.id = id;
			this.str = str;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}

	}

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		String str = "This is Contents";
		A a = new A(1, str);
		A b = new A(2, str);
		A c = new A(1, str);
		String a_str = "a";
		String b_str = new String("a");
		String c_str = a_str;
		if(a_str == c_str) {
			append(("a_str = c_str"));
		}
		if(a_str == b_str) {
			append("a_str = b_str");
		} else {
			append("a_str != b_str");
		}
		if(a_str.equals(b_str)) {
			append("a_str equals b_str");
		}
		append(a);
		append(b.hashCode());
		append(System.identityHashCode(a));
		append(c.hashCode());
		
		Map<String, Integer> map = new HashMap<>();
		String new_str = new String(str + "1");
		map.put(str, 1);
		map.put(new_str, 2);
		if(str == new_str) {
			append("str = new_str");
		} else {
			append("str != new_str");
		}
		if(str.equals(new_str)) {
			append("str equals new_str");
		} else {
			append("str not equals new_str");
		}
		append(System.identityHashCode(str));
		append(System.identityHashCode(new_str));
		append(map.get(str));
		System.out.println(sb.toString());
	}
	
	private static void append(Object o) {
		sb.append(o).append('\n');
	}
}
