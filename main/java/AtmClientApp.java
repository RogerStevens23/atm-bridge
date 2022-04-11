import java.math.BigDecimal;
import java.util.Objects;
import java.util.Scanner;

public class AtmClientApp {
    public static void main(String[] args) {
        boolean exit = false;
        Atm atm = new Atm("1234", getBigDecimal("500.00"));
        requirePin(atm);
        while (!exit) {
            System.out.println("--------------------------------");
            System.out.println("Please select an option:");
            System.out.println("--------------------------------");
            System.out.println("Press 1 to deposit funds.");
            System.out.println("Press 2 to withdrawal funds.");
            System.out.println("Press 3 to check balance.");
            System.out.println("press 4 to exit.");
            System.out.println("--------------------------------");
            String userInput = getUserString();

            if (Objects.equals(userInput, "1")) {
                enterDepositAmount(atm);
                System.out.println("Balance: " + atm.getBalance());
            } else if (Objects.equals(userInput, "2")) {
                enterWithdrawalAmount(atm);
                System.out.println("Balance: " + atm.getBalance());
            } else if (Objects.equals(userInput, "3")) {
                System.out.println("Current balance: " + atm.getBalance());
            }
            if (Objects.equals(userInput, "4")) {
                exit = true;
                System.out.println("Goodbye!");
            }
        }
    }

    public static String getUserString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();q
    }

    public static BigDecimal getBigDecimal(String str) {
        return new BigDecimal(str);
    }

    public static void requirePin(Atm atm) {
        boolean correctPin = false;
        while (!correctPin) {
            System.out.println("Please enter PIN:");
            if (atm.allowAccess(getUserString())) {
                System.out.println("Welcome to the bank of Roger!");
                correctPin = true;
            } else
                System.out.println("Incorrect, please try again...");
        }
    }

    public static void enterDepositAmount(Atm atm) {
        System.out.println("Please enter an amount to deposit:");
        atm.deposit(getBigDecimal(getUserString()));
    }

    public static void enterWithdrawalAmount(Atm atm) {
        System.out.println("Please enter an amount to withdrawal:");
        BigDecimal userAmount = getBigDecimal(getUserString());
        if (atm.safeWithdrawal(userAmount))
            atm.withdrawal(userAmount);
        else
            System.out.println("Not enough funds!");
    }
}