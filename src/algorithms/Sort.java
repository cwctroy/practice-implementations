package algorithms;

import java.util.Arrays;

public class Sort {
	
	private static void swap(int[] array, int indexA, int indexB) {
		
		int placeHolder = array[indexA];
		
		array[indexA] = array[indexB];
		
		array[indexB] = placeHolder;
		
	}
	
	public static void quickSort(int[] array, int leftIndex, int rightIndex) {
		
		int middleIndex = ((rightIndex + leftIndex)/2);
		
		//base case
		if ((rightIndex - leftIndex) < 2 || leftIndex >= rightIndex) {
			return;
		}
		
		boolean sorted = false;
			
		//select pivot
		int pivot;
		int left = array[leftIndex];
		int middle = array[middleIndex];
		int right = array[rightIndex];
		if ( (left >= middle && left <= right) || (left<= middle && left >= right)) {
			pivot = leftIndex;
		}
		else if ( (middle >= left && middle <= right) || (middle<= left && middle >= right)) {
			pivot = middleIndex;
		}
		else {
			pivot = rightIndex;
		}		
		
		//place pivot at end of array
		swap(array, pivot, rightIndex);
		pivot = rightIndex;
		
		while(!sorted) {			
			int itemFromLeft = leftIndex;
			int itemFromRight = rightIndex - 1;
			
			//find first item from left that is larger than pivot
			while (array[itemFromLeft] <= array[pivot] && itemFromLeft < rightIndex) {				
				itemFromLeft++;				
			}
			
			//find first item from right that is smaller than pivot
			while (array[itemFromRight] >= array[pivot] && itemFromRight > leftIndex) {				
				itemFromRight--;				
			}
			
			if (itemFromLeft < itemFromRight) {				
				swap(array, itemFromLeft, itemFromRight);				
			}
			
			else {				
				sorted = true;
				swap(array, itemFromLeft, pivot);
				quickSort(array, leftIndex, itemFromRight);
				quickSort(array, (itemFromLeft), (rightIndex));
			}
		}		
	}
	
	public static int[] mergeSort(int[] array, int leftIndex, int rightIndex) {
		
		int length = (rightIndex - leftIndex) +1;
		
		//if array is size 1, exit
		if (length < 2) {
			return Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
		}
		
		
		else {
			
			int middleIndex = (rightIndex + leftIndex)/2;
			
			//split the array in half and sort each half
			int[]leftArray = mergeSort(array, leftIndex, middleIndex);
			int[] rightArray = mergeSort(array, middleIndex + 1, rightIndex);
			int[] sortedArray = new int[length];
			
			//merge the two sorted sub-arrays
			int leftCounter = 0;
			int rightCounter = 0;
			for (int i = leftIndex; i <= rightIndex; i++) {
				
				//if either array is empty, place remainder of other array into sorted array
				if (leftCounter == leftArray.length) {
					for (int j = i; j < rightIndex; j++) {
						sortedArray[j] = rightArray[rightCounter];
					}
					break;
				}
				else if (rightCounter == rightArray.length) {
					for (int j = i; j < rightIndex; j++) {
						sortedArray[j] = leftArray[leftCounter];
					}
					break;
				}
				
				//else, place smallest number into sortedArray
				else {
				
					if (leftArray[leftCounter] < rightArray[rightCounter]) {
						sortedArray[i] = leftArray[leftCounter];
						leftCounter++;
					}
					else {
						sortedArray[i] = rightArray[rightCounter];
						rightCounter++;
					}
				}
			}
			return sortedArray;
		}
		
		
	}
	

}
