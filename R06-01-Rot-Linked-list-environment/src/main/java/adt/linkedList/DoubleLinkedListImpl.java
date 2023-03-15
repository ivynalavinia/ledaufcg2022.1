package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

    protected DoubleLinkedListNode<T> last;

    public DoubleLinkedListImpl() {
        this.last = new DoubleLinkedListNode<>();
        this.head = this.last;
    }

    @Override
    public void insert(T element) {
        if (element != null) {
            DoubleLinkedListNode<T> elementNode = new DoubleLinkedListNode<>();
            DoubleLinkedListNode<T> emptyNode = new DoubleLinkedListNode<>();

            last.setNext(elementNode);

            elementNode.setData(element);
            elementNode.setNext(emptyNode);
            elementNode.setPrevious(last);

            emptyNode.setPrevious(elementNode);

            if (last.isNIL()) {
                head = elementNode;
            }

            last = elementNode;
        }
    }

    @Override
    public void insertFirst(T element) {
        if (element != null) {
            DoubleLinkedListNode<T> elementNode = new DoubleLinkedListNode<>();
            DoubleLinkedListNode<T> emptyNode = new DoubleLinkedListNode<>();

            elementNode.setData(element);
            elementNode.setNext(head);
            elementNode.setPrevious(emptyNode);

            ((DoubleLinkedListNode<T>) head).setPrevious(elementNode);

            if (head.isNIL()) {
                last = elementNode;
            }

            head = elementNode;
        }
    }

    @Override
    public void remove(T element) {
        if (element != null && !isEmpty()) {

            if (head.getData().equals(element)) {
                removeFirst();
            } else if (last.getData().equals(element)) {
                removeLast();
            } else {
                DoubleLinkedListNode<T> nodeAux = (DoubleLinkedListNode<T>) head;

                while (!nodeAux.getData().equals(element) && !nodeAux.isNIL()) {
                    nodeAux = (DoubleLinkedListNode<T>) nodeAux.getNext();
                }

                nodeAux.getPrevious().setNext(nodeAux.getNext());
                ((DoubleLinkedListNode<T>) nodeAux.getNext()).setPrevious(nodeAux.getPrevious());
            }
        }
    }

    @Override
    public void removeFirst() {
        if (!isEmpty()) {
            head = head.getNext();

            if (head.isNIL()) {
                last = ((DoubleLinkedListNode<T>) head);
            } else {
                ((DoubleLinkedListNode<T>) head).setPrevious(new DoubleLinkedListNode<>());
            }
        }
    }

    @Override
    public void removeLast() {
        if (!isEmpty()) {
            last = last.getPrevious();

            if (last.isNIL())
                head = last;
            else {
                last.setNext(new DoubleLinkedListNode<>());
            }
        }
    }

    public DoubleLinkedListNode<T> getLast() {
        return last;
    }

    public void setLast(DoubleLinkedListNode<T> last) {
        this.last = last;
    }

}
