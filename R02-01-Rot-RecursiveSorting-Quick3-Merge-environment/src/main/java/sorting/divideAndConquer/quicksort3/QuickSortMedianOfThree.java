package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends AbstractSorting<T> {
	
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

  	private void sortThree(T[] array, int leftIndex, int center, int rightIndex) {
  		
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
  	
  	private int partition(T[] array, int leftIndex, int rightIndex) {
  
  		T pivot = array[leftIndex - 1];
		int i = leftIndex - 1;
		
		for (int j = leftIndex; j < rightIndex; j++) {
			
			if (array[j].compareTo(pivot) < 0) {
				i += 1;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, leftIndex - 1, i);
		return i;	
  	}
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
  		
  		if (validInputs(array, leftIndex, rightIndex)) {
  			
  			if (leftIndex < rightIndex) {
  				
	  			int center = (rightIndex + leftIndex) / 2;
	  			
		  		sortThree(array, leftIndex, center, rightIndex);
		  		
		  		Util.swap(array, center, rightIndex - 1);
		  		
		  		int pivot = partition(array, leftIndex + 1, rightIndex - 1);
		  		
		  		sort(array, leftIndex, pivot - 1);
		  		sort(array, pivot + 1, rightIndex);
  			}
  		}
  	}
}
