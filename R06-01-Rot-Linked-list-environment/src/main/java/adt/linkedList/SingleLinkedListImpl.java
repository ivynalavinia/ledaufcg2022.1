package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

    protected SingleLinkedListNode<T> head;

    public SingleLinkedListImpl() {
        this.head = new SingleLinkedListNode<T>();
    }

    @Override
    public boolean isEmpty() {
        return head.isNIL();
    }

    @Override
    public int size() {
        SingleLinkedListNode<T> nodeAux = head;
        int size = 0;

        while (!nodeAux.isNIL()) {
            nodeAux = nodeAux.getNext();
            size += 1;
        }

        return size;
    }

    @Override
    public T search(T element) {
        SingleLinkedListNode<T> nodeAux = head;

        while (!nodeAux.isNIL()) {
            if (nodeAux.getData().equals(element)) {
                return nodeAux.getData();
            }
            nodeAux = nodeAux.getNext();
        }

        return null;
    }

    @Override
    public void insert(T element) {
        if (element != null) {
            SingleLinkedListNode<T> nodeAux = head;

            while (!nodeAux.isNIL()) {
                nodeAux = nodeAux.getNext();
            }

            nodeAux.setData(element);
            nodeAux.setNext(new SingleLinkedListNode<>());
        }
    }

    @Override
    public void remove(T element) {
        if (element != null && !isEmpty()) {
            SingleLinkedListNode<T> nodeAux = head;

            while (!nodeAux.isNIL() && !nodeAux.getData().equals(element)) {
                nodeAux = nodeAux.getNext();
            }

            if (!nodeAux.isNIL()) {
                nodeAux.setData(nodeAux.getNext().getData());
                nodeAux.setNext(nodeAux.getNext().getNext());
            }
        }
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[size()];
        SingleLinkedListNode<T> nodeAux = head;

        for (int i = 0; i < array.length; i++) {
            array[i] = nodeAux.getData();
            nodeAux = nodeAux.getNext();
        }

        return array;
    }

    public SingleLinkedListNode<T> getHead() {
        return head;
    }

    public void setHead(SingleLinkedListNode<T> head) {
        this.head = head;
    }

}
