import java.util.ArrayList;
import java.util.Arrays;

public class _1104_square {
    public static void main(String[] args) {
        int[][] v = {{14, 6}, {7, 4}, {14, 4}};
        System.out.println(Arrays.toString(solution(v)));
    }
    public static int[] solution(int[][] v) {
        ArrayList<Integer> arr_y = new ArrayList<>();
        ArrayList<Integer> arr_x = new ArrayList<>();

        for(int[] point : v) {
            if(arr_x.contains(point[0])) arr_x.remove((Object)point[0]);
            else arr_x.add(point[0]);
            if(arr_y.contains(point[1])) arr_y.remove((Object)point[1]);
            else arr_y.add(point[1]);
        }

        for(int n : arr_x) {
            System.out.println("x_n : " + n);
        }
        for(int n : arr_y) {
            System.out.println("y_n : " + n);
        }

        return new int[]{arr_x.get(0), arr_y.get(0)};
    }
}
