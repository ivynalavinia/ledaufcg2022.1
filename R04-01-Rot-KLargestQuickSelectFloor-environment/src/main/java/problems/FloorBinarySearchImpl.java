package problems;
import util.Util;

public class FloorBinarySearchImpl implements Floor {
	
  	private void sortThree(Integer[] array, int leftIndex, int center, int rightIndex) {
  		
  		if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
  			Util.swap(array, leftIndex, rightIndex);
  		}
  		
  		if (array[center].compareTo(array[rightIndex]) > 0) {
  			Util.swap(array, center, rightIndex);
  		}
  		
  		if (array[leftIndex].compareTo(array[center]) > 0) {
  			Util.swap(array, leftIndex, center);
  		}
  	}

	private int partition(Integer[] array, int leftIndex, int rightIndex) {

		Integer pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			
			if (array[j].compareTo(pivot) <= 0) {
				i += 1;
				Util.swap(array, j, i);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;
	}

	private void sort(Integer[] array, Integer leftIndex, Integer rightIndex) {
		
		if (leftIndex < rightIndex) {
			
			int center = (rightIndex + leftIndex) / 2;
			
	  		sortThree(array, leftIndex, center, rightIndex);
	  		
	  		Util.swap(array, leftIndex, center);
	  		
			int pivot = partition(array, leftIndex, rightIndex);
			
			this.sort(array, leftIndex, pivot - 1);
			this.sort(array, pivot + 1, rightIndex);
		}
	}

	private Integer floorBinarySearch(Integer[] array, Integer x, Integer leftIndex, Integer rightIndex) {
		
		if (leftIndex <= rightIndex) {
			
			int middle = (leftIndex + rightIndex) / 2;
			Integer elem = array[middle];

			if (elem.compareTo(x) == 0) {
				return elem;
			}
			if (elem.compareTo(x) < 0) {
				int result = floorBinarySearch(array, x, middle + 1, rightIndex);
				return result == -1 ? elem : result;
			}
			if (elem.compareTo(x) > 0) {
				return floorBinarySearch(array, x, leftIndex , middle - 1);
			}
		}
		return -1;
	}

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if (array.length > 0 && array != null) {
			this.sort(array, 0, array.length - 1);
			int floor = this.floorBinarySearch(array, x, 0, array.length - 1);
			return floor == -1 ? null : floor;
		}
		return null;
	}
}
