import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Objects;

public class AtmTest {
    // Test object
    Atm underTest = new Atm("1234", new BigDecimal("500.00"));

    @Test
    public void containsRequiredFourDigitPin() {
        String response = underTest.getRequiredPin();
        assertEquals("1234", response);
    }

    @Test
    public void checkIfEnteredPinIsIncorrect() {
        assertFalse(underTest.allowAccess("1444"));
    }

    @Test
    public void checkIfEnteredPinIsCorrect() {
        assertTrue(underTest.allowAccess("1234"));
    }

    @Test
    public void hasABalance() {
        BigDecimal response = underTest.getBalance();
        assertEquals(new BigDecimal("500.00"), response);
    }

    @Test
    public void canDepositAmount() {
        underTest.deposit(new BigDecimal("150.00"));
        BigDecimal response = underTest.getBalance();
        assertEquals(new BigDecimal("650.00"), response);
    }

    @Test
    public void canWithdrawalAmount() {
        underTest.withdrawal(new BigDecimal("100.00"));
        BigDecimal response = underTest.getBalance();
        assertEquals(new BigDecimal("400.00"), response);
    }

    @Test
    public void canOnlyWithdrawalAmountBalanceContains() {
        underTest.withdrawal(new BigDecimal("500.00"));
        assertEquals("0.00", underTest.getBalance().toString());
        assertFalse(underTest.safeWithdrawal((new BigDecimal("500.00"))));
    }
}