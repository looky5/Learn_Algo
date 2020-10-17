

public class _1013_추석트래픽 {

    private static class timeWindow {
        int start;
        int end;

        public timeWindow(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "timeWindow{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
//        String[] lines = {
//                "2016-09-15 20:59:57.421 0.351s",
//                "2016-09-15 20:59:58.233 1.181s",
//                "2016-09-15 20:59:58.299 0.8s",
//                "2016-09-15 20:59:58.688 1.041s",
//                "2016-09-15 20:59:59.591 1.412s",
//                "2016-09-15 21:00:00.464 1.466s",
//                "2016-09-15 21:00:00.741 1.581s",
//                "2016-09-15 21:00:00.748 2.31s",
//                "2016-09-15 21:00:00.966 0.381s",
//                "2016-09-15 21:00:02.066 2.62s"
//        };
        String[] lines = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
        System.out.println(solution(lines));
    }

    public static int solution(String[] lines) {
        int answer = 0;
        int len = lines.length;
        timeWindow[] arr = new timeWindow[len];

        for(int i = 0; i < len; i++) {
            String[] s = lines[i].split(" ");
            int ms = sToms(s[1]);
            int passTime = (int) (Double.parseDouble(s[2].replace("s", "")) * 1000);
            arr[i] = new timeWindow(ms - passTime + 1, ms);
        }

        for(int i = 0; i < len; i++) {
            int count = 0;
            for(int j = i; j < len; j++) {
                if(arr[j].start > arr[i].end + 999 || arr[j].end < arr[i].start) continue;
                count++;
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }

    private static int sToms(String s) {
        int result = 0;

        String[] dividedTime = s.split(":");
        result += Integer.parseInt(dividedTime[0]) * 3600000;
        result += Integer.parseInt(dividedTime[1]) * 60000;
        result += (int) (Double.parseDouble(dividedTime[2]) * 1000);

        return result;
    }
}
