import java.util.Arrays;

public class quickSort {

	static int[] arr;

	public static void main(String[] args) {
		arr = new int[] { 4, 7, 2, 1, 9, 5, 8, 3, 6, 0 };
//		arr = new int[] { 4, 7, 2, 1, 9 };
		quickSort(0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int left, int right) {
		if (left >= right)
			return;
		int pivot = getPivotNsort(left, right);

		quickSort(left, pivot - 1);
		quickSort(pivot + 1, right);
	}

	private static int getPivotNsort(int left, int right) {
		int low = left;
		int high = right;
		int pivot_val = arr[left];

		while (low < high) {
			while (low < high && pivot_val >= arr[low]) {
				++low;
			}
			while (low <= high && pivot_val <= arr[high]) {
				--high;
			}
			if (low < high)
				swap(low, high);
		}
		if (left < high)
			swap(left, high);
		return high;
	}

	private static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
