package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		// class Account works as expected
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		testAccount = new Account("Hans", SEK);


	}
	
	@Test
	public void testAddRemoveTimedPayment() {
		assertFalse(testAccount.timedPaymentExists("99"));
		testAccount.addTimedPayment("99", 3, 4,
						new Money(100000, SEK), SweBank,
						"yes");
		assertTrue(testAccount.timedPaymentExists("99"));
		testAccount.removeTimedPayment("99");
		assertFalse(testAccount.timedPaymentExists("99"));
	} //works!!
	
	@Test
	public void testTimedPaymentExists() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("99", 3, 4,
				new Money(100000, SEK), SweBank,
				"yes");
		assertTrue(testAccount.timedPaymentExists("99"));
	}

	@Test
	public void testAddWithdraw() {
		assertEquals(testAccount.getBalance().compareTo(new Money(0.0, SEK)), 0);
		testAccount.deposit(new Money(100000, SEK));
		assertEquals(testAccount.getBalance().compareTo(new Money(100000.0, SEK)), 0);
		testAccount.withdraw(new Money(50000, SEK));
		assertEquals(testAccount.getBalance().compareTo(new Money(50000.0, SEK)), 0);
	}
	
	@Test
	public void testGetBalance() {
		assertEquals(testAccount.getBalance().compareTo(new Money(0.0, SEK)), 0);
	}
}
