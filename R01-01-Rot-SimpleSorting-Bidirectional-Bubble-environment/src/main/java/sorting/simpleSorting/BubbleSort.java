package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
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
			
			for (int i = leftIndex; i < rightIndex; i++) {

				for (int j = i + 1; j <= rightIndex; j++) {
					
					if (array[i].compareTo(array[j]) > 0) {
						Util.swap(array, i, j);
					}
				}
			}
		}
	}
}
