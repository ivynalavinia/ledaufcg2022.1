package problems;

import org.junit.Assert;
import org.junit.Test;

public class ConsecutiveParentChildBSTTest {

	@Test
	public void test() {
		
		ConsecutiveParentChildBSTImpl bstTest = new ConsecutiveParentChildBSTImpl();
		ConsecutiveParentChildBSTImpl bstTest2 = new ConsecutiveParentChildBSTImpl();
		ConsecutiveParentChildBSTImpl bstTest3 = new ConsecutiveParentChildBSTImpl();
		ConsecutiveParentChildBSTImpl bstTest4 = new ConsecutiveParentChildBSTImpl();
		ConsecutiveParentChildBSTImpl bstTest5 = new ConsecutiveParentChildBSTImpl();
		
		bstTest.insert(2);
		bstTest.insert(3);
		bstTest.insert(1);
		bstTest.insert(2);
		bstTest.insert(5);
		bstTest.insert(4);
		bstTest.insert(9);
		bstTest.insert(6);
		bstTest.insert(0);

		bstTest3.insert(6);
		bstTest3.insert(0);

		bstTest4.insert(0);

		bstTest5.insert(100);
		bstTest5.insert(99);
		bstTest5.insert(6);
		bstTest5.insert(0);
		
		Assert.assertEquals(4, bstTest.findConsecutives().size());
		Assert.assertEquals(0, bstTest2.findConsecutives().size());
		Assert.assertEquals(0, bstTest3.findConsecutives().size());
		Assert.assertEquals(0, bstTest4.findConsecutives().size());
		Assert.assertEquals(1, bstTest5.findConsecutives().size());
		
		bstTest.findConsecutives();
	}

}
