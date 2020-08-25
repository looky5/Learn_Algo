//package com.baekjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class _0823_13549 {
//	private static class Node implements Comparable<Node> {
//		int index;
//		int seconds;
//		public Node(int index, int seconds) {
//			super();
//			this.index = index;
//			this.seconds = seconds;
//		}
//		@Override
//		public int compareTo(Node o) {
//			return this.seconds - o.seconds;
//		}
//		
//	}
//	
//	static final int MAX = 100001;
//	static int N, K;
//	static int[] map;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		map = new int[MAX];
//		Arrays.fill(map, MAX);
//		N = Integer.parseInt(st.nextToken());
//		K = Integer.parseInt(st.nextToken());
//
//		
//	} // end of main
//	private static int dijkstra() {
//		PriorityQueue<Node> pq = new PriorityQueue<>();
//		map[N] = 0;
//		pq.offer(new Node(N, 0));
//		
//		while(!pq.isEmpty()) {
//			Node cur = pq.poll();
//			
//			int curIdx = cur.index;
//			int curScds = cur.seconds;
//			
//			if(curIdx == K) {
//				return curScds;
//			}
//			
//			if(curIdx * 2 < MAX) {
//				if(map[curIdx * 2] > curScds) {
//					map[curIdx * 2] = curScds;
//					pq.offer(new Node(curIdx * 2, curScds));
//				}
//			}
//			
//			if(curIdx + 1 < MAX) {
//				if(map[curIdx + 1] > curScds + 1) {
//					
//				}
//			}
//		}
//	}
//} // end of class
