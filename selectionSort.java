import java.util.Arrays;

public class selectionSort {

	public static void main(String[] args) {
		int[] arr = { 4, 7, 2, 1, 9, 5, 8, 3, 6, 0 };
		int idx = 0, min = 0, len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			min = arr[i];
			idx = i;
			for (int j = i + 1; j < len; j++) {
				if (min > arr[j]) {
					min = arr[j];
					idx = j;
				}
			}
			swap(arr, i, idx, min);
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void swap(int[] arr, int a, int b, int min) {
		arr[b] = arr[a];
		arr[a] = min;
	}
}
