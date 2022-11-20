package adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class StudentStackTest {

    public Stack<Integer> stack1;
    public Stack<Integer> stack2;
    public Stack<Integer> stack3;
    public Stack<Integer> stack4;
    public Stack<Integer> stack5;

    @Before
    public void setUp() throws StackOverflowException {

        getImplementations();

        // Pilha com 3 elementos não cheia.
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        // Pilha com 2 elementos de tamanho 2, pilha cheia.
        stack2.push(1);
        stack2.push(2);

    }

    private void getImplementations() {
        stack1 = new StackImpl<>(4);
        stack2 = new StackImpl<>(2);
        stack3 = new StackImpl<>(1);
        stack4 = new StackImpl<>(0);
        stack5 = new StackImpl<>(2);
    }

    // MÉTODOS DE TESTE
    @Test
    public void testTop() {
        assertEquals(new Integer(3), stack1.top());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(stack1.isEmpty());
    }

    @Test
    public void testIsFull() {
        assertFalse(stack1.isFull()); // vai depender do tamanho que a pilha foi
        // iniciada!!!!
    }

    @Test
    public void testPush() {
        try {
            stack1.push(new Integer(5));
        } catch (StackOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test(expected = StackOverflowException.class)
    public void testPushComErro() throws StackOverflowException {
        stack1.push(new Integer(5));
        stack1.push(new Integer(5)); // levanta excecao apenas se o tamanhonao
        // permitir outra insercao
    }

    @Test
    public void testPop() {
        try {
            assertEquals(new Integer(3), stack1.pop());
        } catch (StackUnderflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test(expected = StackUnderflowException.class)
    public void testPopComErro() throws StackUnderflowException {
        assertEquals(new Integer(3), stack1.pop());
        assertEquals(new Integer(2), stack1.pop());
        assertEquals(new Integer(1), stack1.pop());
        assertEquals(new Integer(0), stack1.pop()); // levanta excecao apenas se
        // stack1 for vazia
    }

    // Other tests:

    @Test(expected = StackOverflowException.class)
    public void testOperationsStackSized0() throws StackOverflowException {
        assertTrue(stack4.isEmpty());
        assertTrue(stack4.isFull());
        assertNull(stack4.top());

        stack4.push(5);
    }

    @Test(expected = StackOverflowException.class)
    public void testOperationsStackSized1() throws StackOverflowException {
        assertTrue(stack3.isEmpty());
        assertFalse(stack3.isFull());

        stack3.push(5);

        assertFalse(stack3.isEmpty());
        assertTrue(stack3.isFull());
        assertEquals(new Integer(5), stack3.top());

        stack3.push(20);
    }

    @Test
    public void testOperationsStackSized2() throws StackOverflowException {
        assertTrue(stack5.isEmpty());
        assertFalse(stack5.isFull());

        stack5.push(7);
        assertFalse(stack5.isEmpty());
        assertFalse(stack5.isFull());
        assertEquals(new Integer(7), stack5.top());

        stack5.push(20);
        assertFalse(stack5.isEmpty());
        assertTrue(stack5.isFull());
        assertEquals(new Integer(20), stack5.top());
    }

    @Test(expected = StackUnderflowException.class)
    public void testUnderflowException() throws StackUnderflowException {
        assertTrue(stack3.isEmpty());
        assertFalse(stack3.isFull());
        stack3.pop();
    }
}