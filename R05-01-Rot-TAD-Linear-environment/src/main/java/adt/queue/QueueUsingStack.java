package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueUsingStack(int size) {
        stack1 = new StackImpl<T>(size);
        stack2 = new StackImpl<T>(size);
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        try {
            if (!stack2.isEmpty()) {
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
            stack1.push(element);
        } catch (StackOverflowException e) {
            throw new QueueOverflowException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        try {
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        } catch (StackUnderflowException e) {
            throw new QueueUnderflowException();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T head() {
        try {
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.top();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public boolean isFull() {
        return stack1.isFull() || stack2.isFull();
    }
}
