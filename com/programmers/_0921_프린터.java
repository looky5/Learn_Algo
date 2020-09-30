import java.util.*;

public class _0921_프린터 {

    static class Document {
        int importance;
        boolean isMyRequest;

        public Document(int importance, boolean isMyRequest) {
            this.importance = importance;
            this.isMyRequest = isMyRequest;
        }
    }

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Document> waiting = new LinkedList<>();
        PriorityQueue<Integer> importanceQue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i : priorities) {
            waiting.offer(new Document(i, location == 0 ? true : false));
            importanceQue.offer(i);
            location--;
        }

        while(!waiting.isEmpty()) {
            if(waiting.peek().importance != importanceQue.peek()) {
                waiting.offer(waiting.poll());
            } else {
                answer++;
                if(waiting.poll().isMyRequest) {
                    break;
                }
                importanceQue.poll();
            }
        }

        return answer;
    }
}
