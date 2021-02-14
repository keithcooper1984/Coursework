import java.util.Arrays;
import java.util.Random;

/**
 * @author Keith Cooper
 * @version 14/02/2021
 * Examples of different sorting algorithms
 * Insertion, bubble, merge, heap and quick sort methods
 */

public class TestingSort {

	public static void main(String[] args) {


		int[] arr = {3, 41, 52, 26, 38, 57, 9, 49};
//		int[] arr = {98, 47, 0, 46, -219, 32, 98, -27};
//		System.out.println("Insertion Sort");
//		System.out.println("INITIAL ARRAY:  " + Arrays.toString(arr));
//		System.out.println("FINAL SORTED ARRAY:  " + Arrays.toString(insertion(arr)) + "\n");
//		
//		System.out.println("Bubble Sort");
//		System.out.println("INITIAL ARRAY:  " + Arrays.toString(arr));
//		System.out.println("FINAL SORTED ARRAY:  " + Arrays.toString(bubble(arr)) + "\n");
		
//		System.out.println("Merge Sort");
//		System.out.println("INITIAL ARRAY:  " + Arrays.toString(arr));
//		System.out.println("FINAL SORTED ARRAY:  " + Arrays.toString(mergeSort(arr)) + "\n");
//		
//		System.out.println("Heap Sort");
//		System.out.println("INITIAL ARRAY:  " + Arrays.toString(arr));
//		System.out.println("FINAL SORTED ARRAY:  " + Arrays.toString(heapSort(arr)) + "\n");
		
		System.out.println("Quick Sort");
		System.out.println("INITIAL ARRAY:  " + Arrays.toString(arr));
		System.out.println("FINAL SORTED ARRAY:  " + Arrays.toString(quickSort(arr, 0, arr.length-1)) + "\n");
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
	
	//Heapsort Methods
	public static int parent(int i)
	{
		return i/2;
	}
	
	public static int left(int i)
	{
		return (2*i)+1;
	}

	public static int right(int i)
	{
		return (2*i)+2;
	}
	
	public static int[] maxHeapify(int[] array, int i)
	{
		int l = left(i);
		int r = right(i);
		int largest;
		System.out.println("Left = " + l + ", Right = " + r + ", i = " + i);
		if (l <= array.length-1 && array[l] > array[i])
		{
			largest = l;
		}
		else 
		{
			largest = i;
		}
		if (r <= array.length-1 && array[r] > array[largest])
		{
			largest = r;
		}
		System.out.println("largest = " + largest);
		System.out.println("Current Array: " + Arrays.toString(array));
		if (largest != i)
		{
			int temp = array [i];
			array[i] = array[largest];
			array[largest] = temp;
			maxHeapify(array,largest);
		}
		return array;
	}
	
	public static int[] maxHeapify(int[] array, int i, int length)
	{
		int l = left(i);
		int r = right(i);
		int largest;
		System.out.println("Left = " + l + ", Right = " + r + ", i = " + i);
		if (l <= length-1 && array[l] > array[i])
		{
			largest = l;
		}
		else 
		{
			largest = i;
		}
		if (r <= length-1 && array[r] > array[largest])
		{
			largest = r;
		}
		System.out.println("largest = " + largest);
		System.out.println("Current Array: " + Arrays.toString(array));
		if (largest != i)
		{
			int temp = array [i];
			array[i] = array[largest];
			array[largest] = temp;
			System.out.println("Hello");
			maxHeapify(array,largest,length);
		}
		return array;
	}
	
	public static int[] buildMaxHeap(int[] array)
	{
		for(int i = ((array.length)/2)-1; i >= 0; i--)
		{
			maxHeapify(array,i);
		}
		return array;
	}
	
	public static int[] heapSort(int[] array)
	{
		buildMaxHeap(array);
		System.out.println("Max Heap Array: " + Arrays.toString(array));
		for (int i = array.length-1; i > 0; i-- )
		{
			int temp = array [0];
			array[0] = array[i];
			array[i] = temp;
			maxHeapify(array,0,i);
		}
		return array;
	}
	
	//QuickSort Methods - randomised
	public static int[] quickSort(int[] array, int first, int last)
	{
		if (first < last)
		{
			int midpoint = partition(array, first, last);
			quickSort(array, first, midpoint-1);
			quickSort(array, midpoint+1, last);
		}
		return array;
	}
	
	public static int partition(int[] array, int first, int last)
	{
		Random rand = new Random();
		int i = (rand.nextInt(last - first)) + first;
		int temp = array[last];
		array[last] = array[i];
		array[i] = temp;
		int pointer = first - 1;
		for (int j = first; j < last; j++)
		{
			if (array[j] <= array[last])
			{
				pointer++;
				temp = array[pointer];
				array[pointer] = array[j];
				array[j] = temp;
			}
		}
		temp = array[pointer + 1];
		array[pointer + 1] = array[last];
		array[last] = temp;
		System.out.println("CURRENT ARRAY:  " + Arrays.toString(array));
		return pointer +1;
	}
}
