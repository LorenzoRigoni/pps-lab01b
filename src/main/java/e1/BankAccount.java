package e1;

public interface BankAccount {
    /**
     * Get the balance of the account.
     *
     * @return The total balance
     */
    int getBalance();

    /**
     * Deposit an amount on the account.
     *
     * @param amount The amount to deposit
     */
    void deposit(int amount);

    /**
     * Withdraw an amount from the account.
     *
     * @param amount The amount to withdraw
     */
    void withdraw(int amount);
}
