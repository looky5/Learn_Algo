import java.util.Arrays;

public class _1012_쿼드압축후개수세기 {

    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[][] arr) {
        return quadTree(arr, 0, 0, arr.length);
    }

    private static int[] quadTree(int[][] arr, int y, int x, int len) {
        int what = CompressibleToWhat(arr, y, x, len);
        if(what == 0) {
            return new int[]{1, 0};
        } else if(what == 1) {
            return new int[]{0, 1};
        }
        len /= 2;
        int[] quad1 = quadTree(arr, y, x, len);
        int[] quad2 = quadTree(arr, y, x + len, len);
        int[] quad3 = quadTree(arr, y + len, x, len);
        int[] quad4 = quadTree(arr, y + len, x + len, len);
        return new int[]{quad1[0] + quad2[0] + quad3[0] + quad4[0],
                quad1[1] + quad2[1] + quad3[1] + quad4[1]};
    }

    private static int CompressibleToWhat(int[][] arr, int y, int x, int len) {
        int pre = arr[y][x];
        for(int i = y; i < y + len; i++) {
            for(int j = x; j < x + len; j++) {
                if(pre != arr[i][j]) {
                    pre = 2;
                    i = y + len;
                    break;
                }
            }
        }
        return pre;
    }
}
