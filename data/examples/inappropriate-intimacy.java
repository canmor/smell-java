class BankAccount {
    // Package-private fields allow inappropriate access
    double balance;
    String accountNumber;
    String ownerName;
    
    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    
    public void setBalance(double balance) { this.balance = balance; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
}

class Transaction {
    private BankAccount fromAccount;
    private BankAccount toAccount;
    private double amount;
    
    public void execute() {
        // Direct access to BankAccount's package-private members
        if (fromAccount.balance >= amount) {
            fromAccount.balance -= amount;
            toAccount.balance += amount;
        }
    }
    
    // Knows BankAccount's internal implementation details
    public boolean isValidAccount(BankAccount account) {
        return account.accountNumber.length() == 10 &&
               account.balance >= 0 &&
               account.ownerName != null && !account.ownerName.isEmpty();
    }
    
    // Direct manipulation of private data
    public void adjustBalance(BankAccount account, double adjustment) {
        account.balance += adjustment;
    }
    
    public void setAccounts(BankAccount from, BankAccount to) {
        this.fromAccount = from;
        this.toAccount = to;
    }
    
    public void setAmount(double amount) { this.amount = amount; }
}

class AccountManager {
    // Also directly accesses package-private members
    public void freezeAccount(BankAccount account) {
        account.balance = 0; // Direct modification of package-private member
    }
    
    public boolean canTransfer(BankAccount from, BankAccount to, double amount) {
        return from.balance >= amount && 
               !from.accountNumber.equals(to.accountNumber);
    }
}
