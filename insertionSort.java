import java.util.Arrays;

public class insertionSort {

	public static void main(String[] args) {
		int[] arr = { 4, 7, 2, 1, 9, 5, 8, 3, 6, 0 };
		int len = arr.length;
		int picked = 0, idx = 0;
		for(int i = 1; i < len; i++) {
			picked = arr[i];
			idx = i - 1;
			while(idx >= 0 && arr[idx] > picked) {
				arr[idx + 1] = arr[idx];
				--idx;
			}
			arr[idx + 1] = picked;
		}
		System.out.println(Arrays.toString(arr));
	}
}
