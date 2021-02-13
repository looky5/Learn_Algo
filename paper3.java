import java.util.Arrays;

public class paper3 {

	static int[][] map;
	static int N, M;

	public static void main(String[] args) {
		N = 101;
		M = 101;
		map = new int[N][M];
		StringBuilder sb = new StringBuilder();
		map[0][0] = 1;
		dfs1(0, 0);
		for(int i = 0; i < N; i++) {
			sb.append(Arrays.toString(map[i])).append('\n');
		}
		System.out.println(sb.toString());
	}

	static int[][] dyx = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void dfs1(int y, int x) {
		for(int d = 0; d < 4; d++) {
			int ny = y + dyx[d][0];
			int nx = x + dyx[d][1];
			if(!checkMap(ny, nx) || map[ny][nx] == 1) continue;
			map[ny][nx] = 1;
			dfs1(ny, nx);
		}
	}
	
	public static boolean checkMap(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}
}
