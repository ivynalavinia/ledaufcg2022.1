package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
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
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (validInputs(array, leftIndex, rightIndex)) {
			
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				
				int j = i;
				
				while (j > leftIndex && array[j].compareTo(array[j - 1]) < 0) {
					Util.swap(array, j, j - 1);
					j--; 
				}
			}
		}
	}
	
}
