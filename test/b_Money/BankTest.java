package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception { //changed the opening of accounts, because changed the method
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika_01", new Account("Ulrika", SEK));
		SweBank.openAccount("Bob_01", new Account("Bob", SEK));
		Nordea.openAccount("Bob_02", new Account("Bob", SEK));
		DanskeBank.openAccount("Gertrud_05", new Account("Gertrud", SEK));
	}

	@Test
	public void testGetName() {
		assertEquals(SweBank.getName(), "SweBank");
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SweBank.getCurrency(), SEK);
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		assertFalse(SweBank.accountExists("Ulrika_69"));
		SweBank.openAccount("Ulrika_69", new Account("Ulrika", SEK));
		assertTrue(SweBank.accountExists("Ulrika_69"));
	}

	@Test
	public void testDepositWithdraw() throws AccountDoesNotExistException {//made deposit and withdraw tests into one
		assertEquals(0.0, SweBank.getBalance("Ulrika_01"), 0.0);
		SweBank.deposit("Ulrika_01", new Money(100, SEK));
		assertEquals(100.0, SweBank.getBalance("Ulrika_01"), 0.0);
		SweBank.withdraw("Ulrika_01", new Money(100, SEK));
		assertEquals(0.0, SweBank.getBalance("Ulrika_01"), 0.0);//withdraw method made deposits instead XD

	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		assertEquals(0.0, SweBank.getBalance("Ulrika_01"), 0.0);
		SweBank.deposit("Ulrika_01", new Money(100, SEK));
		assertEquals(100.0, SweBank.getBalance("Ulrika_01"), 0.0);
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		assertEquals(0.0, SweBank.getBalance("Ulrika_01"), 0.0);
		assertEquals(0.0, Nordea.getBalance("Bob_02"), 0.0);
		SweBank.transfer("Ulrika_01", Nordea, "Bob_02", new Money(100, SEK));
		assertEquals(-100.0, SweBank.getBalance("Ulrika_01"), 0.0);
		assertEquals(100.0, Nordea.getBalance("Bob_02"), 0.0);
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		assertFalse(SweBank.getAccountlist().get("Ulrika_01").timedPaymentExists("99"));
		SweBank.getAccountlist().get("Ulrika_01").addTimedPayment("99", 3, 4,
				new Money(100000, SEK), SweBank,
				"yes");
		assertTrue(SweBank.getAccountlist().get("Ulrika_01").timedPaymentExists("99"));
	}
}
