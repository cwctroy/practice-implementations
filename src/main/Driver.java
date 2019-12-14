package main;

import algorithms.Sort;

public class Driver {
	
	public static void testQuickSort() {
		
		System.out.println("Testing quicksort");
		
		int[] array = {1,3,5,7,9,0,2,8,4,0};
		
		Sort.quickSort(array, 0, array.length -1);
		
		for (int num : array) {
			System.out.print(num + " ");
		}		
		System.out.println();
		
		int[] array2 = {9,8,7,6,5,4,3,2,1,0};
		
		Sort.quickSort(array2, 0, array2.length -1);
		
		for (int num : array2) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		int[] array3 = {-9,8,-7,6,-5,4,-3,2,-1,0};
		
		Sort.quickSort(array3, 0, array3.length -1);
		
		for (int num : array3) {
			System.out.print(num + " ");
		}
		System.out.println();
		
	}
	
	public static void testMergeSort() {
		
		System.out.println("Testing mergesort");
		
		int[] array = {1,3,5,7,9,0,2,8,4,0};
		
		Sort.mergeSort(array, 0, array.length -1);
		
		for (int num : array) {
			System.out.print(num + " ");
		}		
		System.out.println();
		
		int[] array2 = {9,8,7,6,5,4,3,2,1,0};
		
		Sort.mergeSort(array2, 0, array2.length -1);
		
		for (int num : array2) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		int[] array3 = {-9,8,-7,6,-5,4,-3,2,-1,0};
		
		Sort.mergeSort(array3, 0, array3.length -1);
		
		for (int num : array3) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		
		testQuickSort();
		
		testMergeSort();
	}
}
