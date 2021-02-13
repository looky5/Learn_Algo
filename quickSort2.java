import java.util.Arrays;

public class quickSort2 {

	static int[] arr;

	public static void main(String[] args) {
		arr = new int[] { 4, 7, 2, 1, 9, 5, 8, 3, 6, 0 };
//		arr = new int[] { 2, 1, 4, 9, 7 };
//		arr = new int[] { 4, 2, 1, 7, 9 };
		quickSort(0, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int left, int right) {
		if(left >= right) return;
		int pivot = getPivotNsort(left, right);
		
		quickSort(left, pivot);
		quickSort(pivot + 1, right);
	}

	private static int getPivotNsort(int left, int right) {
		swap(left, (left + right) / 2);
		int val = arr[left];
		int low = left + 1, high = right - 1;
		while(low <= high) {
			while(low <= high && val >= arr[low]) ++low;
			while(low <= high && val <= arr[high]) --high;
			if(low < high) swap(low, high);
		}
		swap(left, high);
		return high;
	}

	private static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
