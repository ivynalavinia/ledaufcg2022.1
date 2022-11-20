package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
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
			
			while (leftIndex < rightIndex) {
				
				boolean swapped = true;
				
				for (int j = leftIndex; j <= rightIndex - 1; j++) {
				
					if (array[j].compareTo(array[j + 1]) > 0) {
						Util.swap(array, j, j + 1);
						swapped = true;
					}
				}
				
				rightIndex -= 1;
				
				if (swapped) {
					
					for (int j = rightIndex; j > leftIndex; j--) {
						
						if (array[j].compareTo(array[j - 1]) < 0) {
							Util.swap(array, j, j - 1);
						}
					}
					leftIndex += 1;
				}
			}
		}
	}
}
