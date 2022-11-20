package orderStatistic;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class KLargestOrderStatisticsImplTest {

	private KLargestOrderStatisticsImpl<Integer> kLargestOrderStatistics;
	private Integer[] vetorOrdenado;
	private Integer[] vetorNaoOrdenado;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorValoresNegativosEPositivos;
	private Integer[] vetorTamanho1;

	@Before
	public void setUp () {
		this.kLargestOrderStatistics = new KLargestOrderStatisticsImpl<>();
		this.vetorOrdenado = new Integer[]{ 24, 32, 38, 84, 123 };
		this.vetorNaoOrdenado = new Integer[]{ 84, 32, 24, 123, 38 };
		this.vetorValoresIguais = new Integer[] { 6, 6, 6, 6, 6, 6 };
		this.vetorValoresNegativosEPositivos = new Integer[] { 84, -32, 24, -123, 38 };
		this.vetorTamanho1 = new Integer[] { 1 };
	}

	@Test
	public void testKLargestOrderStatistics () {
		assertEquals(null, kLargestOrderStatistics.orderStatistics(new Integer[]{}, 2));
		assertEquals(null, kLargestOrderStatistics.orderStatistics(new Integer[0], 2));

		assertEquals(null, kLargestOrderStatistics.orderStatistics(this.vetorOrdenado, -1));
		assertEquals(null, kLargestOrderStatistics.orderStatistics(this.vetorNaoOrdenado, 6));

		assertTrue(kLargestOrderStatistics.orderStatistics(this.vetorOrdenado, 1).compareTo(24) == 0);
		assertTrue(kLargestOrderStatistics.orderStatistics(this.vetorOrdenado, 4).compareTo(84) == 0);

		assertTrue(kLargestOrderStatistics.orderStatistics(this.vetorNaoOrdenado, 2).compareTo(32) == 0);
		assertTrue(kLargestOrderStatistics.orderStatistics(this.vetorNaoOrdenado, 5).compareTo(123) == 0);

		assertTrue(kLargestOrderStatistics.orderStatistics(this.vetorValoresIguais, 1).compareTo(6) == 0);
		assertTrue(kLargestOrderStatistics.orderStatistics(this.vetorValoresIguais, 6).compareTo(6) == 0);
		assertEquals(null, kLargestOrderStatistics.orderStatistics(this.vetorValoresIguais, 7));

		assertTrue(kLargestOrderStatistics.orderStatistics(this.vetorValoresNegativosEPositivos, 1).compareTo(-123) == 0);
		assertTrue(kLargestOrderStatistics.orderStatistics(this.vetorValoresNegativosEPositivos, 2).compareTo(-32) == 0);

		assertTrue(kLargestOrderStatistics.orderStatistics(this.vetorTamanho1, 1).compareTo(1) == 0);
		assertEquals(null, kLargestOrderStatistics.orderStatistics(this.vetorTamanho1, 0));
	}

	private void assertKLargest (Integer[] array, int k, String expected) {
		Comparable<Integer>[] kLargest = kLargestOrderStatistics.getKLargest(array, k);
		Arrays.sort(kLargest);
		assertEquals(expected, Arrays.toString(kLargest));
	}

	@Test
	public void testKLargestGetKLargest () {
		Comparable<Integer>[] kLargestInvalid = kLargestOrderStatistics.getKLargest(new Integer[]{}, 1);
		Arrays.sort(kLargestInvalid);

		assertKLargest(new Integer[]{}, 1, "[]");
		assertKLargest(new Integer[0], 1, "[]");
		assertKLargest(vetorOrdenado, 0, "[]");
		assertKLargest(vetorNaoOrdenado, -1, "[]");
		assertKLargest(vetorNaoOrdenado, 6, "[]");

		assertKLargest(vetorOrdenado, 2, "[84, 123]");
		assertKLargest(vetorNaoOrdenado, 3, "[38, 84, 123]");
		assertKLargest(vetorValoresNegativosEPositivos, 4, "[-32, 24, 38, 84]");
		assertKLargest(vetorTamanho1, 1, "[1]");
	}
}
