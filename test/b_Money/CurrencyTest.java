package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals(SEK.getName(), "SEK");
	}
	
	@Test
	public void testGetRate() {
		assertEquals(Double.toString(SEK.getRate()), "0.15");
	}
	
	@Test
	public void testSetRate() {
		DKK.setRate(6.9);
		assertEquals(Double.toString(DKK.getRate()), "6.9");
	}
	
	@Test
	public void testGlobalValue() {
		assertEquals(Double.toString(SEK.universalValue(100)), "15.0");
	}
	
	@Test
	public void testValueInThisCurrency() {
		assertEquals(Double.toString(SEK.valueInThisCurrency(5, EUR)), "0.5");
	}

}
