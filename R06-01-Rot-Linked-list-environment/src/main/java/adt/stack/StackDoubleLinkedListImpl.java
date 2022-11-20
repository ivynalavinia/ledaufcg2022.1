package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}
// TODO refazer todas as funções de todos os namespaces e reajustar os MEUS TESTES
	@Override
	public void push(T element) throws StackOverflowException {
		if (this.isFull())
			throw new StackOverflowException();

		if (element != null)
			this.top.insertFirst(element);
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty())
			throw new StackUnderflowException();

		T element = this.top();
		this.top.removeFirst();
		return element;
	}

	@Override
	public T top() {
		if (this.isEmpty())
			return null;

		return ((DoubleLinkedListImpl<T>) this.top).getHead().getData();
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.top.size() == this.size;
	}
}
