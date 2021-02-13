package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _210203_2750_수정렬하기 {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		quickSort(0, N);
		StringBuilder sb = new StringBuilder();
		for(int n : arr) {
			sb.append(n).append('\n');
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static void quickSort(int start, int end) {
		if (start >= end)
			return;

		int pivot = getPivotNSort(start, end);
		quickSort(start, pivot);
		quickSort(pivot + 1, end);
	}

	private static int getPivotNSort(int start, int end) {
		swap(start, (start + end) / 2);
		int val = arr[start];
		int left = start, right = end - 1;
		while (left <= right) {
			while (left <= right && val >= arr[left])
				++left;
			while (left <= right && val <= arr[right])
				--right;
			if (left < right)
				swap(left, right);
		}
		swap(start, right);
		return right;
	}

	private static void swap(int left, int right) {
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
}
