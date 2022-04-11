import java.math.BigDecimal;
import java.util.Objects;

public class Atm {
    // Fields
    private String requiredPin = "";
    private BigDecimal balance;

    // Getters
    public String getRequiredPin() {
        return requiredPin;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    // Constructors
    public Atm(String requiredPin, BigDecimal startingBalance) {
        this.requiredPin = requiredPin;
        this.balance = startingBalance;
    }

    // Methods
    public boolean allowAccess(String enteredPin) {
        return Objects.equals(enteredPin, requiredPin);
    }

    public void deposit(BigDecimal amount) {
        this.balance = balance.add(amount);
    }

    public void withdrawal(BigDecimal amount) {
        if (safeWithdrawal(amount))
            this.balance = balance.subtract(amount);
    }

    public boolean safeWithdrawal(BigDecimal amount) {
        return balance.compareTo(amount) >= 0;
    }
}