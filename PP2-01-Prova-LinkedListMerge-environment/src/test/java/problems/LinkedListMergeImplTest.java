package problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListMergeImplTest {

	protected LinkedListMergeImpl<Integer> lista;
	
	protected SingleLinkedListNode<Integer> node1;
	protected SingleLinkedListNode<Integer> node2;
	protected SingleLinkedListNode<Integer> node3;
	protected SingleLinkedListNode<Integer> node4;
	protected SingleLinkedListNode<Integer> node5;
	protected SingleLinkedListNode<Integer> node6;
	
	protected SingleLinkedListNode<Integer> node7;
	protected SingleLinkedListNode<Integer> node8;
	protected SingleLinkedListNode<Integer> node9;
	
	protected SingleLinkedListNode<Integer> node10;
	
	@Before
	public void setUp() throws Exception {
		lista = new LinkedListMergeImpl<Integer>();
		
		node1 = new SingleLinkedListNode<Integer>(1, node3);
		node2 = new SingleLinkedListNode<Integer>(0, node5);
		node3 = new SingleLinkedListNode<Integer>(2, node4);
		node4 = new SingleLinkedListNode<Integer>(6, new SingleLinkedListNode<Integer>());
		node5 = new SingleLinkedListNode<Integer>(2, node6);
		node6 = new SingleLinkedListNode<Integer>(7, new SingleLinkedListNode<Integer>());
		
		node7 = new SingleLinkedListNode<Integer>(3, new SingleLinkedListNode<Integer>());
		node8 = new SingleLinkedListNode<Integer>(1, node9);
		node9 = new SingleLinkedListNode<Integer>(2, new SingleLinkedListNode<Integer>());
		
		node10 = new SingleLinkedListNode<Integer>(2, new SingleLinkedListNode<Integer>());
	}

	@Test
	public void testMerge() {
		Assert.assertEquals(node2, lista.merge(node1, node2));
		
		Assert.assertEquals(node8, lista.merge(node7, node8));
		
		Assert.assertEquals(node10, lista.merge(node10, node10));
		
		Assert.assertEquals(new SingleLinkedListNode<Integer>(), lista.merge(null, null));
		
		Assert.assertEquals(node1, lista.merge(node1, null));
		
		Assert.assertEquals(node1, lista.merge(null, node1));
	}

}
