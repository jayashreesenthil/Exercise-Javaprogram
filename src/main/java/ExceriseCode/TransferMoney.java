package ExceriseCode;

import java.math.BigDecimal;

class Account {
    private String accountId;
    private BigDecimal balance;

    public Account(String accountId, BigDecimal balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public boolean withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            return true;
        }
        return false;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}

public class TransferMoney {

    public static void main(String[] args) {
        Account account1 = new Account("A001", new BigDecimal("1000.00"));
        Account account2 = new Account("A002", new BigDecimal("500.00"));

        boolean result = transfer(account1, account2, new BigDecimal("300.00"));
        System.out.println("Transfer status: " + result);
    }

    public static boolean transfer(Account fromAccount, Account toAccount, BigDecimal amount) {
        try {
            if (amount.compareTo(BigDecimal.ZERO) > 0) {
                boolean withdrawalSuccess = fromAccount.withdraw(amount);

                if (withdrawalSuccess) {
                    toAccount.deposit(amount);
                    System.out.println("Transfer successful: " + amount + " from " + fromAccount.getAccountId() + " to " + toAccount.getAccountId());
                    System.out.println(fromAccount.getAccountId() + " new balance: " + fromAccount.getBalance());
                    System.out.println(toAccount.getAccountId() + " new balance: " + toAccount.getBalance());
                    return true;
                } else {
                    System.out.println("Transfer failed: Withdrawal failed from " + fromAccount.getAccountId());
                    return false;
                }
            } else {
                System.out.println("Transfer amount must be positive.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Transfer failed due to error: " + e.getMessage());
            return false;
        }
    }
}
