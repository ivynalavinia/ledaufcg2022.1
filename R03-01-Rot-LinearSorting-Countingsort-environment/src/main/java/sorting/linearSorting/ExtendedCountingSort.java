package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {
	
	private boolean validInputs(Integer[] array, int leftIndex, int rightIndex) {
		
		if (array == null || array.length <= 1) {
			return false;
		} else if (leftIndex >= rightIndex || leftIndex < 0) {
			return false;
		} else if (rightIndex >= array.length || leftIndex >= array.length || rightIndex <= 0) {
			return false;
		}
		return true;
	}
	
	private int findMax(Integer[] array, int leftIndex, int rightIndex) {
		int maxValue = array[leftIndex];
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > maxValue) {
				maxValue = array[i];
			}
		}
		return maxValue;
	}
	
	private int findMin(Integer[] array, int leftIndex, int rightIndex) {
		int minValue = array[leftIndex];
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] < minValue) {
				minValue = array[i];
			}
		}
		return minValue;
	}
	
	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (validInputs(array, leftIndex, rightIndex)) {
			
			int maxValue = findMax(array, leftIndex, rightIndex);
			int minValue = findMin(array, leftIndex, rightIndex);
			
			int[] frequency = new int[maxValue - minValue + 1];
			
			for (int i = leftIndex; i <= rightIndex; i++) {
				frequency[array[i] - minValue] += 1;
			}
			
			for (int i = 1; i < frequency.length; i++) {
				frequency[i] += frequency[i - 1];
			}
			
			int[] newArray = new int[rightIndex - leftIndex + 1];
			
			for (int i = rightIndex; i >= leftIndex; i--) {
				newArray[frequency[array[i] - minValue] - 1] = array[i];
				frequency[array[i] - minValue] -= 1;
			}
			
			int j = 0;
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = newArray[j];
				j++;
			}		
		}
	}
}
