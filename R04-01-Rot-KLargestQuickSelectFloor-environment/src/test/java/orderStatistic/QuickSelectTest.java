package orderStatistic;

import org.junit.Before;
import org.junit.Test;
import problems.FloorBinarySearchImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuickSelectTest {

	private QuickSelect<Integer> quickSelect;
	private Integer[] vetorOrdenado;
	private Integer[] vetorNaoOrdenado;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorValoresNegativosEPositivos;
	private Integer[] vetorTamanho1;

	@Before
	public void setUp () {
		this.quickSelect = new QuickSelect<>();
		this.vetorOrdenado = new Integer[]{ 24, 32, 38, 84, 123 };
		this.vetorNaoOrdenado = new Integer[]{ 84, 32, 24, 123, 38 };
		this.vetorValoresIguais = new Integer[] { 6, 6, 6, 6, 6, 6 };
		this.vetorValoresNegativosEPositivos = new Integer[] { 84, -32, 24, -123, 38 };
		this.vetorTamanho1 = new Integer[] { 1 };
	}

	@Test
	public void testQuickSelect () {
		assertEquals(null, quickSelect.quickSelect(new Integer[]{}, 2));
		assertEquals(null, quickSelect.quickSelect(new Integer[0], 2));

		assertEquals(null, quickSelect.quickSelect(this.vetorOrdenado, -1));
		assertEquals(null, quickSelect.quickSelect(this.vetorNaoOrdenado, 6));

		assertTrue(quickSelect.quickSelect(this.vetorOrdenado, 1).compareTo(24) == 0);
		assertTrue(quickSelect.quickSelect(this.vetorOrdenado, 4).compareTo(84) == 0);

		assertTrue(quickSelect.quickSelect(this.vetorNaoOrdenado, 2).compareTo(32) == 0);
		assertTrue(quickSelect.quickSelect(this.vetorNaoOrdenado, 5).compareTo(123) == 0);

		assertTrue(quickSelect.quickSelect(this.vetorValoresIguais, 1).compareTo(6) == 0);
		assertTrue(quickSelect.quickSelect(this.vetorValoresIguais, 6).compareTo(6) == 0);
		assertEquals(null, quickSelect.quickSelect(this.vetorValoresIguais, 7));

		assertTrue(quickSelect.quickSelect(this.vetorValoresNegativosEPositivos, 1).compareTo(-123) == 0);
		assertTrue(quickSelect.quickSelect(this.vetorValoresNegativosEPositivos, 2).compareTo(-32) == 0);

		assertTrue(quickSelect.quickSelect(this.vetorTamanho1, 1).compareTo(1) == 0);
		assertEquals(null, quickSelect.quickSelect(this.vetorTamanho1, 0));
	}
}
