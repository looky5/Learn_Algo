import java.util.Comparator;
import java.util.PriorityQueue;

class kiosk {
    int number;
    int Time;
    int cnt;

    public kiosk(int number, int Time, int cnt) {
        this.number = number;
        this.Time = Time;
        this.cnt = cnt;
    }
}

public class _1009_coupang20202 {

    public static void main(String[] args) {
        int n = 3;
        String[] customers = {"10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"};
        System.out.println(parsing(customers[0]));
//        System.out.println(solution(n, customers));
    }

    private static int solution(int n, String[] customers) {
        int answer = 0;

        Comparator<kiosk> cprt = new Comparator<kiosk>() {
            @Override
            public int compare(kiosk o1, kiosk o2) {
                if(o1.Time == o2.Time) return o1.number - o2.number;
                else return o1.Time - o2.Time;
            }
        };

        PriorityQueue<kiosk> waitingQue = new PriorityQueue<>(cprt);
        PriorityQueue<kiosk> usingQue = new PriorityQueue<>(cprt);

        for(int i = 0; i < n; i++) {
            waitingQue.add(new kiosk(i, 0, 0));
        }
        for(int i = 0; i < customers.length; i++) {
            int cusTime = parsing(customers[i]);
            if(!waitingQue.isEmpty()) {
                kiosk now = waitingQue.poll();
                usingQue.add(new kiosk(now.number, cusTime, now.cnt + 1));
                answer = Math.max(now.cnt + 1, answer);
            } else {
                while (!usingQue.isEmpty()) {
                    kiosk usednow = usingQue.poll();
                    usingQue.add(new kiosk(usednow.number, cusTime, usednow.cnt + 1));
                    answer = Math.max(usednow.cnt + 1, answer);
                }
            }
        }

        return answer;
    }

    private static int parsing(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        String[] Arr1 = s.split(" ");
        String[] Arr2 = Arr1[0].split("/");
        String[] Arr3 = Arr1[1].split(":");

        sb.append(Arr2[0]).append(Arr2[1]).append(Arr3[0]).append(Arr3[1]).append(Arr3[2]).append(Arr1[2]);
        return Integer.parseInt(sb.toString());
    }
}
