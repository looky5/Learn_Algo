package com.programmers;

import java.util.*;

class Truck {
	int weight;
	int startTime;

	public Truck(int weight, int startTime) {
		this.weight = weight;
		this.startTime = startTime;
	}
}

public class _0920_다리를지나는트럭 {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int time = 0;
		int queIdx = 0;
		Queue<Truck> onBridge = new LinkedList<>();
		int bridge_trucks_weight = 0;

		while (!onBridge.isEmpty() || queIdx < truck_weights.length) {
			time++;
			if (!onBridge.isEmpty()) {
				if (time - onBridge.peek().startTime == bridge_length) {
					bridge_trucks_weight -= onBridge.poll().weight;
				}
			}
			if (queIdx < truck_weights.length) {
				if (bridge_trucks_weight + truck_weights[queIdx] <= weight) {
					bridge_trucks_weight += truck_weights[queIdx];
					onBridge.offer(new Truck(truck_weights[queIdx++], time));
				}
			}
		}
		return time;
	}
}
