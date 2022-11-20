package problems;

public class BitonicPointBinarySearchImpl<T extends Comparable<T>> implements BitonicPointBinarySearch<T>{

    private T binarySearch(T[] array, Integer leftIndex, Integer rightIndex) {

        if (leftIndex == rightIndex) {
            return array[leftIndex];
        }

        if ((leftIndex + 1 == rightIndex) && (array[leftIndex].compareTo(array[rightIndex]) > 0)) {
            return array[leftIndex];
        }

        if ((leftIndex + 1 == rightIndex) && (array[leftIndex].compareTo(array[rightIndex]) < 0)) {
            return array[rightIndex];
        }

        int middle = (leftIndex + rightIndex) / 2;
        T elem = array[middle];

        if (elem.compareTo(array[middle - 1]) < 0) {
            return binarySearch(array, leftIndex, middle);
        }
        if (elem.compareTo(array[middle - 1]) > 0) {
            return binarySearch(array, middle , rightIndex);
        }
        if (elem.compareTo(array[middle - 1]) == 0) {
            return elem;
        }
        return elem;
    }

    @Override
    public T bitonicPoint(T[] array) {

        if (array.length > 0) {
              return binarySearch(array, 0, array.length - 1);
          }
        return null;
    }
}
