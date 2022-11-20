package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

    public Queue<Integer> queue1;
    public Queue<Integer> queue2;
    public Queue<Integer> queue3;
    public Queue<Integer> queue4;
    public Queue<Integer> queue5;

    @Before
    public void setUp() throws QueueOverflowException {

        getImplementations();

        // Fila com 3 elementos não cheia.
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        // Fila com 2 elementos de tamanho 2. Fila cheia.
        queue2.enqueue(1);
        queue2.enqueue(2);

    }

    private void getImplementations() {
        queue1 = new QueueUsingStack<>(4);
        queue2 = new QueueUsingStack<>(2);
        queue3 = new QueueUsingStack<>(1);
        queue4 = new QueueUsingStack<>(0);
        queue5 = new QueueUsingStack<>(2);
    }

    // MÉTODOS DE TESTE
    @Test
    public void testHead() {
        assertEquals(new Integer(1), queue1.head());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(queue1.isEmpty());
        assertTrue(queue3.isEmpty());
    }

    @Test
    public void testIsFull() {
        assertFalse(queue1.isFull());
    }

    @Test
    public void testEnqueue() {
        try {
            queue1.enqueue(new Integer(5));
        } catch (QueueOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test(expected = QueueOverflowException.class)
    public void testEnqueueComErro() throws QueueOverflowException {
        queue1.enqueue(new Integer(5));
        queue1.enqueue(new Integer(5)); // vai depender do tamanho que a fila
        // foi iniciada!!!
    }

    @Test
    public void testDequeue() {
        try {
            assertEquals(new Integer(1), queue1.dequeue());
        } catch (QueueUnderflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test(expected = QueueUnderflowException.class)
    public void testDequeueComErro() throws QueueUnderflowException {
        assertEquals(new Integer(1), queue1.dequeue());
        assertEquals(new Integer(2), queue1.dequeue());
        assertEquals(new Integer(3), queue1.dequeue());
        assertEquals(new Integer(4), queue1.dequeue());// vai depender do
        // tamanho que a fial
        // foi iniciada!!!
    }

    // Other tests:

    @Test(expected = QueueOverflowException.class)
    public void testOperationsQueueSized0() throws QueueOverflowException {
        assertTrue(queue4.isEmpty());
        assertTrue(queue4.isFull());
        assertNull(queue4.head());

        queue4.enqueue(5);
    }

    @Test(expected = QueueOverflowException.class)
    public void testOperationsQueueSized1() throws QueueOverflowException {
        assertTrue(queue3.isEmpty());
        assertFalse(queue3.isFull());

        queue3.enqueue(5);

        assertFalse(queue3.isEmpty());
        assertTrue(queue3.isFull());
        assertEquals(new Integer(5), queue3.head());

        queue3.enqueue(20);
    }

    @Test
    public void testOperationsQueueSized2() throws QueueOverflowException {
        assertTrue(queue5.isEmpty());
        assertFalse(queue5.isFull());

        queue5.enqueue(7);
        assertFalse(queue5.isEmpty());
        assertFalse(queue5.isFull());
        assertEquals(new Integer(7), queue5.head());

        queue5.enqueue(20);
        assertFalse(queue5.isEmpty());
        assertTrue(queue5.isFull());
        assertEquals(new Integer(7), queue5.head());
    }

    @Test(expected = QueueUnderflowException.class)
    public void testUnderflowException() throws QueueUnderflowException {
        assertTrue(queue3.isEmpty());
        assertFalse(queue3.isFull());
        queue3.dequeue();
    }
}
