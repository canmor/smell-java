import java.util.*;

class BankAccount {
    private double balance;
    private List<String> transactions;
    private String accountType;
    
    public BankAccount(double balance, String accountType) {
        this.balance = balance;
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
    }
    
    public double getBalance() { return balance; }
    public List<String> getTransactions() { return transactions; }
    public String getAccountType() { return accountType; }
    public void setBalance(double balance) { this.balance = balance; }
}

class TransferService {
    public void transfer(BankAccount fromAccount, BankAccount toAccount, double amount) {
        fromAccount.getTransactions().add("Transfer out: $" + amount);
        toAccount.getTransactions().add("Transfer in: $" + amount);
        
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
    }
}

class AuditService {
    public void auditAccount(BankAccount account) {
        account.getTransactions().add("Audit completed");
        
        if (account.getBalance() < 0) {
            account.getTransactions().add("Overdraft detected");
        }
    }
}

class ReportService {
    public void generateStatement(BankAccount account) {
        account.getTransactions().add("Statement generated");
        
        for (String transaction : account.getTransactions()) {
            if (transaction.contains("Transfer")) {
                account.getTransactions().add("Transfer fee applied");
                break;
            }
        }
    }
}
