//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//class point1009 {
//    int y;
//    int x;
//    int tip;
//    boolean[] visited;
//
//    public point1009(int y, int x, int tip, boolean[] visited) {
//        this.y = y;
//        this.x = x;
//        this.tip = tip;
//        this.visited = visited;
//    }
//}
//
//public class _1009_coupang20103 {
//
//    public static void main(String[] args) {
//        int r = 3;
//        int[][] delivery = {{1, 5}, {8, 3}, {4, 2}, {2, 3}, {3, 1}, {3, 2}, {4, 2}, {5, 2}, {4, 1}};
//        System.out.println();
//        System.out.println(solution(r, delivery));
//    }
//
//    static int[] dy = {-1, 0, 1, 0};
//    static int[] dx = {0, 1, 0, -1};
//
//    private static int solution(int r, int[][] delivery) {
//        int answer = 0;
//
//        PriorityQueue<point1009> pq = new PriorityQueue<>(new Comparator<point1009>() {
//            @Override
//            public int compare(point1009 o1, point1009 o2) {
//                return o2.tip - o1.tip;
//            }
//        });
//
//        int maxTime = 0;
//        for(int i = 0; i < r; i++) {
//            for(int j = 0; j < r; j++) {
//                maxTime = Math.max(maxTime, delivery[i * r + j][0]);
//            }
//        }
//
//        int time = 0;
//        pq.add(new point1009(0, 0, delivery[0][1]));
//        while(!pq.isEmpty()) {
//            int size = pq.size();
//            for(int i = 0; i < size; i++) {
//                point1009 now = pq.poll();
//                System.out.println(now.tip);
//                answer = Math.max(answer, now.tip);
//                for(int d = 0; d < 4; d++) {
//                    int ny = now.y + dy[d];
//                    int nx = now.x + dx[d];
//                    if(ny < 0 || nx < 0 || ny >= r || nx >= r) continue;
//                    if(delivery[ny * r + nx][0] < time + 1) {
//                        pq.add(new point1009(ny, nx, now.tip));
//                    } else {
//                        pq.add(new point1009(ny, nx, now.tip + delivery[ny * r + nx][1]));
//                    }
//                }
//            }
//            if(maxTime == time) break;
//            time++;
//        }
//
//        return answer;
//    }
//
//}
