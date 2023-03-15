package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

    protected T data;
    protected RecursiveSingleLinkedListImpl<T> next;

    public RecursiveSingleLinkedListImpl() {

    }

    @Override
    public boolean isEmpty() {
        return (data == null);
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }

        return 1 + next.size();
    }

    @Override
    public T search(T element) {
        if (element != null) {
            if (isEmpty() || data.equals(element)) {
                return data;
            } else {
                return next.search(element);
            }
        }

        return null;
    }

    @Override
    public void insert(T element) {
        if (element != null) {
            if (isEmpty()) {
                data = element;
                next = new RecursiveSingleLinkedListImpl<>();
            } else {
                next.insert(element);
            }
        }
    }

    @Override
    public void remove(T element) {
        if (element != null && !isEmpty()) {
            if (data.equals(element)) {
                T newData = next.getData();
                RecursiveSingleLinkedListImpl<T> newNext = next.getNext();

                data = newData;
                next = newNext;
            } else {
                next.remove(element);
            }
        }
    }

    @Override
    public T[] toArray() {
        List<T> array = new ArrayList<>();
        return recursiveToArray(array);
    }

    private T[] recursiveToArray(List<T> array) {
        if (!isEmpty()) {
            array.add(data);
            next.recursiveToArray(array);
        }
        return (T[]) array.toArray();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RecursiveSingleLinkedListImpl<T> getNext() {
        return next;
    }

    public void setNext(RecursiveSingleLinkedListImpl<T> next) {
        this.next = next;
    }

}
