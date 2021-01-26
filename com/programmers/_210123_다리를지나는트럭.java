package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class _210123_다리를지나는트럭 {

	private static class Truck {
		private int startTime;
		private int weight;

		public Truck(int startTime, int weight) {
			super();
			this.startTime = startTime;
			this.weight = weight;
		}

		public int getStartTime() {
			return startTime;
		}

		public int getWeight() {
			return weight;
		}

	}

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	private static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int truckCnt = truck_weights.length;
		int truck_idx = 0;
		int bridge_weight = 0;
		Queue<Truck> bridge = new LinkedList<>();

		Truck truck;
		while (!bridge.isEmpty() || truck_idx < truckCnt) {
			++answer;
			truck = bridge.peek();
			if (truck != null && answer - truck.getStartTime() == bridge_length) {
				bridge_weight -= truck.getWeight();
				bridge.poll();
			}
			if (truck_idx < truckCnt && bridge_weight + truck_weights[truck_idx] <= weight) {
				bridge.add(new Truck(answer, truck_weights[truck_idx]));
				bridge_weight += truck_weights[truck_idx++];
			}
		}
		
		return answer;
	}
}
