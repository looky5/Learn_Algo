import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _210223_boj20920 {

    private static class Word {
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Word> al = new ArrayList<>();
        Map<String, Integer> words = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.setLength(0);
            sb.append(br.readLine());
            if (sb.length() < M) continue;
            if (words.containsKey(sb.toString())) {
                ++al.get(words.get(sb.toString())).count;
                continue;
            }
            al.add(new Word(sb.toString(), 1));
            words.put(sb.toString(), al.size() - 1);
        }
        Collections.sort(al, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int rank1 = o2.count - o1.count;
                if (rank1 == 0) {
                    int rank2 = o2.word.length() - o1.word.length();
                    if (rank2 == 0) {
                        return o1.word.compareTo(o2.word);
                    } else return rank2;
                } else return rank1;
            }
        });
        sb.setLength(0);
        for (Word w : al) {
            sb.append(w.word).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}