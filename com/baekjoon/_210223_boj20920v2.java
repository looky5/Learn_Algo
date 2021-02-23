import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _210223_boj20920v2 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map<String, Integer> words = new HashMap<>();
        ArrayList<String> al = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String str;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            if (str.length() < M) continue;
            if (!words.containsKey(str)) al.add(str);
            words.put(str, words.getOrDefault(str, 0) + 1);
        }
        Collections.sort(al, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (words.get(o2) == words.get(o1)) {
                    if (o2.length() == o1.length()) {
                        return o1.compareTo(o2);
                    } else return o2.length() - o1.length();
                } else return words.get(o2) - words.get(o1);
            }
        });
        for (String s : al) {
            sb.append(s).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}