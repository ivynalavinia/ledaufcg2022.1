package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentLinkedListTest {

	protected LinkedList<Integer> lista1;
	protected LinkedList<Integer> lista2;
	protected LinkedList<Integer> lista3;
	protected LinkedList<Integer> lista4;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

	}

	private void getImplementations() {
		lista1 = new RecursiveSingleLinkedListImpl<>(); //TODO test the others implementations
		lista2 = new RecursiveSingleLinkedListImpl<>();
		lista3 = new RecursiveSingleLinkedListImpl<>();
		lista4 = new RecursiveSingleLinkedListImpl<>();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse(lista1.isEmpty());
		Assert.assertTrue(lista2.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertEquals(3, lista1.size());
		Assert.assertEquals(0, lista2.size());
	}

	@Test
	public void testSearch() {
		Assert.assertTrue(2 == lista1.search(2));
		Assert.assertNull(lista1.search(4));
		Assert.assertFalse(3 == lista1.search(2));
	}

	@Test
	public void testInsert() {
		Assert.assertEquals(3, lista1.size());
		lista1.insert(5);
		lista1.insert(7);
		Assert.assertEquals(5, lista1.size());

		Assert.assertEquals(0, lista2.size());
		lista2.insert(4);
		lista2.insert(7);
		Assert.assertEquals(2, lista2.size());
	}

	@Test
	public void testRemove() {
		Assert.assertEquals(3, lista1.size());
		lista1.remove(2);
		lista1.remove(1);
		Assert.assertEquals(1, lista1.size());

	}

	@Test
	public void testToArray() {
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
	}
	// MEUS TESTES

		@Test
		public void myTestRemove() {
			lista4.insert(4);
			lista4.insert(2);
			lista4.insert(-8);
			lista4.insert(6);
			lista4.insert(32);
			lista4.insert(41);
			lista4.insert(0);
			lista4.insert(16);
			lista4.insert(1);

			Assert.assertArrayEquals(new Integer[] { 4,2,-8,6,32,41,0,16,1 }, lista4.toArray());

			lista4.remove(4);
			Assert.assertArrayEquals(new Integer[] { 2,-8,6,32,41,0,16,1 }, lista4.toArray());

			lista4.remove(1);
			Assert.assertArrayEquals(new Integer[] { 2,-8,6,32,41,0,16 }, lista4.toArray());

			lista4.remove(41);
			Assert.assertArrayEquals(new Integer[] { 2,-8,6,32,0,16 }, lista4.toArray());

			lista4.remove(-8);
			Assert.assertArrayEquals(new Integer[] { 2,6,32,0,16 }, lista4.toArray());

			lista4.remove(6);
			lista4.remove(32);
			lista4.remove(0);
			Assert.assertArrayEquals(new Integer[] { 2,16 }, lista4.toArray());

			lista4.remove(32);
			lista4.remove(6);
			lista4.remove(-8);
			lista4.remove(null);
			Assert.assertArrayEquals(new Integer[] { 2,16 }, lista4.toArray());

			lista4.remove(2);
			lista4.remove(16);
			Assert.assertArrayEquals(new Integer[] {  }, lista4.toArray());
		}

	    @Test
	    public void myTestGeral() {
	        // lista vazia
	    	Assert.assertTrue(lista4.isEmpty());
	    	Assert.assertArrayEquals(new Integer[] { }, lista4.toArray());
	    	Assert.assertEquals(0, lista4.size());

			// insert
			lista4.insert(1);
			Assert.assertFalse(lista4.isEmpty());
			Assert.assertArrayEquals(new Integer[] { 1 }, lista4.toArray());
			Assert.assertEquals(1, lista4.size());

			lista4.insert(2);
			lista4.insert(3);
			Assert.assertArrayEquals(new Integer[] { 1,2,3 }, lista4.toArray());
			Assert.assertEquals(3, lista4.size());

			// remove
			lista4.remove(1);
			Assert.assertArrayEquals(new Integer[] { 2,3 }, lista4.toArray());
			Assert.assertEquals(2, lista4.size());
			lista4.remove(3);
			Assert.assertArrayEquals(new Integer[] { 2 }, lista4.toArray());
			lista4.remove(2);
			Assert.assertArrayEquals(new Integer[] {  }, lista4.toArray());

			lista4.insert(6);
			lista4.insert(11);
			lista4.insert(3);
			lista4.remove(20);
			Assert.assertArrayEquals(new Integer[] { 6,11,3 }, lista4.toArray());
			lista4.remove(null);
			Assert.assertArrayEquals(new Integer[] { 6,11,3 }, lista4.toArray());
			lista4.remove(3);
			lista4.remove(11);
			lista4.remove(6);
			Assert.assertArrayEquals(new Integer[] {  }, lista4.toArray());
			lista4.remove(6);
			lista4.remove(6);
			Assert.assertArrayEquals(new Integer[] {  }, lista4.toArray());
			Assert.assertEquals(0, lista4.size());

			// search
			lista4.insert(7);
			lista4.insert(2);
			lista4.insert(6);
			lista4.insert(6);
			lista4.insert(0);
			lista4.insert(-3);
			Assert.assertNull(lista4.search(1));
			Assert.assertNull(lista4.search(-4));
			Assert.assertNull(lista4.search(null));
			Assert.assertEquals(Integer.valueOf(2), lista4.search(2));
			Assert.	assertEquals(Integer.valueOf(0), lista4.search(0));
			Assert.	assertEquals(Integer.valueOf(6), lista4.search(6));
			Assert.	assertEquals(Integer.valueOf(7), lista4.search(7));
			Assert.	assertEquals(Integer.valueOf(-3), lista4.search(-3));
		}
}