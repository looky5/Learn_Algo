import java.util.Arrays;

public class bubbleSort {

	public static void main(String[] args) {
		int[] arr = { 4, 7, 2, 1, 9, 5, 8, 3, 6, 0 };
		int len = arr.length;
		for(int i = len - 1; i >= 0; i--) {
			for(int j = 1; j <= i; j++) {
				if(arr[j] < arr[j - 1]) {
					swap(arr, j, j - 1);
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[b];
		arr[b] = arr[a];
		arr[a] = tmp;
	}
}
