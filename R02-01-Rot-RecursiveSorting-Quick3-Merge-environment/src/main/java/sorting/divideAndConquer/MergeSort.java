package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	private boolean validInputs(T[] array, int leftIndex, int rightIndex) {
		
		if (array == null || array.length <= 1) {
			return false;
		} else if (leftIndex >= rightIndex || leftIndex < 0) {
			return false;
		} else if (rightIndex >= array.length || leftIndex >= array.length || rightIndex <= 0) {
			return false;
		}
		return true;
	}
	
	private void merge(T[] array, int leftIndex, int rightIndex) {
		T[] helper = (T[]) new Comparable[array.length];
		
		for (int i = leftIndex ; i < rightIndex + 1; i++) {
			helper[i] = array[i];
		}
		
		int i = leftIndex;
		int middle = (leftIndex + rightIndex) / 2;
		int j = middle + 1;
		int k = leftIndex;
		
		while (i <= middle && j <= rightIndex) {
			if (helper[i].compareTo(helper[j]) <= 0) {
				array[k] = helper[i];
				i++;
			} else {
				array[k] = helper[j];
				j++;
			}
			k++;
		}
		
		while (i <= middle) {
			array[k++] = helper[i++];
		}
		while (j <= rightIndex) {
			array[k++] = helper[j++];
		}
	}
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (validInputs(array, leftIndex, rightIndex)) {
			
			int middle = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);
			merge(array, leftIndex, rightIndex);
		}
	}
}
