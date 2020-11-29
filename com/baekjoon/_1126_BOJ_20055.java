package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1126_BOJ_20055 {

	private static class Belt {
		private boolean RobotOnTop;
		private int durability;

		public Belt(boolean RobotOnTop, int durability) {
			super();
			this.RobotOnTop = RobotOnTop;
			this.durability = durability;
		}

		public boolean haveRobot() {
			return RobotOnTop;
		}

		public void putRobot() {
			--durability;
			RobotOnTop = true;
		}

		public void removeRobot() {
			RobotOnTop = false;
		}

		public int getDurability() {
			return durability;
		}

		@Override
		public String toString() {
			return "Belt [RobotOnTop=" + RobotOnTop + ", durability=" + durability + "]";
		}

	}

	static int N, K, beltLen, left, right, broken, step;
	static Belt[] conveyor;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		beltLen = (N << 1) + 1;
		conveyor = new Belt[beltLen];
		broken = 0;
		step = 0;
		st = new StringTokenizer(br.readLine());
		left = 1;
		right = N;

		for (int i = 1; i < beltLen; i++) {
			conveyor[i] = new Belt(false, Integer.parseInt(st.nextToken()));
		}

		while (broken < K) {
			step++;
			moveConveyor();
			moveRobot();
			if (conveyor[left].getDurability() > 0) {
				conveyor[left].putRobot();
				if (conveyor[left].getDurability() == 0) {
					broken++;
				}
			}
//			System.out.println("step: " + step);
//			for(int i = 1; i < beltLen; i++) {
//				System.out.print(conveyor[i].getDurability() + " ");
//			}
//			System.out.println();
//			System.out.println();
		}

		System.out.println(step);
	}

	private static void moveConveyor() {
		if (--left == 0)
			left = N << 1;
		if (--right == 0)
			right = N << 1;
		conveyor[right].removeRobot();
	}

	private static void moveRobot() {
		int len = N;
		int curLoc = right - 1 == 0 ? N << 1 : right - 1;
		int nextLoc = curLoc == N << 1 ? 1 : curLoc + 1;
		while (len > 0) {
			if (conveyor[curLoc].haveRobot() && !conveyor[nextLoc].haveRobot()
					&& conveyor[nextLoc].getDurability() > 0) {
				conveyor[curLoc].removeRobot();
				conveyor[nextLoc].putRobot();
				if (conveyor[nextLoc].getDurability() == 0) {
					broken++;
				}
				if (nextLoc == right) {
					conveyor[nextLoc].removeRobot();
				}
			}
			if (--curLoc == 0) {
				curLoc = N << 1;
				nextLoc = 1;
			} else {
				nextLoc = curLoc + 1;
			}
			len--;
		}
	}
}
