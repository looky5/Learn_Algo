package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _17135_ĳ�����潺 {

	private static class Archer {
		int y;
		int x;
		int[] target; // y, x, Distance, Index

		public Archer(int y) {
			super();
			this.y = y;
		}

		public void initTarget() {
			if (target == null) {
				target = new int[] { -1, -1, 10000, -1 };
			} else {
				target[0] = -1;
				target[1] = -1;
				target[2] = 10000;
				target[3] = -1;
			}
		}

		public void searchTarget(int r, int c, int idx) {
			int dist = getDistance(y, r, x, c);
			boolean trigger = false;
			if (dist <= D) {
				if (target[2] > dist) {
					trigger = true;
				} else if (target[2] == dist) {
					if (target[1] > c) {
						trigger = true;
					}
				}
			}
			if (trigger) {
				target[0] = r;
				target[1] = c;
				target[2] = dist;
				target[3] = idx;
			}
		}

	}

	private static class Enemy {
		int y;
		int x;
		boolean alive;
		int firstY;
		int firstX;

		public Enemy(int y, int x) {
			super();
			this.y = y;
			this.firstY = y;
			this.x = x;
			this.firstX = x;
			alive = true;
		}

		public void rollbackLoc() {
			y = firstY;
			x = firstX;
			alive = true;
		}

	}

	static int N, M, D, enemyCnt, enemySize, answer;
	static ArrayList<Enemy> enemyList;
	static Archer[] archers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		answer = 0;
		enemyCnt = 0;
		enemyList = new ArrayList<Enemy>();
		archers = new Archer[3];
		for (int i = 0; i < 3; i++) {
			archers[i] = new Archer(N + 1);
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				int k = Integer.parseInt(st.nextToken());
				if (k == 1) {
					enemyList.add(new Enemy(i, j));
					++enemyCnt;
				}
			}
		}
		enemySize = enemyCnt;

		// �ü��� ��ġ�� �������� �����Ѵ�. 3��
		// �ü� ���� -> �Ÿ��� D ������ �� �� ���� ����� ��, �����̶�� ���� ���� ������
		// �ü����� ���ÿ� �����ϹǷ� �ϳ��� ���� ������ ������ �� ����
		// ���� �� ĭ�� �Ʒ��� �̵��ϸ� ���� �����ϸ� �ǿ��� ����
		deploy(0, 0);
		System.out.println(answer);
	}

	private static void deploy(int count, int start) {
		if (count == 3) {
			enemyCnt = enemySize;
			int killCount = letsDefense();
			answer = Math.max(answer, killCount);
			return;
		}
		for (int i = start + 1; i <= M; i++) {
			archers[count].x = i;
			deploy(count + 1, i);
		}
	}

	private static int letsDefense() {
		int kill = 0;
		Enemy enemy;
		for (int i = 0; i < enemySize; i++) {
			enemy = enemyList.get(i);
			enemy.rollbackLoc();
		}
		while (enemyCnt > 0) {
			// �ü� Ÿ�� �ʱ�ȭ
			for (int i = 0; i < 3; i++) {
				archers[i].initTarget();
			}
			// Ÿ���� �� ���� ã�´�.
			for (int i = 0; i < enemySize; i++) {
				enemy = enemyList.get(i);
				if (!enemy.alive)
					continue;
				for (int j = 0; j < 3; j++) {
					archers[j].searchTarget(enemy.y, enemy.x, i);
				}
			}
			// Ÿ���� �� ���� �״´�
			for (int i = 0; i < 3; i++) {
				if (archers[i].target[0] < 0)
					continue;
				enemy = enemyList.get(archers[i].target[3]);
				if (enemy.alive) {
					--enemyCnt;
					++kill;
				}
				enemy.alive = false;
			}
			// ���� �Ʒ��� �� ĭ�� �����̰�, ���� �����ϸ� �ǿ��� ����
			for (int i = 0; i < enemySize; i++) {
				enemy = enemyList.get(i);
				if (!enemy.alive)
					continue;
				if (enemy.y == N) {
					--enemyCnt;
					enemy.alive = false;
				} else {
					++enemy.y;
				}
			}
		}

		return kill;
	}

	private static int getDistance(int r1, int r2, int c1, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}
