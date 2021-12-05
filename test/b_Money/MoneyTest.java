package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(100, SEK);
		EUR10 = new Money(10, EUR);
		SEK200 = new Money(200, SEK);
		EUR20 = new Money(20, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-100, SEK);
	}

	@Test
	public void testGetAmount() {
		assertEquals(Double.toString(SEK100.getAmount()), "100.0");
	}

	@Test
	public void testGetCurrency() {
		assertEquals((SEK100.getCurrency().getName()), "SEK");
	}

	@Test
	public void testToString() {
		assertEquals(SEK100.toString(), "100.0 SEK");
	}

	@Test
	public void testGlobalValue() {
		assertEquals(Double.toString(SEK100.universalValue()), "15.0");
	}

	@Test
	public void testEqualsMoney() {
		assertEquals((SEK100.equals(EUR20)), false);
	}

	@Test
	public void testAdd() {
		assertEquals(0, (SEK100.add(SEK100)).compareTo(SEK200));
	}

	@Test
	public void testSub() {
		assertEquals(0, (SEK100.sub(SEK100)).compareTo(SEK0));
	}

	@Test
	public void testIsZero() {
		assertTrue(SEK0.isZero());
	}

	@Test
	public void testNegate() {
		assertEquals(0, SEK100.negate().compareTo(SEKn100));
	}

	@Test
	public void testCompareTo() {
		assertEquals(0, (SEK100.add(SEK100)).compareTo(SEK200));
	}
}
