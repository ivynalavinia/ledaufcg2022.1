package problems;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BitonicPointBinarySearchImplTest {

    private BitonicPointBinarySearchImpl bitonicPointBinarySearch;
	private Integer[] vectorTwoParts;
	private Integer[] vectorOneElementAscending;
	private Integer[] vectorOneElementDescending;
	private Integer[] vectorOnlyAscending;
	private Integer[] vectorOnlyDescending;
	private Integer[] vectorOneElement;

    @Before
    public void setUp () {
    	this.bitonicPointBinarySearch = new BitonicPointBinarySearchImpl();
    	this.vectorTwoParts = new Integer[]{ 7, 12, 16, 20, 7, 4, 2, 1 };
    	this.vectorOneElementAscending = new Integer[]{ 16, 20, 7, 4, 2, 1 };
    	this.vectorOneElementDescending = new Integer[] { 7, 12, 16, 20, 7 };
		this.vectorOnlyAscending = new Integer[] { 7, 12, 16, 20 };
		this.vectorOnlyDescending = new Integer[] { 20, 7, 4, 2, 1 };
    	this.vectorOneElement = new Integer[] { 20 };
    }

    @Test
    public void testBitonicPointBinarySearch () {
    	assertEquals(null, bitonicPointBinarySearch.bitonicPoint(new Integer[]{}));
    	assertEquals(null, bitonicPointBinarySearch.bitonicPoint(new Integer[0]));
    	assertTrue(bitonicPointBinarySearch.bitonicPoint(vectorTwoParts).compareTo(20) == 0);
    	assertTrue(bitonicPointBinarySearch.bitonicPoint(vectorOneElementAscending).compareTo(20) == 0);
    	assertTrue(bitonicPointBinarySearch.bitonicPoint(vectorOneElementDescending).compareTo(20) == 0);
		assertTrue(bitonicPointBinarySearch.bitonicPoint(vectorOnlyAscending).compareTo(20) == 0);
		assertTrue(bitonicPointBinarySearch.bitonicPoint(vectorOnlyDescending).compareTo(20) == 0);
    	assertTrue(bitonicPointBinarySearch.bitonicPoint(vectorOneElement).compareTo(20) == 0);
    }
}
