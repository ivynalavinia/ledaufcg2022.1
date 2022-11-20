package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
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
			
			for (int lowerIndex = leftIndex; lowerIndex < (rightIndex + 1); lowerIndex++) {
				
				int i = lowerIndex;
				
				for (int j = i + 1; j < rightIndex + 1; j++) {
					if (array[j].compareTo(array[i]) < 0) {
						i = j;
					}
				}
				Util.swap(array, lowerIndex, i);
			}
		}
	}
}
