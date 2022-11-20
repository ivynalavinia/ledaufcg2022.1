package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {
	
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
	
	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if (validInputs(array, leftIndex, rightIndex)) {
			
			int maxValue = findMax(array, leftIndex, rightIndex);
			
			int[] frequency = new int[maxValue + 1];
			
			for (int i = leftIndex; i <= rightIndex; i++) {
				frequency[array[i]] += 1;
			}
			
			frequency[0] += leftIndex;
			for (int i = 1; i < frequency.length; i++) {
				frequency[i] += frequency[i - 1];
			}
			
			int[] newArray = new int[array.length];
			
			for (int i = rightIndex; i >= leftIndex; i--) {
				newArray[frequency[array[i]] - 1] = array[i];
				frequency[array[i]] -= 1;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = newArray[i];
			}		
		}
	}
}
