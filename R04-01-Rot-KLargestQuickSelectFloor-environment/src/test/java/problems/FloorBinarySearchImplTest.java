package problems;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FloorBinarySearchImplTest {

    private FloorBinarySearchImpl floorBinarySearch;
	private Integer[] vetorOrdenado;
	private Integer[] vetorNaoOrdenado;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorTamanho1;

    @Before
    public void setUp () {
    	this.floorBinarySearch = new FloorBinarySearchImpl();
    	this.vetorOrdenado = new Integer[]{ 24, 32, 38, 84, 123 };
    	this.vetorNaoOrdenado = new Integer[]{ 84, 32, 24, 123, 38 };
    	this.vetorValoresIguais = new Integer[] { 6, 6, 6, 6, 6, 6 };
    	this.vetorTamanho1 = new Integer[] { 1 };
    }

    @Test
    public void testFloorBinarySearch () {
    	assertEquals(null, floorBinarySearch.floor(new Integer[]{}, 1));
    	assertEquals(null, floorBinarySearch.floor(new Integer[0], 1));
    	
    	assertEquals(null, floorBinarySearch.floor(this.vetorOrdenado, 2));
    	assertEquals(null, floorBinarySearch.floor(this.vetorNaoOrdenado, -2));
    	
    	assertTrue(floorBinarySearch.floor(this.vetorOrdenado, 39).compareTo(38) == 0);
    	assertTrue(floorBinarySearch.floor(this.vetorOrdenado, 84).compareTo(84) == 0);
    	
    	assertTrue(floorBinarySearch.floor(this.vetorNaoOrdenado, 32).compareTo(32) == 0);
    	assertTrue(floorBinarySearch.floor(this.vetorNaoOrdenado, 25).compareTo(24) == 0);
    	
    	assertTrue(floorBinarySearch.floor(this.vetorValoresIguais, 8).compareTo(6) == 0);
    	assertTrue(floorBinarySearch.floor(this.vetorValoresIguais, 6).compareTo(6) == 0);
    	assertEquals(null, floorBinarySearch.floor(this.vetorValoresIguais, 5));
    	
    	assertTrue(floorBinarySearch.floor(this.vetorTamanho1, 2).compareTo(1) == 0);
    	assertTrue(floorBinarySearch.floor(this.vetorTamanho1, 1).compareTo(1) == 0);
    	assertEquals(null, floorBinarySearch.floor(this.vetorTamanho1, 0));
    }
}
