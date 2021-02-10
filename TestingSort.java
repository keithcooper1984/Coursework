import java.util.Arrays;

/**
 * @author Keith Cooper
 * @version 10/02/2021
 * Examples of different sorting algorithms
 */

public class TestingSort {

	public static void main(String[] args) {


		int[] arr = {31, 41, 59, 26, 41, 58};
		System.out.println("Insertion Sort");
		System.out.println("INITIAL ARRAY:  " + Arrays.toString(arr));
		System.out.println("FINAL SORTED ARRAY:  " + Arrays.toString(insertion(arr)) + "\n");
		
		System.out.println("Bubble Sort");
		System.out.println("INITIAL ARRAY:  " + Arrays.toString(arr));
		System.out.println("FINAL SORTED ARRAY:  " + Arrays.toString(bubble(arr)) + "\n");
		
		System.out.println("Merge Sort");
		System.out.println("INITIAL ARRAY:  " + Arrays.toString(arr));
		System.out.println("FINAL SORTED ARRAY:  " + Arrays.toString(mergeSort(arr)) + "\n");
	}

	public static int[] insertion(int[] numIn) {
		for (int j = 1; j < numIn.length; j++) {
			int key = numIn[j];
			int i = j-1;
			while (i >= 0 && numIn[i] > key) {
				numIn[i+1] = numIn[i];
				i = i-1;
			}
			numIn[i+1] = key;
			System.out.println(Arrays.toString(numIn));
		}
		return numIn;
	}

	public static int[] bubble(int[] numIn) {
		for (int i = 0; i < numIn.length; i++) {
			for (int j = 0; j < numIn.length; j++) {
				if(numIn[i] < numIn[j]) {
					int temp = numIn[i];
					numIn[i] = numIn[j];
					numIn[j] = temp;
				}
			}
			System.out.println(Arrays.toString(numIn));
		}
		return numIn;
	}
	
	private static int[] mergeSort(int[] arr) {
		if (arr.length > 1) {
			int p = arr.length-1;
			int r = ((arr.length)/2);
			int[] ArrayLeft = Arrays.copyOfRange(arr, 0, r);
			System.out.println("New Left Array: " + Arrays.toString(ArrayLeft));
			int[] ArrayRight = Arrays.copyOfRange(arr, r, p+1);
			System.out.println("New Right Array: " + Arrays.toString(ArrayRight));
			ArrayLeft = mergeSort(ArrayLeft);
			ArrayRight = mergeSort(ArrayRight);
			System.out.println("Merge Array: " + Arrays.toString(ArrayLeft) + Arrays.toString(ArrayRight));
			arr = merge(ArrayLeft, ArrayRight);
		}
		else
		{
			return arr;
		}
		return arr;				
	}
	
	private static int[] merge(int[] arr1, int[] arr2) {
		int i = 0;
		int j = 0;
		int count = 0;
		int[] combArr = new int[arr1.length + arr2.length];
		while (i<arr1.length && j<arr2.length) {
			if (arr1[i] <= arr2[j]) {
				combArr[count] = arr1[i];
				i++;
			}else {
				combArr[count] = arr2[j];
				j++;
			}
			count++;
		}
		while (i < arr1.length) {
			combArr[count] = arr1[i];
			i++;
			count++;
		}
		while (j < arr2.length) {
			combArr[count] = arr2[j];
			j++;
			count++;
		}
		System.out.println("New Combined Array: " +Arrays.toString(combArr));
		return combArr;
	}

}
