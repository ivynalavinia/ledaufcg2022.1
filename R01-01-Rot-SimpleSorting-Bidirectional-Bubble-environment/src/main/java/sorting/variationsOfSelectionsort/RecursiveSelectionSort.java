package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
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
	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (validInputs(array, leftIndex, rightIndex)) {
			
			if (leftIndex < rightIndex) {
				
				boolean swapped = true;
				
				int i = leftIndex;
				
				for (int j = i + 1; j < rightIndex + 1; j++) {
					if (array[j].compareTo(array[i]) < 0) {
						i = j;
					}
				}
				Util.swap(array, leftIndex, i);
				
				if (swapped) {
					sort(array, leftIndex + 1, rightIndex);
				}
			}
		}
	}
}
