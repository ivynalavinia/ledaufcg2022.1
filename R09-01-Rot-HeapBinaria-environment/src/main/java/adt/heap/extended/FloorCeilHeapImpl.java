package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

    public FloorCeilHeapImpl(Comparator<Integer> comparator) {
        super(comparator);
    }

    private Integer recursiveFloor(double number, Integer floor) {
        Integer root = extractRootElement();
        if (root != null) {
            if ((floor == null || root >= floor) && number < root) {
                floor = recursiveFloor(number, floor);
            } else {
                floor = recursiveFloor(number, root);
            }
        }
        return floor;
    }

    @Override
    public Integer floor(Integer[] array, double numero) {
        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
        return recursiveFloor(numero, null);
    }

    private Integer recursiveCeil(double number, Integer ceil) {
        Integer root = extractRootElement();
        if (root != null) {
            if ((ceil == null || root <= ceil) && number <= root) {
                ceil = recursiveCeil(number, root);
            } else {
                ceil = recursiveCeil(number, ceil);
            }
        }
        return ceil;
    }

    @Override
    public Integer ceil(Integer[] array, double numero) {
        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
        return recursiveCeil(numero, null);
    }

}
