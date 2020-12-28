package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5373 {

//	0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오
	static char[][][] cube_init = { { { 'w', 'w', 'w' }, { 'w', 'w', 'w' }, { 'w', 'w', 'w' } },
			{ { 'y', 'y', 'y' }, { 'y', 'y', 'y' }, { 'y', 'y', 'y' } },
			{ { 'r', 'r', 'r' }, { 'r', 'r', 'r' }, { 'r', 'r', 'r' } },
			{ { 'o', 'o', 'o' }, { 'o', 'o', 'o' }, { 'o', 'o', 'o' } },
			{ { 'g', 'g', 'g' }, { 'g', 'g', 'g' }, { 'g', 'g', 'g' } },
			{ { 'b', 'b', 'b' }, { 'b', 'b', 'b' }, { 'b', 'b', 'b' } } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < testCase; tc++) {
			char[][][] cube2 = new char[6][3][3];
			char[][][] cube = new char[6][3][3];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					System.arraycopy(cube_init[i][j], 0, cube[i][j], 0, 3);
				}
			}
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				String step = st.nextToken();
				char aspect = step.charAt(0);
				char dir = step.charAt(1);
				char[] tmp = new char[3];
				switch (aspect) {
				case 'U': // 윗면,아랫면 제외 나머지 0번째 행 회전
					if (dir == '+') { // 시계 방향
						rotate(cube[0], 0);
						for (int k = 0; k < 3; k++) {
							tmp[k] = cube[2][0][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[2][0][k] = cube[5][0][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[5][0][k] = cube[3][0][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[3][0][k] = cube[4][0][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[4][0][k] = tmp[k];
						}
					} else { // 반시계 방향
						rotate(cube[0], 1);
						for (int k = 0; k < 3; k++) {
							tmp[k] = cube[2][0][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[2][0][k] = cube[4][0][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[4][0][k] = cube[3][0][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[3][0][k] = cube[5][0][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[5][0][k] = tmp[k];
						}
					}
					break;
				case 'D': // 윗면,아랫면 제외 나머지 2번째 행 회전
					if (dir == '+') {
						rotate(cube[1], 0);
						for (int k = 0; k < 3; k++) {
							tmp[k] = cube[2][2][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[2][2][k] = cube[4][2][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[4][2][k] = cube[3][2][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[3][2][k] = cube[5][2][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[5][2][k] = tmp[k];
						}
					} else {
						rotate(cube[1], 1);
						for (int k = 0; k < 3; k++) {
							tmp[k] = cube[2][2][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[2][2][k] = cube[5][2][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[5][2][k] = cube[3][2][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[3][2][k] = cube[4][2][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[4][2][k] = tmp[k];
						}
					}
					break;
				case 'F': // 윗면 2번쨰 행 회전, 아랫면 2번째 행 회전, 왼쪽면 2번쨰 열 회전, 오른쪽면 0번쨰 열 회전
					if (dir == '+') {
						rotate(cube[2], 0);
						for (int k = 0; k < 3; k++) {
							tmp[k] = cube[0][2][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[0][2][2 - k] = cube[4][k][2];
						}
						for (int k = 0; k < 3; k++) {
							cube[4][2 - k][2] = cube[1][2][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[1][2][k] = cube[5][k][0];
						}
						for (int k = 0; k < 3; k++) {
							cube[5][k][0] = tmp[k];
						}
					} else {
						rotate(cube[2], 1);
						for (int k = 0; k < 3; k++) {
							tmp[k] = cube[0][2][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[0][2][k] = cube[5][k][0];
						}
						for (int k = 0; k < 3; k++) {
							cube[5][k][0] = cube[1][2][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[1][2][2 - k] = cube[4][k][2];
						}
						for (int k = 0; k < 3; k++) {
							cube[4][2 - k][2] = tmp[k];
						}
					}
					break;
				case 'B': // 윗면 0번째 행 회전, 아랫면 0번째 행 회전, 왼쪽면 0번쨰 열 회전, 오른쪽면 2번째 열 회전
					if (dir == '+') {
						rotate(cube[3], 0);
						for (int k = 0; k < 3; k++) {
							tmp[k] = cube[0][0][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[0][0][k] = cube[5][k][2];
						}
						for (int k = 0; k < 3; k++) {
							cube[5][k][2] = cube[1][0][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[1][0][2 - k] = cube[4][k][0];
						}
						for (int k = 0; k < 3; k++) {
							cube[4][2 - k][0] = tmp[k];
						}
					} else {
						rotate(cube[3], 1);
						for (int k = 0; k < 3; k++) {
							tmp[k] = cube[0][0][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[0][0][2 - k] = cube[4][k][0];
						}
						for (int k = 0; k < 3; k++) {
							cube[4][2 - k][0] = cube[1][0][k];
						}
						for (int k = 0; k < 3; k++) {
							cube[1][0][k] = cube[5][k][2];
						}
						for (int k = 0; k < 3; k++) {
							cube[5][k][2] = tmp[k];
						}
					}
					break;
				case 'L': // 윗면 0번째 열 회전, 아랫면 2번째 열 회전, 앞면 0번째 열 회전, 뒷면 2번째 열 회전
					if (dir == '+') {
						rotate(cube[4], 0);
						for (int k = 0; k < 3; k++) {
							tmp[k] = cube[0][k][0];
						}
						for (int k = 0; k < 3; k++) {
							cube[0][2 - k][0] = cube[3][k][2];
						}
						for (int k = 0; k < 3; k++) {
							cube[3][k][2] = cube[1][k][2];
						}
						for (int k = 0; k < 3; k++) {
							cube[1][2 - k][2] = cube[2][k][0];
						}
						for (int k = 0; k < 3; k++) {
							cube[2][k][0] = tmp[k];
						}
					} else {
						rotate(cube[4], 1);
						for (int k = 0; k < 3; k++) {
							tmp[k] = cube[0][k][0];
						}
						for (int k = 0; k < 3; k++) {
							cube[0][k][0] = cube[2][k][0];
						}
						for (int k = 0; k < 3; k++) {
							cube[2][2 - k][0] = cube[1][k][2];
						}
						for (int k = 0; k < 3; k++) {
							cube[1][k][2] = cube[3][k][2];
						}
						for (int k = 0; k < 3; k++) {
							cube[3][2 - k][2] = tmp[k];
						}
					}
					break;
				case 'R': // 윗면 2번쨰 열 회전, 아랫면 0번쨰 열 회전, 앞면 2번쨰 열 회전, 뒷면 0번쨰 열 회전
					if (dir == '+') {
						rotate(cube[5], 0);
						for (int k = 0; k < 3; k++) {
							tmp[k] = cube[0][k][2];
						}
						for (int k = 0; k < 3; k++) {
							cube[0][k][2] = cube[2][k][2];
						}
						for (int k = 0; k < 3; k++) {
							cube[2][2 - k][2] = cube[1][k][0];
						}
						for (int k = 0; k < 3; k++) {
							cube[1][k][0] = cube[3][k][0];
						}
						for (int k = 0; k < 3; k++) {
							cube[3][2 - k][0] = tmp[k];
						}
					} else {
						rotate(cube[5], 1);
						for (int k = 0; k < 3; k++) {
							tmp[k] = cube[0][k][2];
						}
						for (int k = 0; k < 3; k++) {
							cube[0][2 - k][2] = cube[3][k][0];
						}
						for (int k = 0; k < 3; k++) {
							cube[3][k][0] = cube[1][k][0];
						}
						for (int k = 0; k < 3; k++) {
							cube[1][2 - k][0] = cube[2][k][2];
						}
						for (int k = 0; k < 3; k++) {
							cube[2][k][2] = tmp[k];
						}
					}
					break;
				}
//				for (int j = 0; j < 6; j++) {
//					for (int i = 0; i < 3; i++) {
//						System.out.println(Arrays.toString(cube[j][i]));
//					}
//					System.out.println("*************************");
//				}
//				System.out.println("----------------------------------");
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					sb.append(cube[0][i][j]);
				}
				sb.append('\n');
			}
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		}

	} // end of main

	private static void rotate(char[][] oneSide, int dir) {
		char[][] tempCube = new char[3][3];
		if (dir == 0) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					tempCube[j][2 - i] = oneSide[i][j];
				}
			}
			for (int i = 0; i < 3; i++) {
				System.arraycopy(tempCube[i], 0, oneSide[i], 0, 3);
			}
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					tempCube[2 - j][i] = oneSide[i][j];
				}
			}
			for (int i = 0; i < 3; i++) {
				System.arraycopy(tempCube[i], 0, oneSide[i], 0, 3);
			}
		}
	}
}
