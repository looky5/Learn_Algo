import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] numArr = {1, 2, 2, 567, 84, 7467, 3409, 2, 7, -3};
		int arrLen = numArr.length;
		
		quickSort(numArr, 0, arrLen - 1);
		System.out.println(Arrays.toString(numArr));
	}
	private static void quickSort(int[] numArr, int left, int right) {
		if(left < right) {
			int pivot = sortNgetPivot(numArr, left, right);
			
			quickSort(numArr, left, pivot - 1);
			quickSort(numArr, pivot + 1, right);
		}
	}
	
	private static int sortNgetPivot(int[] numArr, int left, int right) {
		int low = left;
		int high = right + 1;
		int pivot = numArr[left];
		
		do {
			do {
				low++;
			} while(low <= right && numArr[low] < pivot);
			do {
				high--;
			} while(high >= left && numArr[high] > pivot);
			if(low < high) {
				swap(numArr, low, high);
			}
		} while(low < high);
		
		swap(numArr, left, high);
		
		return high;
	}
	private static void swap(int[] numArr, int a_index, int b_index) {
		int tmp = numArr[a_index];
		numArr[a_index] = numArr[b_index];
		numArr[b_index] = tmp;
	}
}
