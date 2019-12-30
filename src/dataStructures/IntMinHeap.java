package dataStructures;

import java.util.Arrays;

public class IntMinHeap {
	
	private final int DEFAULT_SIZE = 10;
	
	private int[] array = new int[DEFAULT_SIZE];
	private int capacity = DEFAULT_SIZE;
	private int size = 0;
	
	/***** GETTERS AND SETTERS *****/
	
	private int getLeftChildIndex(int index) {
		return ((index * 2) + 1);
	}
	
	private int getRightChildIndex(int index) {
		return ((index * 2) + 2);
	}	
	
	private int getParentIndex(int index) {
		return ((index - 1) / 2);
	}

	private boolean hasLeftChild(int index) {
		return (getLeftChildIndex(index) < size);
	}
	
	private boolean hasRightChild(int index) {
		return (getRightChildIndex(index) < size);
	}
	
	private boolean hasParent(int index) {
		return (getParentIndex(index) < size);
	}
	
	private int leftChild(int index) {
		return array[getLeftChildIndex(index)];
	}
	
	private int rightChild(int index) {
		return array[getRightChildIndex(index)];
	}
	
	private int parent(int index) {
		return array[getParentIndex(index)];
	}
	
	/***** UTILITY METHODS *****/
 	private void ensureCapacity() {
		if (size == capacity) {
			array = Arrays.copyOf(array, capacity * 2);
		}
		capacity *=2;
	}
 	
 	private void swap(int index1, int index2) {
 		int temp = array[index1];
 		array[index1] = array[index2];
 		array[index2] = temp;
 		
 	}
	
	private void heapifyUp() {
		int index = size - 1;
		
		while (hasParent(index) && parent(index) > array[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
		
	}

	private void heapifyDown() {
		int index = 0;
		
		while(hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			
			if (hasRightChild(index) && leftChild(index) > rightChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if (array[smallerChildIndex] < array[index]) {
				break;
			}
			else {
				swap(smallerChildIndex, index);
				index = smallerChildIndex;
			}
		}		
	}
	
	public void add(int item) {
		ensureCapacity();
		array[size] = item;
		size ++;
		heapifyUp();		
	}
	
	public int peek() {
		return array[0];
	}
	
	public int poll() {
		int item = array[0];
		
		array[0] = array[size - 1];
		heapifyDown();
		size--;
		
		return item;
	}

}
