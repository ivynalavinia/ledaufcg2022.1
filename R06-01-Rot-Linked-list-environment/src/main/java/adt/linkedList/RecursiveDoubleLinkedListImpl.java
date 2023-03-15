package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

    protected RecursiveDoubleLinkedListImpl<T> previous;

    public RecursiveDoubleLinkedListImpl() {

    }

    @Override
    public void insert(T element) {
        if (element != null) {
            if (isEmpty()) {
                data = element;
                next = new RecursiveDoubleLinkedListImpl<>();

                if (previous == null) {
                    previous = new RecursiveDoubleLinkedListImpl<>();
                }
            } else next.insert(element);
        }
    }

    @Override
    public void insertFirst(T element) {
        if (element != null) {
            if (isEmpty()) {
                insert(element);
            } else {
                RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<>();

                newNode.setData(data);
                data = element;
                newNode.setNext(next);
                next = newNode;
                newNode.setPrevious(this);
                ((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(newNode);
            }
        }
    }

    @Override
    public void remove(T element) {
        if (element != null && !isEmpty()) {
            if (data.equals(element)) {
                if (previous.isEmpty()) {
                    removeFirst();
                } else if (next.isEmpty()) {
                    removeLast();
                } else {
                    previous.setNext(next);
                    ((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(previous);
                }
            } else {
                next.remove(element);
            }
        }
    }

    @Override
    public void removeFirst() {
        if (!isEmpty()) {
            if (next.isEmpty()) {
                data = null;
                previous = null;
                next = null;
            } else {
                data = next.getData();
                next = next.getNext();
                ((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(this);
            }
        }
    }

    @Override
    public void removeLast() {
        if (!isEmpty()) {
            if (next.isEmpty()) {
                data = null;
                next = null;

                if (previous.isEmpty()) {
                    previous = null;
                }
            } else {
                ((RecursiveDoubleLinkedListImpl<T>) next).removeLast();
            }
        }
    }

    public RecursiveDoubleLinkedListImpl<T> getPrevious() {
        return previous;
    }

    public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
        this.previous = previous;
    }

}
