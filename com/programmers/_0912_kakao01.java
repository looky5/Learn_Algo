import java.util.HashMap;
import java.util.Map;

public class _0912_kakao01 {

    public static void main(String[] args) {
        String new_id = ".SfG294-+_....^%";
//        String new_id = "abcdefghijklmn.p";
        System.out.println(solution(new_id));
    }

    public static String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9\\-'_''.']", "");
        new_id = new_id.replaceAll("['.']{2,}", ".");
        new_id = new_id.replaceAll("^['.']", "");
        new_id = new_id.replaceAll("['.']$", "");
        if (new_id.length() == 0) {
            new_id = "a";
        }

        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("['.']$", "");
        }
        sb.append(new_id);
        if (sb.length() <= 2) {
            char c = sb.charAt(sb.length() - 1);
            int len = sb.length();
            for (int i = 0; i < 3 - len; i++) {
                sb.append(c);
            }
        }
        Map<Integer, Integer[]> map = new HashMap<>();
        map.put(3, new Integer[]{0, 1, 2});
        return sb.toString();
    }
}
