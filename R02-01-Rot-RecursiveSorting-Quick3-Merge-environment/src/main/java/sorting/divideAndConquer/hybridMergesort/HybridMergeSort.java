package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;
import sorting.divideAndConquer.MergeSort;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;
	
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

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		
		if (validInputs(array, leftIndex, rightIndex)) {
			
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				
				int j = i;
				
				while (j > leftIndex && array[j].compareTo(array[j - 1]) < 0) {
					Util.swap(array, j, j - 1);
					j--; 
				}
			}
		}		
		INSERTIONSORT_APPLICATIONS++;
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
	
	private void mergeSort(T[] array, int leftIndex, int rightIndex) {
		
		if (validInputs(array, leftIndex, rightIndex)) {
			
			int middle = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);
			merge(array, leftIndex, rightIndex);
		}
		MERGESORT_APPLICATIONS++;
	}

	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		int size = array.length;
		 
		if (size <= SIZE_LIMIT) {	
			insertionSort(array,leftIndex,rightIndex);
		} 
		else {
			mergeSort(array, leftIndex, rightIndex);
		}
	}
}
